/*
 * Copyright 2014 Josselin Pujo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.assoba.open.sel.cli;

import fr.assoba.open.sel.engine.Namespace;
import fr.assoba.open.sel.engine.SELNode;
import fr.assoba.open.sel.engine.SELParser;
import fr.assoba.open.sel.generator.IO;
import fr.assoba.open.sel.generator.LanguageExecutor;
import fr.assoba.open.sel.generator.SimpleIO;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParsingResult;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    final Options options = new Options();
    CmdLineParser cmdLineParser = new CmdLineParser(options);
    try {
      cmdLineParser.parseArgument(args);
      final IO io = new SimpleIO(options.getOutputDir(), options.getSources());
      final SELParser parser = Parboiled.createParser(SELParser.class);
      final RecoveringParseRunner<SELNode> runner = new RecoveringParseRunner<>(parser.Root());
      for (File f : options.getSources()) {
        final Path path = f.toPath().toAbsolutePath();
        Files.walkFileTree(path, new FileVisitor<Path>() {
          @Override
          public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.getFileName().toString().endsWith(".sel")) {
              String fileName = path.relativize(file).toString();
              System.out.println("Transpiling " + fileName);
              ParsingResult<SELNode> parsed = runner.run(io.readFile(fileName));
              if (parsed.hasErrors()) {
                for (Object parseError : parsed.parseErrors) {
                  System.err.println(parseError.toString());
                  throw new IOException("Error parsing");
                }
              }
              ArrayList<Namespace> result = new ArrayList<>();
              for (fr.assoba.open.sel.engine.SELNode node : parsed.valueStack) {
                Namespace ns = (Namespace) node;
                result.add(ns);
              }
              try {
                LanguageExecutor.execute(result, io, options.getOutputLanguages());
              } catch (ScriptException e) {
                e.printStackTrace();
              }
            }
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
          }
        });
      }
    } catch (CmdLineException e) {
      System.err.println(e.getMessage());
      cmdLineParser.printUsage(System.err);
      System.err.println();
      return;
    }
  }
}
