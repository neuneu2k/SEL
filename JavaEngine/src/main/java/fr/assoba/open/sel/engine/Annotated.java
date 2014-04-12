package fr.assoba.open.sel.engine;

import java.util.ArrayList;
import java.util.List;

public abstract class  Annotated implements SELNode {

  private String name;
  private Annotations annotations=new Annotations();

  public Annotations getAnnotations() {
    return annotations;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAnnotations(Annotations annotations) {
    this.annotations = annotations;
  }
}
