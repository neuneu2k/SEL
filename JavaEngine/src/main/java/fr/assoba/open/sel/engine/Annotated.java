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

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public abstract class Annotated implements SELNode {

  private String name;
  private Annotations annotations = new Annotations();

  @JsonGetter
  public Annotation[] annotations() {
    return annotations.getAnnotations();
  }

  @XmlElement(name = "annotation")
  public Annotation[] getAnnotationArray() {
    return annotations.getAnnotations();
  }

  public Annotations getAnnotations() {
    return annotations;
  }

  @XmlAttribute(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
