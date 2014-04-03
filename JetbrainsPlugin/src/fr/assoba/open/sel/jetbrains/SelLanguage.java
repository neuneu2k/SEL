package fr.assoba.open.sel.jetbrains;

import com.intellij.lang.Language;

public class SelLanguage extends Language {

  public static final SelLanguage INSTANCE = new SelLanguage();

  protected SelLanguage() {
    super("sel");
  }
}
