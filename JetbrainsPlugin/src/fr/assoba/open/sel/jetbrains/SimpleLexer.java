package fr.assoba.open.sel.jetbrains;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SimpleLexer extends FlexAdapter {
  public SimpleLexer() {
    super(new _SimpleLexer((Reader) null));
  }
}
