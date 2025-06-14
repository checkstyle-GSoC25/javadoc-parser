import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import java.util.Set;

public final class ParserUtility {

    private ParserUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNonTightTag(TokenStream _input, Set<SimpleToken> unclosedTagNameTokens) {
        final Token lookahead = SimpleToken.from(_input.LT(2));
        return unclosedTagNameTokens.contains(lookahead);
    }
}
