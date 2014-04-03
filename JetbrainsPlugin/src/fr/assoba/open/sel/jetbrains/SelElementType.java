package fr.assoba.open.sel.jetbrains;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelElementType extends IElementType {
  public SelElementType(@NotNull @NonNls String debugName) {
    super(debugName, SelLanguage.INSTANCE);
  }
}
