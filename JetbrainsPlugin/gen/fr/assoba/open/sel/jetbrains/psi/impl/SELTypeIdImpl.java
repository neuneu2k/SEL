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
package fr.assoba.open.sel.jetbrains.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import fr.assoba.open.sel.jetbrains.psi.SELList;
import fr.assoba.open.sel.jetbrains.psi.SELMap;
import fr.assoba.open.sel.jetbrains.psi.SELTypeId;
import fr.assoba.open.sel.jetbrains.psi.SELVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static fr.assoba.open.sel.jetbrains.SelType.TTK;

public class SELTypeIdImpl extends ASTWrapperPsiElement implements SELTypeId {

  public SELTypeIdImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SELVisitor) ((SELVisitor) visitor).visitTypeId(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SELList getList() {
    return findChildByClass(SELList.class);
  }

  @Override
  @Nullable
  public SELMap getMap() {
    return findChildByClass(SELMap.class);
  }

  @Override
  @Nullable
  public PsiElement getTtk() {
    return findChildByType(TTK);
  }

}
