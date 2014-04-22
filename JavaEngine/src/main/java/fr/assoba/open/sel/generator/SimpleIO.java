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

package fr.assoba.open.sel.generator;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

public class SimpleIO implements IO {
  private List<URL> templateSources;
  private File outputDir;

  public SimpleIO(File outputDir, File... templateSources) {
    this.outputDir = outputDir;
    this.templateSources = new ArrayList<>();
    URL here = SimpleIO.class.getResource("");
    this.templateSources.add(here);
    for (File f : templateSources) {
      try {
        this.templateSources.add(f.toURI().toURL());
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void writeFile(String file, String content) throws IOException {
    File output = new File(outputDir.getAbsoluteFile(), file).getAbsoluteFile();
    Files.createParentDirs(output);
    FileOutputStream fos = new FileOutputStream(output);
    fos.write(content.getBytes(UTF_8));
    fos.close();
  }

  @Override
  public void log(String logline) {
    System.out.println(logline);
  }

  @Override
  public String readFile(String file) throws IOException {
    for (URL u : templateSources) {
      try {
        URL fileUrl = new URL(u, file);
        InputStream is = fileUrl.openStream();
        String s = new String(ByteStreams.toByteArray(is), UTF_8);
        return s;
      } catch (java.io.IOException e) {
        continue;
      }
    }
    throw new IOException("File not found: " + file);
  }
}
