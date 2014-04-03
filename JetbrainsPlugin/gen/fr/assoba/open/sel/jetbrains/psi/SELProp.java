// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SELProp extends PsiElement {

  @NotNull
  List<SELAnnotation> getAnnotationList();

  @Nullable
  SELFqidentifier getFqidentifier();

  @Nullable
  SELTypeId getTypeId();

}
