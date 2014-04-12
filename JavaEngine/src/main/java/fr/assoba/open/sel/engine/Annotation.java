package fr.assoba.open.sel.engine;

public class Annotation implements SELNode {
  private String name;
  private String value;

  public Annotation() {}

  public Annotation(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Annotation{" +
        "name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
