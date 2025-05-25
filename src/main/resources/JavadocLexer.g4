lexer grammar JavadocLexer;

channels {
    LEADING_ASTERISKS, WHITESPACES
}

tokens {
    JAVADOC, LEADING_ASTERISK, NEWLINE, TEXT, WS, JAVADOC_INLINE_TAG_START, JAVADOC_INLINE_TAG_END,
    CODE_LITERAL, LINK_LITERAL, IDENTIFIER, DOT, HASH, LEFT_BRACE, RIGHT_BRACE, COMMA
}

@lexer::members {
    private int previousTokenType = 0;
    private Token previousToken = null;
    private boolean afterNewline = true;
    private boolean isJavadocTag = true;

    public boolean isAfterNewline() {
        return afterNewline;
    }

    public void setAfterNewline() {
        afterNewline = true;
    }

    public boolean isJavadocTag() {
        if (previousToken == null) {
            return true;
        }
        int nextChar = _input.LA(1);

        return previousTokenType == WS && nextChar == '@';
    }

    @Override
    public void emit(Token token) {
        super.emit(token);
        previousTokenType = token.getType();
        previousToken = token;
        if (previousTokenType != NEWLINE) {
            afterNewline = false;
        }
    }
}

LEADING_ASTERISK
    : [ \t]* '*' {isAfterNewline()}? -> channel(LEADING_ASTERISKS)
    ;

WS :   (' '|'\t')* -> channel(WHITESPACES),  pushMode(text) ;

NEWLINE
    : '\r'? '\n' {setAfterNewline();}
    ;

mode text;

Text_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> mode(DEFAULT_MODE), type(NEWLINE)
    ;

TEXT
    : {!isJavadocTag()}? ~[{}\r\n]+
    ;

BLOCK_TAG_ENTRY
    : {isJavadocTag()}? -> pushMode(blockTag), skip
    ;

JAVADOC_INLINE_TAG_START: '{' -> pushMode(javadocInlineTag);


mode javadocInlineTag;

CODE_LITERAL: '@code' -> pushMode(code);
LINK_LITERAL : '@link'-> pushMode(link);

mode code;
// TODO: Allow '}' to be treated as regular text within code blocks.

Code_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;

Code_TEXT: ~[}\r\n]+ -> type(TEXT);

JAVADOC_INLINE_TAG_END: '}' -> mode(text);


mode link;
IDENTIFIER:
    Letter LetterOrDigit*
    {
        int la = _input.LA(1);
        if (previousTokenType == HASH && la != '(') {
            _mode = description;
        }
    };

DOT: '.';
HASH: '#';
LEFT_BRACE: '(';
RIGHT_BRACE: ')' -> pushMode(description);
COMMA: ',';
Link_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
Link_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), mode(text);

mode description;

Description_TEXT
    : ~[}\r\n]+ -> type(TEXT)
    ;

Description_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;

Decription_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), mode(text);

mode startOfLine;

StartOfLine_LEADING_ASTERISK
    : [ \t]* '*' -> channel(LEADING_ASTERISKS), popMode, type(LEADING_ASTERISK)
    ;

mode blockTag;
AUTHOR_LITERAL: '@author';


fragment LetterOrDigit
    : Letter
    | [0-9]
    ;

fragment Letter: [a-zA-Z$_];
