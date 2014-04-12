package fr.assoba.open.sel.engine;

import java.util.ArrayList;
import java.util.List;

public class Entity extends Annotated {
  private List<Property> propertyList = new ArrayList<>();

  public List<Property> getPropertyList() {
    return propertyList;
  }

  public void setPropertyList(List<Property> propertyList) {
    this.propertyList = propertyList;
  }

  @Override
  public String toString() {
    return "Entity[" + getName()+ "]";
  }
}
