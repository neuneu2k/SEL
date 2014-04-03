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

public class SELPropImpl extends ASTWrapperPsiElement implements SELProp {

  public SELPropImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SELVisitor) ((SELVisitor)visitor).visitProp(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SELAnnotation> getAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SELAnnotation.class);
  }

  @Override
  @Nullable
  public SELFqidentifier getFqidentifier() {
    return findChildByClass(SELFqidentifier.class);
  }

  @Override
  @Nullable
  public SELTypeId getTypeId() {
    return findChildByClass(SELTypeId.class);
  }

}
