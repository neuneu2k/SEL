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
import com.intellij.psi.util.PsiTreeUtil;
import fr.assoba.open.sel.jetbrains.psi.SELAnnotation;
import fr.assoba.open.sel.jetbrains.psi.SELEntity;
import fr.assoba.open.sel.jetbrains.psi.SELNamespace;
import fr.assoba.open.sel.jetbrains.psi.SELVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static fr.assoba.open.sel.jetbrains.SelType.ID;

public class SELNamespaceImpl extends ASTWrapperPsiElement implements SELNamespace {

  public SELNamespaceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SELVisitor) ((SELVisitor) visitor).visitNamespace(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SELAnnotation> getAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SELAnnotation.class);
  }

  @Override
  @NotNull
  public List<SELEntity> getEntityList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SELEntity.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
