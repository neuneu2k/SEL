// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SELVisitor extends PsiElementVisitor {

  public void visitAnnotation(@NotNull SELAnnotation o) {
    visitPsiElement(o);
  }

  public void visitEntity(@NotNull SELEntity o) {
    visitPsiElement(o);
  }

  public void visitFqidentifier(@NotNull SELFqidentifier o) {
    visitPsiElement(o);
  }

  public void visitList(@NotNull SELList o) {
    visitPsiElement(o);
  }

  public void visitMap(@NotNull SELMap o) {
    visitPsiElement(o);
  }

  public void visitNamespace(@NotNull SELNamespace o) {
    visitPsiElement(o);
  }

  public void visitProp(@NotNull SELProp o) {
    visitPsiElement(o);
  }

  public void visitTypeId(@NotNull SELTypeId o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
