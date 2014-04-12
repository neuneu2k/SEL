package fr.assoba.open.sel.engine;

public class Property extends Annotated{
  private TypeDecl type;

  public TypeDecl getType() {
    return type;
  }

  public void setType(TypeDecl type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Property[" + getName() + "]";
  }
}
