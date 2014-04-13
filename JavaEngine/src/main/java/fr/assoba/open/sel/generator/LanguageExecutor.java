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

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.assoba.open.sel.engine.Namespace;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageExecutor {
  private static Map<String, JavaGenerator> generatorMap = new HashMap<>();

  public static void RegisterLanguage(String name, JavaGenerator generator) {
    generatorMap.put(name, generator);
  }

  static {
    RegisterLanguage("json", new JSONGenerator());
    RegisterLanguage("xml", new XMLGenerator());
  }

  public static void execute(List<Namespace> namespaceList, IO io, String... languages) throws IOException, ScriptException {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine jsEngine = factory.getEngineByName("JavaScript");
    jsEngine.put("IO", io);
    jsEngine.eval(io.readFile("underscore.js"));
    ObjectMapper mapper = new ObjectMapper();
    jsEngine.eval("namespaces=" + mapper.writeValueAsString(namespaceList));
    for (String lang : languages) {
      if (generatorMap.containsKey(lang)) {
        generatorMap.get(lang).generate(namespaceList, io);
      } else {
        jsEngine.eval(io.readFile(lang + ".js"));
      }
    }
  }
}
