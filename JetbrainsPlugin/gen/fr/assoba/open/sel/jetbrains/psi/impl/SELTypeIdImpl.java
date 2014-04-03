// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static fr.assoba.open.sel.jetbrains.SelType.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import fr.assoba.open.sel.jetbrains.psi.*;

public class SELTypeIdImpl extends ASTWrapperPsiElement implements SELTypeId {

  public SELTypeIdImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SELVisitor) ((SELVisitor)visitor).visitTypeId(this);
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
