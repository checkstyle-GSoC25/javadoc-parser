parser grammar JavadocParser;

options {
    tokenVocab = JavadocLexer;
}

javadoc
    : ( LEADING_ASTERISK | TEXT | NEWLINE )*
    ;