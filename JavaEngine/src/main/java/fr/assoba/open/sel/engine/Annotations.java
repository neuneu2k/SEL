package fr.assoba.open.sel.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Annotations implements SELNode {
  private List<Annotation> annotations=new ArrayList<>();

  public Iterator<Annotation> getAnnotations() {
    return annotations.iterator();
  }

  public void addAnnotation(Annotation annotation) {
    this.annotations.add(annotation);
  }

  @Override
  public String toString() {
    return "Annotations{" +
        "annotations=" + annotations +
        '}';
  }
}
