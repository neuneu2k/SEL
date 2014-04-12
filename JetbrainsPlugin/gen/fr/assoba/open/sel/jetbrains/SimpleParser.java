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

// This is a generated file. Not intended for manual editing.
package fr.assoba.open.sel.jetbrains;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.tree.IElementType;

import static fr.assoba.open.sel.jetbrains.SelParserUtil.*;
import static fr.assoba.open.sel.jetbrains.SelType.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("fr.assoba.open.sel.jetbrains.SimpleParser");
  final static Parser ns_statement_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return ns_statement_recover(builder_, level_ + 1);
    }
  };

  /* ********************************************************** */
  // ANTK
  public static boolean annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation")) return false;
    if (!nextTokenIs(builder_, ANTK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ANTK);
    exit_section_(builder_, marker_, ANNOTATION, result_);
    return result_;
  }

  /* ********************************************************** */
  // list | map
  static boolean collection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "collection")) return false;
    if (!nextTokenIs(builder_, "", LTK, MTK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = list(builder_, level_ + 1);
    if (!result_) result_ = map(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // entity_stmt
  public static boolean entity(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity")) return false;
    if (!nextTokenIs(builder_, "<entity>", ANTK, ETK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<entity>");
    result_ = entity_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ENTITY, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // annotation* ETK  ID LC prop* RC
  static boolean entity_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_stmt")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = entity_stmt_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 3, ETK, ID, LC);
    pinned_ = result_; // pin = LC
    result_ = result_ && report_error_(builder_, entity_stmt_4(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RC) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  // annotation*
  private static boolean entity_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_stmt_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "entity_stmt_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // prop*
  private static boolean entity_stmt_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_stmt_4")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!prop(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "entity_stmt_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // FQID
  public static boolean fqidentifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fqidentifier")) return false;
    if (!nextTokenIs(builder_, FQID)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FQID);
    exit_section_(builder_, marker_, FQIDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // LTK LB type RB
  public static boolean list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "list")) return false;
    if (!nextTokenIs(builder_, LTK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, LTK, LB);
    result_ = result_ && type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RB);
    exit_section_(builder_, marker_, LIST, result_);
    return result_;
  }

  /* ********************************************************** */
  // MTK LB type RB
  public static boolean map(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map")) return false;
    if (!nextTokenIs(builder_, MTK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, MTK, LB);
    result_ = result_ && type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RB);
    exit_section_(builder_, marker_, MAP, result_);
    return result_;
  }

  /* ********************************************************** */
  // ns_statement
  public static boolean namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "namespace")) return false;
    if (!nextTokenIs(builder_, "<namespace>", ANTK, NSTK)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<namespace>");
    result_ = ns_statement(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, NAMESPACE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // annotation* NSTK ID LC entity* RC
  static boolean ns_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ns_statement")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = ns_statement_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 3, NSTK, ID, LC);
    pinned_ = result_; // pin = LC
    result_ = result_ && report_error_(builder_, ns_statement_4(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RC) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, ns_statement_recover_parser_);
    return result_ || pinned_;
  }

  // annotation*
  private static boolean ns_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ns_statement_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ns_statement_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // entity*
  private static boolean ns_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ns_statement_4")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!entity(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ns_statement_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // !(RC)
  static boolean ns_statement_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ns_statement_recover")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !consumeToken(builder_, RC);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // annotation*  ID COLON type
  public static boolean prop(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "prop")) return false;
    if (!nextTokenIs(builder_, "<prop>", ANTK, ID)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<prop>");
    result_ = prop_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, ID, COLON);
    result_ = result_ && type(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, PROP, result_, false, null);
    return result_;
  }

  // annotation*
  private static boolean prop_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "prop_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!annotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "prop_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // ETK|NSTK|TTK|LTK|MTK
  static boolean reserved(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reserved")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ETK);
    if (!result_) result_ = consumeToken(builder_, NSTK);
    if (!result_) result_ = consumeToken(builder_, TTK);
    if (!result_) result_ = consumeToken(builder_, LTK);
    if (!result_) result_ = consumeToken(builder_, MTK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // namespace*
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!namespace(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "root", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // typeId | ID |fqidentifier !reserved
  static boolean type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = typeId(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, ID);
    if (!result_) result_ = type_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // fqidentifier !reserved
  private static boolean type_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = fqidentifier(builder_, level_ + 1);
    result_ = result_ && type_2_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !reserved
  private static boolean type_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type_2_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !reserved(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TTK | collection
  public static boolean typeId(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "typeId")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<type id>");
    result_ = consumeToken(builder_, TTK);
    if (!result_) result_ = collection(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TYPE_ID, result_, false, null);
    return result_;
  }

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ANNOTATION) {
      result_ = annotation(builder_, 0);
    } else if (root_ == ENTITY) {
      result_ = entity(builder_, 0);
    } else if (root_ == FQIDENTIFIER) {
      result_ = fqidentifier(builder_, 0);
    } else if (root_ == LIST) {
      result_ = list(builder_, 0);
    } else if (root_ == MAP) {
      result_ = map(builder_, 0);
    } else if (root_ == NAMESPACE) {
      result_ = namespace(builder_, 0);
    } else if (root_ == PROP) {
      result_ = prop(builder_, 0);
    } else if (root_ == TYPE_ID) {
      result_ = typeId(builder_, 0);
    } else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return root(builder_, level_ + 1);
  }
}
