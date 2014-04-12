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

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SelSyntaxHighlighter extends SyntaxHighlighterBase {

  public static final TextAttributesKey KEYWORD = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
  private static final TextAttributesKey[] reserved = new TextAttributesKey[]{KEYWORD};
  public static final TextAttributesKey TYPEID = createTextAttributesKey("TYPEID", DefaultLanguageHighlighterColors.CONSTANT);
  private static final TextAttributesKey[] typeId = new TextAttributesKey[]{TYPEID};
  public static final TextAttributesKey ENTITY = createTextAttributesKey("ENTITY", DefaultLanguageHighlighterColors.CLASS_NAME);
  private static final TextAttributesKey[] entity = new TextAttributesKey[]{ENTITY};
  public static final TextAttributesKey NAME = createTextAttributesKey("PROPNAME", DefaultLanguageHighlighterColors.IDENTIFIER);
  private static final TextAttributesKey[] id = new TextAttributesKey[]{NAME};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override

  public Lexer getHighlightingLexer() {
    return new SimpleLexer();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType elementType) {
    if (elementType.equals(SelType.NSTK) || elementType.equals(SelType.ETK)) {
      return reserved;
    } else if (elementType.equals(SelType.FQID) || elementType.equals(SelType.ID)) {
      return id;
    } else if (elementType.equals(SelType.TTK) || elementType.equals(SelType.LTK) || elementType.equals(SelType.MTK)) {
      return typeId;
    }
    return EMPTY_KEYS;
  }
}
