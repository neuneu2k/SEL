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

/* The following code was generated by JFlex 1.4.3 on 03/04/14 16:27 */

package fr.assoba.open.sel.jetbrains;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static fr.assoba.open.sel.jetbrains.SelType.*;


/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 03/04/14 16:27 from the specification file
 * <tt>P:/dev/workspace/SEL/JetbrainsPlugin/src/fr/assoba/open/sel/jetbrains/_SimpleLexer.flex</tt>
 */
public class _SimpleLexer implements FlexLexer {
  /**
   * lexical states
   */
  public static final int YYINITIAL = 0;
  /**
   * the current lexical state
   */
  private int zzLexicalState = YYINITIAL;
  /**
   * initial size of the lookahead buffer
   */
  private static final int ZZ_BUFFERSIZE = 16384;
  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   * at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
      0, 0
  };
  /**
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED =
      "\11\0\1\1\1\1\1\0\1\1\1\1\22\0\1\1\7\0\1\25" +
          "\1\26\4\0\1\23\1\0\12\22\1\36\5\0\1\24\32\21\1\34" +
          "\1\0\1\35\1\0\1\22\1\0\1\12\1\2\1\31\1\13\1\15" +
          "\1\11\1\10\1\21\1\5\2\21\1\4\1\27\1\6\1\3\1\30" +
          "\1\21\1\20\1\17\1\7\1\14\3\21\1\16\1\21\1\32\1\0" +
          "\1\33\uff82\0";
  /**
   * Translates characters to character classes
   */
  private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
  /**
   * Translates DFA states to action switch labels.
   */
  private static final int[] ZZ_ACTION = zzUnpackAction();
  private static final String ZZ_ACTION_PACKED_0 =
      "\1\0\1\1\1\2\11\3\1\1\1\4\1\5\1\3" +
          "\1\6\1\7\1\10\1\11\1\12\2\3\1\0\10\3" +
          "\1\13\3\3\1\14\2\3\1\15\5\3\1\0\1\16" +
          "\1\3\1\17\3\3\1\13\4\3\1\20\2\3\1\21";
  /**
   * Translates a state to a row index in the transition table
   */
  private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
  private static final String ZZ_ROWMAP_PACKED_0 =
      "\0\0\0\37\0\76\0\135\0\174\0\233\0\272\0\331" +
          "\0\370\0\u0117\0\u0136\0\u0155\0\u0174\0\37\0\37\0\u0193" +
          "\0\37\0\37\0\37\0\37\0\37\0\u01b2\0\u01d1\0\u01f0" +
          "\0\u020f\0\u022e\0\u024d\0\u026c\0\u028b\0\u02aa\0\u02c9\0\u02e8" +
          "\0\u0307\0\u0326\0\u0345\0\u0364\0\u0383\0\u03a2\0\u03c1\0\174" +
          "\0\u03e0\0\u03ff\0\u041e\0\u043d\0\u045c\0\u047b\0\174\0\u049a" +
          "\0\174\0\u04b9\0\u04d8\0\u04f7\0\37\0\u0516\0\u0535\0\u0554" +
          "\0\u0573\0\174\0\u0592\0\u05b1\0\174";
  /**
   * The transition table of the DFA
   */
  private static final int[] ZZ_TRANS = zzUnpackTrans();
  private static final String ZZ_TRANS_PACKED_0 =
      "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\5" +
          "\1\11\1\5\1\12\1\5\1\13\1\5\1\14\2\5" +
          "\2\2\1\15\1\16\1\17\1\20\2\5\1\21\1\22" +
          "\1\23\1\24\1\25\40\0\1\3\37\0\1\5\1\26" +
          "\12\5\1\27\4\5\1\30\3\0\3\5\7\0\21\5" +
          "\1\30\3\0\3\5\7\0\1\5\1\31\1\5\1\32" +
          "\15\5\1\30\3\0\3\5\7\0\4\5\1\33\14\5" +
          "\1\30\3\0\3\5\7\0\10\5\1\34\10\5\1\30" +
          "\3\0\3\5\7\0\2\5\1\35\16\5\1\30\3\0" +
          "\3\5\7\0\1\5\1\36\17\5\1\30\3\0\3\5" +
          "\7\0\4\5\1\37\14\5\1\30\3\0\3\5\7\0" +
          "\5\5\1\40\13\5\1\30\3\0\3\5\7\0\20\41" +
          "\5\0\3\41\7\0\10\5\1\42\10\5\1\30\3\0" +
          "\3\5\7\0\1\5\1\43\17\5\1\30\3\0\3\5" +
          "\7\0\5\5\1\44\13\5\1\30\3\0\3\5\7\0" +
          "\20\45\5\0\3\45\7\0\4\5\1\46\14\5\1\30" +
          "\3\0\3\5\7\0\15\5\1\47\3\5\1\30\3\0" +
          "\3\5\7\0\5\5\1\50\13\5\1\30\3\0\3\5" +
          "\7\0\21\5\1\30\3\0\1\51\2\5\7\0\1\5" +
          "\1\52\17\5\1\30\3\0\3\5\7\0\12\5\1\53" +
          "\6\5\1\30\3\0\3\5\7\0\5\5\1\54\13\5" +
          "\1\30\3\0\3\5\7\0\16\5\1\55\2\5\1\30" +
          "\3\0\3\5\7\0\21\41\2\0\1\56\1\0\3\41" +
          "\7\0\21\5\1\30\3\0\1\5\1\57\1\5\7\0" +
          "\2\5\1\50\16\5\1\30\3\0\3\5\7\0\13\5" +
          "\1\60\5\5\1\30\3\0\3\5\7\0\21\45\1\30" +
          "\3\0\3\45\7\0\6\5\1\50\12\5\1\30\3\0" +
          "\3\5\7\0\5\5\1\61\13\5\1\30\3\0\3\5" +
          "\7\0\13\5\1\62\5\5\1\30\3\0\3\5\7\0" +
          "\10\5\1\33\10\5\1\30\3\0\3\5\7\0\1\63" +
          "\20\5\1\30\3\0\3\5\7\0\3\5\1\64\15\5" +
          "\1\30\3\0\3\5\7\0\3\5\1\31\15\5\1\30" +
          "\3\0\3\5\5\0\26\56\1\65\10\56\2\0\15\5" +
          "\1\50\3\5\1\30\3\0\3\5\7\0\15\5\1\66" +
          "\3\5\1\30\3\0\3\5\7\0\2\5\1\67\16\5" +
          "\1\30\3\0\3\5\7\0\5\5\1\70\13\5\1\30" +
          "\3\0\3\5\7\0\21\5\1\30\3\0\1\5\1\71" +
          "\1\5\7\0\13\5\1\50\5\5\1\30\3\0\3\5" +
          "\7\0\14\5\1\72\4\5\1\30\3\0\3\5\7\0" +
          "\10\5\1\73\10\5\1\30\3\0\3\5\7\0\21\5" +
          "\1\30\3\0\2\5\1\74\7\0\13\5\1\75\5\5" +
          "\1\30\3\0\3\5\5\0";
  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
      "Unkown internal scanner error",
      "Error: could not match input",
      "Error: pushback value was too large"
  };
  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
  private static final String ZZ_ATTRIBUTE_PACKED_0 =
      "\1\0\1\11\13\1\2\11\1\1\5\11\2\1\1\0" +
          "\25\1\1\0\6\1\1\11\10\1";
  private static java.io.Reader zzReader = null; // Fake
  /**
   * the current state of the DFA
   */
  private int zzState;
  /**
   * this buffer contains the current text to be matched and is
   * the source of the yytext() string
   */
  private CharSequence zzBuffer = "";
  /**
   * this buffer may contains the current text array to be matched when it is cheap to acquire it
   */
  private char[] zzBufferArray;
  /**
   * the textposition at the last accepting state
   */
  private int zzMarkedPos;
  /**
   * the textposition at the last state to be included in yytext
   */
  private int zzPushbackPos;
  /**
   * the current text position in the buffer
   */
  private int zzCurrentPos;
  /**
   * startRead marks the beginning of the yytext() string in the buffer
   */
  private int zzStartRead;
  /**
   * endRead marks the last character in the buffer, that has been read
   * from input
   */
  private int zzEndRead;
  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;
  /**
   * zzAtEOF == true <=> the scanner is at the EOF
   */
  private boolean zzAtEOF;

  /* user code: */
  public _SimpleLexer() {
    this((java.io.Reader) null);
  }

  public _SimpleLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param in the java.io.Inputstream to read input from.
   */
  public _SimpleLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  private static int[] zzUnpackAction() {
    int[] result = new int[61];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int[] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static int[] zzUnpackRowMap() {
    int[] result = new int[61];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int[] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  private static int[] zzUnpackTrans() {
    int[] result = new int[1488];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int[] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static int[] zzUnpackAttribute() {
    int[] result = new int[61];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int[] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Unpacks the compressed character translation table.
   *
   * @param packed the packed character translation table
   * @return the unpacked character translation table
   */
  private static char[] zzUnpackCMap(String packed) {
    char[] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 104) {
      int count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return <code>false</code>, iff there was new input.
   * @throws java.io.IOException if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   * <p/>
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead + pos] : zzBuffer.charAt(zzStartRead + pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos - zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   * <p/>
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   * <p/>
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param errorCode the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   * <p/>
   * They will be read again by then next call of the scanning method
   *
   * @param number the number of characters to be read again.
   *               This number must not be greater than yylength()!
   */
  public void yypushback(int number) {
    if (number > yylength())
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return the next token
   * @throws java.io.IOException if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char[] zzCMapL = ZZ_CMAP;

    int[] zzTransL = ZZ_TRANS;
    int[] zzRowMapL = ZZ_ROWMAP;
    int[] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction:
      {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          } else {
            // store back cached positions
            zzCurrentPos = zzCurrentPosL;
            zzMarkedPos = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL = zzCurrentPos;
            zzMarkedPosL = zzMarkedPos;
            zzBufferL = zzBuffer;
            zzEndReadL = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            } else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ((zzAttributes & 1) == 1) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ((zzAttributes & 8) == 8) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 12: {
          return FQID;
        }
        case 18:
          break;
        case 7: {
          return RC;
        }
        case 19:
          break;
        case 14: {
          return MTK;
        }
        case 20:
          break;
        case 8: {
          return LB;
        }
        case 21:
          break;
        case 11: {
          return ANTK;
        }
        case 22:
          break;
        case 16: {
          return ETK;
        }
        case 23:
          break;
        case 4: {
          return LP;
        }
        case 24:
          break;
        case 13: {
          return TTK;
        }
        case 25:
          break;
        case 15: {
          return LTK;
        }
        case 26:
          break;
        case 9: {
          return RB;
        }
        case 27:
          break;
        case 5: {
          return RP;
        }
        case 28:
          break;
        case 2: {
          return com.intellij.psi.TokenType.WHITE_SPACE;
        }
        case 29:
          break;
        case 1: {
          return com.intellij.psi.TokenType.BAD_CHARACTER;
        }
        case 30:
          break;
        case 17: {
          return NSTK;
        }
        case 31:
          break;
        case 10: {
          return COLON;
        }
        case 32:
          break;
        case 3: {
          return ID;
        }
        case 33:
          break;
        case 6: {
          return LC;
        }
        case 34:
          break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
