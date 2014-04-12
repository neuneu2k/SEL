package fr.assoba.open.sel.engine.test;

import fr.assoba.open.sel.engine.SELNode;
import fr.assoba.open.sel.engine.SELParser;
import org.parboiled.Node;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParseTree {

  public static void main(String[] args) throws IOException {
    SELParser parser = Parboiled.createParser(SELParser.class);
    RecoveringParseRunner<SELNode> runner = new RecoveringParseRunner<SELNode>(parser.Root());
    InputStream is = ParseTree.class.getResourceAsStream("/sample.sel");
    byte[] buffer = new byte[is.available()];
    is.read(buffer);
    String toParse = new String(buffer);
    ParsingResult parsed = runner.run(toParse);
    System.out.println(parsed);
  }
}
