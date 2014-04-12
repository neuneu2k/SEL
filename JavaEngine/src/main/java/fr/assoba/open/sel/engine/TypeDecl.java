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

import java.util.HashMap;
import java.util.Map;

public class TypeDecl implements SELNode {
  private Scalar scalar;
  private String typeRef;
  private DeclType type;
  public TypeDecl() {
  }

  public void setTypeRef(DeclType d, String typeRef) {
    this.type = d;
    this.typeRef = typeRef;
  }

  public void setTypeRefType(DeclType d) {
    this.type = d;
  }

  public Scalar getScalar() {
    return scalar;
  }

  public void setScalar(Scalar s) {
    this.type = DeclType.SCALAR;
    this.scalar = s;
  }

  public String getTypeRef() {
    return typeRef;
  }

  public void setTypeRef(String typeRef) {
    this.type = DeclType.REF;
    this.typeRef = typeRef;
  }

  public DeclType getType() {
    return type;
  }

  public static enum Scalar {
    BOOL("bool"), INT("int"), LONG("long"), FLOAT("float"), DOUBLE("double"), BYTES("bytes"), STRING("string");
    private static Map<String, Scalar> names = new HashMap<>();
    static {
      for (Scalar scalar : Scalar.values()) {
        names.put(scalar.getName(), scalar);
      }
    }
    private String name;

    Scalar(String name) {
      this.name = name;
    }

    public static Scalar fromName(String name) {
      return names.get(name);
    }

    public static String[] getNames() {
      return names.keySet().toArray(new String[]{});
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Scalar{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  public static enum DeclType {
    SCALAR, REF, LIST, MAP
  }


}
