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

package fr.assoba.open.sel.engine.test;

import fr.assoba.open.sel.engine.Namespace;
import fr.assoba.open.sel.generator.IO;
import fr.assoba.open.sel.generator.LanguageExecutor;
import fr.assoba.open.sel.generator.SimpleIO;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExportAll {
  public static void main(String[] args) throws IOException, ScriptException {
    IO io = new SimpleIO(new File(""));
    List<Namespace> namespaces = ParseTree.ParseTest();
    LanguageExecutor.execute(namespaces, io, "json", "xml", "SimpleJava", "SimpleCSharp");
  }
}
