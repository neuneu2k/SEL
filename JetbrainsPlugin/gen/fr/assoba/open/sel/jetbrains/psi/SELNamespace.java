// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SELNamespace extends PsiElement {

  @NotNull
  List<SELAnnotation> getAnnotationList();

  @NotNull
  List<SELEntity> getEntityList();

  @NotNull
  PsiElement getId();

}
