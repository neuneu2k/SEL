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

import org.kohsuke.args4j.Option;

import java.io.File;


public class Options {
  @Option(name = "-out", usage = "Select the directory where output files will be generated", required = true)
  private File outputDir = new File(".");
  @Option(name = "-include", usage = "Select the directories where input .sel files and templates can be found", required = false)
  private File[] sources = new File[]{new File(".")};
  @Option(name = "-lang", usage = "Select the output languages", required = false)
  private String[] outputLanguages = {"json", "xml"};

  public File getOutputDir() {
    return outputDir;
  }

  public void setOutputDir(File outputDir) {
    this.outputDir = outputDir;
  }

  public File[] getSources() {
    return sources;
  }

  public void setSources(File[] sources) {
    this.sources = sources;
  }

  public String[] getOutputLanguages() {
    return outputLanguages;
  }

  public void setOutputLanguages(String[] outputLanguages) {
    this.outputLanguages = outputLanguages;
  }

}
