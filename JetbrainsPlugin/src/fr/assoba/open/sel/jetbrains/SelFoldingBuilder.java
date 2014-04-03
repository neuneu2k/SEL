package fr.assoba.open.sel.jetbrains;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelFoldingBuilder implements FoldingBuilder{
  @NotNull
  @Override
  public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode astNode, @NotNull Document document) {
    return new FoldingDescriptor[0];
  }

  @Nullable
  @Override
  public String getPlaceholderText(@NotNull ASTNode astNode) {
    return null;
  }

  @Override
  public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
    return false;
  }
}
