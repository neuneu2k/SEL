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

package fr.assoba.open.sel.engine;

import org.parboiled.*;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.annotations.SuppressNode;
import org.parboiled.annotations.SuppressSubnodes;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParsingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@BuildParseTree
public class SELParser<SELNode> extends BaseParser<SELNode> {

  public Action<SELNode> PushNamespace = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      push((SELNode) new Namespace());
      return true;
    }
  };
  public Action<SELNode> PushEntity = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Entity e = new Entity();
      push((SELNode) e);
      return true;
    }
  };
  public Action<SELNode> PopEntity = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Entity e = (Entity) pop();
      Namespace n = (Namespace) pop();
      n.getEntityList().add(e);
      push((SELNode) n);
      return true;
    }
  };
  public Action<SELNode> PushProperty = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Property p = new Property();
      push((SELNode) p);
      return true;
    }
  };
  public Action<SELNode> PopProperty = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Property p = (Property) pop();
      Entity e = (Entity) pop();
      push((SELNode) e);
      e.getPropertyList().add(p);
      return true;
    }
  };
  public Action<SELNode> PushTypeDecl = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      TypeDecl d = new TypeDecl();
      push((SELNode) d);
      return true;
    }
  };
  public Action<SELNode> PopTypeDecl = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      TypeDecl t = (TypeDecl) pop();
      Property p = (Property) pop();
      push((SELNode) p);
      p.setType(t);
      return true;
    }
  };
  public Action<SELNode> PushAnnotation = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Annotation a = new Annotation();
      push((SELNode) a);
      return true;
    }
  };
  public Action<SELNode> PopAnnotation = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Annotation a = (Annotation) pop();
      Annotated p = (Annotated) pop();
      push((SELNode) p);
      p.getAnnotations().addAnnotation(a);
      return true;
    }
  };
  public Action<SELNode> SetName = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Annotated o = (Annotated) pop();
      push((SELNode) o);
      o.setName(selNodeContext.getMatch());
      return true;
    }
  };

  public Rule Root() {
    return ZeroOrMore(Sequence(Space(), Namespace(), Space()));
  }

  public Rule Namespace() {
    return Sequence(PushNamespace, Annotations(), Space(), "namespace", Space(), Name(), Space(), '{', Space(), ZeroOrMore(Entity()), '}');
  }

  public Rule Entity() {
    return Sequence(PushEntity, Annotations(), "entity", Space(), Name(), Space(), '{', Space(), ZeroOrMore(Property()), Space(), '}', Space(), PopEntity);
  }

  public Rule Property() {
    return Sequence(PushProperty, Annotations(), Space(), Name(), Space(), ':', Space(), TypeDecl(), Space(), PopProperty);
  }

  @SuppressNode
  public Rule TypeDecl() {
    return Sequence(PushTypeDecl, FirstOf(Type(), Collection(), FQID()), PopTypeDecl);
  }

  public Rule Type() {
    return Sequence(FirstOf("bool", "int", "long", "float", "double", "bytes", "string").label("Type"), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        TypeDecl.Scalar s = TypeDecl.Scalar.fromName(selNodeContext.getMatch());
        TypeDecl t = (TypeDecl) pop();
        push((SELNode) t);
        t.setScalar(s);
        return true;
      }
    });
  }

  public Rule Collection() {
    return FirstOf(Sequence("list[", FQID().label("list"), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        TypeDecl t = (TypeDecl) pop();
        push((SELNode) t);
        t.setTypeRefType(TypeDecl.DeclType.LIST);
        return true;
      }
    }, ']'), Sequence("map[", FQID().label("map"), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        TypeDecl t = (TypeDecl) pop();
        push((SELNode) t);
        t.setTypeRefType(TypeDecl.DeclType.MAP);
        return true;
      }
    }, ']'));
  }

  public Rule Annotations() {
    return ZeroOrMore(Sequence(Annotation(), Space()));
  }

  @SuppressNode
  public Rule Space() {
    return ZeroOrMore(AnyOf(" \t\r\n\f").label("Whitespace"));
  }

  @SuppressSubnodes
  public Rule Annotation() {
    return Sequence(PushAnnotation, AT(), AnnotationId(), Optional(AnnotationContent().label("content")), PopAnnotation);
  }

  public Rule AnnotationId() {
    return Sequence(Identifier().label("id"), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        Annotation a = (Annotation) pop();
        push((SELNode) a);
        a.setName(selNodeContext.getMatch());
        return true;
      }
    });
  }

  public Rule AnnotationContent() {
    return Sequence(LP(), ZeroOrMore(TestNot(RP()), ANY), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        Annotation a = (Annotation) pop();
        push((SELNode) a);
        a.setValue(selNodeContext.getMatch());
        return true;
      }
    }, RP());
  }

  @SuppressSubnodes
  public Rule FQID() {
    return Sequence(Sequence(Identifier(), ZeroOrMore(Sequence('.', Identifier()))), new Action<SELNode>() {
      @Override
      public boolean run(Context<SELNode> selNodeContext) {
        TypeDecl t = (TypeDecl) pop();
        push((SELNode) t);
        t.setTypeRef(selNodeContext.getMatch());
        return true;
      }
    });
  }

  @SuppressSubnodes
  public Rule Name() {
    return Sequence(Identifier(), SetName);
  }

  public Rule Identifier() {
    return Sequence(Letter(), ZeroOrMore(LetterOrDigit()));
  }

  @SuppressNode
  public Rule Letter() {
    return FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'));
  }

  @SuppressNode
  public Rule LetterOrDigit() {
    return FirstOf(Letter(), CharRange('0', '9'), '_', '$');
  }

  @SuppressNode
  public Rule AT() {
    return Ch('@');
  }

  @SuppressNode
  public Rule LP() {
    return Ch('(');
  }

  @SuppressNode
  public Rule RP() {
    return Ch(')');
  }

  public static List<Namespace> parse(String toParse) throws IOException {
    SELParser parser = Parboiled.createParser(SELParser.class);
    RecoveringParseRunner<fr.assoba.open.sel.engine.SELNode> runner = new RecoveringParseRunner<fr.assoba.open.sel.engine.SELNode>(parser.Root());
    ParsingResult<fr.assoba.open.sel.engine.SELNode> parsed = runner.run(toParse);
    if (parsed.hasErrors()) {
      for (Object parseError : parsed.parseErrors) {
        System.err.println(parseError.toString());
        throw new IOException("Error parsing");
      }
    }
    ArrayList<Namespace> result = new ArrayList<>();
    for (fr.assoba.open.sel.engine.SELNode node : parsed.valueStack) {
      Namespace ns = (Namespace) node;
      result.add(ns);
    }
    return result;
  }
}
