package fr.assoba.open.sel.jetbrains;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SelTokenType extends IElementType {
  public SelTokenType(@NotNull @NonNls String debugName) {
    super(debugName, SelLanguage.INSTANCE);
  }
}
