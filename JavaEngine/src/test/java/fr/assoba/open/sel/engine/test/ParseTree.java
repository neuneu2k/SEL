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
import fr.assoba.open.sel.engine.SELParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParseTree {

  public static void main(String[] args) throws IOException {
    System.out.println(ParseTest());
  }

  public static List<Namespace> ParseTest() throws IOException {
    InputStream is = ParseTree.class.getResourceAsStream("/sample.sel");
    byte[] buffer = new byte[is.available()];
    is.read(buffer);
    String toParse = new String(buffer);
    return SELParser.parse(toParse);
  }
}
