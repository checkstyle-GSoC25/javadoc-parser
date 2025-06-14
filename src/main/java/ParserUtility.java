import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import java.util.List;

public final class ParserUtility {

    private ParserUtility() {
        throw new IllegalStateException("Utility class");
    }

    // We can vastly improve the performance by using a wrapper class or out own token implementation
    // that has a proper equals contract. Sadly - CommonToken compares references :(
    public static boolean isNonTightTag(TokenStream _input, List<Token> unclosedTagNameTokens) {
        final Token lookahead = _input.LT(2);
        for (Token token : unclosedTagNameTokens) {
            if (tokensEqual(lookahead, token)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tokensEqual(Token t1, Token t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;
        return t1.getType() == t2.getType()
                && t1.getText().equals(t2.getText())
                && t1.getLine() == t2.getLine()
                && t1.getTokenIndex() == t2.getTokenIndex()
                && t1.getCharPositionInLine() == t2.getCharPositionInLine();
    }
}
