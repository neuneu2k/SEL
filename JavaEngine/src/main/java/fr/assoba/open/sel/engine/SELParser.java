package fr.assoba.open.sel.engine;

import org.parboiled.Action;
import org.parboiled.BaseParser;
import org.parboiled.Context;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.annotations.SuppressNode;
import org.parboiled.annotations.SuppressSubnodes;

@BuildParseTree
public class SELParser<SELNode> extends BaseParser<SELNode> {

  public Rule Root() {
    return ZeroOrMore(Sequence(Space(), Namespace(), Space()));
  }

  public Rule Namespace() {
    return Sequence(PushNamespace, Annotations(), Space(), "namespace", Space(), Name(), Space(), '{', Space(), ZeroOrMore(Entity()), '}');
  }

  public Action<SELNode> PushNamespace = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      push((SELNode) new Namespace());
      return true;
    }
  };

  public Rule Entity() {
    return Sequence(PushEntity, Annotations(), "entity", Space(), Name(), Space(), '{', Space(), ZeroOrMore(Property()), Space(), '}', Space(), PopEntity);
  }

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


  public Rule Property() {
    return Sequence(PushProperty, Annotations(), Space(), Name(), Space(), ':', Space(), TypeDecl(), Space(), PopProperty);
  }

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


  @SuppressNode
  public Rule TypeDecl() {
    return Sequence(PushTypeDecl, FirstOf(Type(), Collection(), FQID()), PopTypeDecl);
  }

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

  public Action<SELNode> SetName = new Action<SELNode>() {
    @Override
    public boolean run(Context<SELNode> selNodeContext) {
      Annotated o = (Annotated) pop();
      push((SELNode) o);
      o.setName(selNodeContext.getMatch());
      return true;
    }
  };


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
}
