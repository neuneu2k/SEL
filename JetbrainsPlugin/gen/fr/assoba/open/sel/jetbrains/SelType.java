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

// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
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
      } else if (type == ENTITY) {
        return new SELEntityImpl(node);
      } else if (type == FQIDENTIFIER) {
        return new SELFqidentifierImpl(node);
      } else if (type == LIST) {
        return new SELListImpl(node);
      } else if (type == MAP) {
        return new SELMapImpl(node);
      } else if (type == NAMESPACE) {
        return new SELNamespaceImpl(node);
      } else if (type == PROP) {
        return new SELPropImpl(node);
      } else if (type == TYPE_ID) {
        return new SELTypeIdImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
