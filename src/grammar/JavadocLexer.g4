lexer grammar JavadocLexer;

@members {
    private boolean afterNewline = true;

    public boolean isAfterNewline() {
        return afterNewline;
    }

    public void setAfterNewline() {
        afterNewline = true;
    }

    @Override
    public void emit(Token token) {
        super.emit(token);
        if (token.getType() != NEWLINE) {
            afterNewline = false;
        }
    }
}

LEADING_ASTERISK
    : {isAfterNewline()}? [ \t]* '*'
    ;

NEWLINE
    : '\r'? '\n' { setAfterNewline(); }
    ;

TEXT
    : {isAfterNewline()}? ~[@*{}\r\n]+
    | {!isAfterNewline()}? ~[@{}\r\n]+
    ;
