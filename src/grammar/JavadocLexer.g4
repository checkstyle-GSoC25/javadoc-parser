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
    : [ \t]* '*' {isAfterNewline()}?
    ;

NEWLINE
    : '\r'? '\n' { setAfterNewline(); }
    ;

TEXT
    : ~[@*{}\r\n]+ {isAfterNewline()}?
    | ~[@{}\r\n]+ {!isAfterNewline()}?
    ;
