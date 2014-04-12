package fr.assoba.open.sel.engine;

import java.util.HashMap;
import java.util.Map;

public class TypeDecl implements SELNode {
  public static enum Scalar {
    BOOL("bool"), INT("int"), LONG("long"), FLOAT("float"), DOUBLE("double"), BYTES("bytes"), STRING("string");

    private String name;

    Scalar(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    private static Map<String, Scalar> names = new HashMap<>();

    static {
      for (Scalar scalar : Scalar.values()) {
        names.put(scalar.getName(), scalar);
      }
    }

    public static Scalar fromName(String name) {
      return names.get(name);
    }

    public static String[] getNames() {
      return names.keySet().toArray(new String[]{});
    }


    @Override
    public String toString() {
      return "Scalar{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  private Scalar scalar;
  private String typeRef;
  private DeclType type;

  public static enum DeclType {
    SCALAR, REF, LIST, MAP
  }


  public TypeDecl() {
  }

  ;

  public void setScalar(Scalar s) {
    this.type = DeclType.SCALAR;
    this.scalar = s;
  }

  public void setTypeRef(DeclType d, String typeRef) {
    this.type = d;
    this.typeRef = typeRef;
  }

  public void setTypeRef(String typeRef) {
    this.type = DeclType.REF;
    this.typeRef = typeRef;
  }

  public void setTypeRefType(DeclType d) {
    this.type = d;
  }

  public TypeDecl(Scalar s) {
    setScalar(s);
  }

  public TypeDecl(DeclType declType, String typeRef) {
    setTypeRef(declType, typeRef);
  }

}
