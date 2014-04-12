/*
 * Copyright 2014 Josselin Pujo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
