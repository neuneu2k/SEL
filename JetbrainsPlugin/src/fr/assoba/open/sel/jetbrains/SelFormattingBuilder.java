package fr.assoba.open.sel.jetbrains;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelFormattingBuilder implements FormattingModelBuilder {
  private static final Logger log = Logger.getInstance(SelFormattingBuilder.class);

  @NotNull
  @Override
  public FormattingModel createModel(PsiElement psiElement, CodeStyleSettings codeStyleSettings) {
    return FormattingModelProvider.createFormattingModelForPsiFile(psiElement.getContainingFile(), new SelBlock(psiElement.getNode(), Wrap.createWrap(WrapType.NORMAL, false), Alignment.createAlignment()), codeStyleSettings);
  }

  @Nullable
  @Override
  public TextRange getRangeAffectingIndent(PsiFile psiFile, int i, ASTNode astNode) {
    return null;
  }
}
