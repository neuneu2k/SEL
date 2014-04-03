package fr.assoba.open.sel.jetbrains;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SelFileType extends LanguageFileType {

  public static final SelFileType INSTANCE = new SelFileType();

  protected SelFileType() {
    super(SelLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "SEL File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Simple Entity Language File";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "sel";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return null;
  }
}
