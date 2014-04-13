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

import fr.assoba.open.sel.engine.Namespace;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class XMLGenerator implements JavaGenerator {
  @Override
  public void generate(List<Namespace> namespaces, IO io) throws IOException {
    try {
      JAXBContext context = JAXBContext.newInstance(Namespace.class);
      Marshaller m = context.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      for (Namespace namespace : namespaces) {
        StringWriter sw = new StringWriter();
        m.marshal(namespace, sw);
        io.writeFile(namespace.getName() + ".xml", sw.toString());
      }
    } catch (JAXBException e) {
      throw new IOException(e.getMessage(), e);
    }
  }
}
