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

package fr.assoba.open.sel.jetbrains;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.common.AbstractBlock;
import fr.assoba.open.sel.jetbrains.psi.SELEntity;
import fr.assoba.open.sel.jetbrains.psi.SELNamespace;
import fr.assoba.open.sel.jetbrains.psi.SELProp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SelBlock extends AbstractBlock {

  private static final Logger log = Logger.getInstance(SelBlock.class);
  private Alignment alignement;

  public SelBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment) {
    super(node, wrap, alignment);
    this.alignement = alignment;
  }

  @Override
  protected List<Block> buildChildren() {
    if (isLeaf()) {
      return EMPTY;
    }
    ArrayList<Block> result = new ArrayList<>();
    for (ASTNode childNode = getNode().getFirstChildNode(); childNode != null; childNode = childNode.getTreeNext()) {
      if (!FormatterUtil.containsWhiteSpacesOnly(childNode)) {
        SelBlock block = new SelBlock(childNode, myWrap, getAlignment());
        result.add(block);
      }
    }
    return result;
  }

  public boolean isNode() {
    PsiElement element = myNode.getPsi();
    if (element instanceof SELProp) {
      return true;
    } else if (element instanceof SELEntity) {
      return true;
    } else if (element instanceof SELNamespace) {
      return true;
    }
    return false;
  }

  @Nullable
  @Override
  public Alignment getAlignment() {
    PsiElement element = myNode.getPsi();
    if (this.alignement.equals(super.getAlignment())) {
      if (isNode()) {
        this.alignement = Alignment.createAlignment();
      }
    }
    return this.alignement;
  }

  @Override
  public Indent getIndent() {
    PsiElement element = myNode.getPsi();
    if (isNode()) {
      return Indent.getIndent(Indent.Type.NORMAL, true, true);
    }
    return Indent.getNoneIndent();
  }

  @Nullable
  @Override
  public Spacing getSpacing(@Nullable Block block, @NotNull Block block2) {
    if (block != null) {
      if (block instanceof SelBlock) {
        if (((SelBlock) block).isNode()) {
          return Spacing.createSpacing(0, 1, 1, true, 1);
        }
      }
      if (block2 instanceof SelBlock) {
        if (((SelBlock) block2).isNode()) {
          return Spacing.createSpacing(0, 1, 1, true, 1);
        }
      }
    }
    return Spacing.createSafeSpacing(false, 0);
  }

  @Override
  public boolean isLeaf() {
    return myNode.getFirstChildNode() == null;
  }
}
