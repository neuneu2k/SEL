package fr.assoba.open.sel.engine;

import java.util.ArrayList;
import java.util.List;

public class Namespace extends Annotated {
  private List<Entity> entityList = new ArrayList<>();

  public List<Entity> getEntityList() {
    return entityList;
  }

  public void setEntityList(List<Entity> entityList) {
    this.entityList = entityList;
  }

  @Override
  public String toString() {
    return "Namespace[" + getName() + "]";
  }
}
