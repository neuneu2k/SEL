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
  public static final TextAttributesKey TYPEID = createTextAttributesKey("TYPEID", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey ENTITY = createTextAttributesKey("ENTITY", DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey NAME = createTextAttributesKey("PROPNAME", DefaultLanguageHighlighterColors.IDENTIFIER);

  private static final TextAttributesKey[] entity = new TextAttributesKey[]{ENTITY};
  private static final TextAttributesKey[] reserved = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] id = new TextAttributesKey[]{NAME};
  private static final TextAttributesKey[] typeId = new TextAttributesKey[]{TYPEID};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override

  public Lexer getHighlightingLexer() {
    return new SimpleLexer();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType elementType) {
    if(elementType.equals(SelType.NSTK)||elementType.equals(SelType.ETK)) {
      return reserved;
    } else if (elementType.equals(SelType.FQID)||elementType.equals(SelType.ID)) {
      return id;
    } else if(elementType.equals(SelType.TTK)||elementType.equals(SelType.LTK)||elementType.equals(SelType.MTK)) {
      return typeId;
    }
    return EMPTY_KEYS;
  }
}
