package fr.assoba.open.sel.jetbrains;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class SelFile extends PsiFileBase {

  protected SelFile(@NotNull FileViewProvider fileViewProvider) {
    super(fileViewProvider, SelLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return SelFileType.INSTANCE;
  }
}
