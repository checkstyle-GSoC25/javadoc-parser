import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;

import java.util.*;
import java.util.stream.Collectors;

public final class LexerUtility {

    private LexerUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static Set<SimpleToken> getUnclosedTagNameTokens(
            Deque<Token> openTagNameTokens, Deque<Token> closeTagNameTokens) {

        final Deque<Token> unmatchedOpen = new ArrayDeque<>(openTagNameTokens);

        for (Token closingTag : closeTagNameTokens) {
            final Deque<Token> tempStack = new ArrayDeque<>();
            boolean matched = false;
            while (!unmatchedOpen.isEmpty()) {
                Token openingTag = unmatchedOpen.pop();
                if (openingTag.getText().equalsIgnoreCase(closingTag.getText())
                        && openingTag.getTokenIndex() < closingTag.getTokenIndex()) {
                    matched = true;
                    break;
                } else {
                    tempStack.push(openingTag);
                }
            }

            // Put unmatched tags back
            while (!tempStack.isEmpty()) {
                unmatchedOpen.push(tempStack.pop());
            }

            if (!matched) {
                // might need this, let's see how this works out
            }
        }

        // We cannot map to SimpleToken until lexing has completed, otherwise
        // the token index will not be set.
        return unmatchedOpen.stream()
                .map(SimpleToken::from)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static boolean isOpenTagName(Token previousToken) {
        return previousToken == null || previousToken.getType() != JavadocParser.TAG_SLASH;
    }

}
