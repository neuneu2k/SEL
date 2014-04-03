// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import fr.assoba.open.sel.jetbrains.psi.impl.*;

public interface SelType {

  IElementType ANNOTATION = new SelElementType("ANNOTATION");
  IElementType ENTITY = new SelElementType("ENTITY");
  IElementType FQIDENTIFIER = new SelElementType("FQIDENTIFIER");
  IElementType LIST = new SelElementType("LIST");
  IElementType MAP = new SelElementType("MAP");
  IElementType NAMESPACE = new SelElementType("NAMESPACE");
  IElementType PROP = new SelElementType("PROP");
  IElementType TYPE_ID = new SelElementType("TYPE_ID");

  IElementType ANTK = new SelTokenType("ANTK");
  IElementType COLON = new SelTokenType(":");
  IElementType ETK = new SelTokenType("entity");
  IElementType FQID = new SelTokenType("FQID");
  IElementType ID = new SelTokenType("ID");
  IElementType LB = new SelTokenType("[");
  IElementType LC = new SelTokenType("{");
  IElementType LP = new SelTokenType("(");
  IElementType LTK = new SelTokenType("list");
  IElementType MTK = new SelTokenType("map");
  IElementType NSTK = new SelTokenType("namespace");
  IElementType RB = new SelTokenType("]");
  IElementType RC = new SelTokenType("}");
  IElementType RP = new SelTokenType(")");
  IElementType TTK = new SelTokenType("TTK");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ANNOTATION) {
        return new SELAnnotationImpl(node);
      }
      else if (type == ENTITY) {
        return new SELEntityImpl(node);
      }
      else if (type == FQIDENTIFIER) {
        return new SELFqidentifierImpl(node);
      }
      else if (type == LIST) {
        return new SELListImpl(node);
      }
      else if (type == MAP) {
        return new SELMapImpl(node);
      }
      else if (type == NAMESPACE) {
        return new SELNamespaceImpl(node);
      }
      else if (type == PROP) {
        return new SELPropImpl(node);
      }
      else if (type == TYPE_ID) {
        return new SELTypeIdImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
