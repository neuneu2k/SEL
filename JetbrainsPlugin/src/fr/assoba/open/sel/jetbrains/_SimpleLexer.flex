package fr.assoba.open.sel.jetbrains;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static fr.assoba.open.sel.jetbrains.SelType.*;

%%

%{
  public _SimpleLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SimpleLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

TTK=bool|int|long|float|double|bytes|string
ID=[a-zA-Z]([a-zA-Z0-9_]*)
FQID=[a-zA-Z]([a-zA-Z0-9_]*)(\.[a-zA-Z]([a-zA-Z0-9_]*))*
ANTK=@[a-zA-Z]([a-zA-Z0-9_]*)(\([^\)]*\))?

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "namespace"        { return NSTK; }
  "entity"           { return ETK; }
  "list"             { return LTK; }
  "map"              { return MTK; }
  "{"                { return LC; }
  "}"                { return RC; }
  "("                { return LP; }
  ")"                { return RP; }
  "["                { return LB; }
  "]"                { return RB; }
  ":"                { return COLON; }

  {TTK}              { return TTK; }
  {ID}               { return ID; }
  {FQID}             { return FQID; }
  {ANTK}             { return ANTK; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
