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

package fr.assoba.open.sel.engine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "namespace")
public class Namespace extends Annotated {
  private List<Entity> entityList = new ArrayList<>();

  @XmlElement(name = "entity")
  public List<Entity> getEntityList() {
    return entityList;
  }

  public Entity[] entities() {
    return entityList.toArray(new Entity[]{});
  }

  @Override
  public String toString() {
    return "Namespace[" + getName() + "]";
  }
}
