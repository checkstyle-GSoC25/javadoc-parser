lexer grammar JavadocLexer;

channels {
    LEADING_ASTERISKS, WHITESPACES, NEWLINES
}

tokens {
    JAVADOC, LEADING_ASTERISK, NEWLINE, TEXT, WS, JAVADOC_INLINE_TAG_START, JAVADOC_INLINE_TAG_END,
    CODE_LITERAL, LINK_LITERAL, IDENTIFIER, DOT, HASH, LPAREN, RPAREN, COMMA, LINKPLAIN_LITERAL,
    AUTHOR_LITERAL, DEPRECATED_LITERAL, RETURN_LITERAL, PARAM_LITERAL, TAG_OPEN, TAG_CLOSE, TAG_SLASH_CLOSE,
    TAG_SLASH, EQUALS, TAG_NAME, ATTRIBUTE_VALUE, SLASH, PARAMETER_TYPE, LT, GT, EXTENDS,
    SUPER, QUESTION, VALUE_LITERAL, FORMAT_SPECIFIER, INHERITDOC_LITERAL, SUMMARY_LITERAL, SYSTEM_PROPERTY,
    INDEX, INDEX_TERM, RETURN, SNIPPET, SNIPPET_ATTR_NAME, COLON, EXCEPTION, THROWS, PARAMETER_NAME, SINCE,
    VERSION, SEE, STRING_LITERAL, LITERAL_HIDDEN, SERIAL, SERIAL_DATA, SERIAL_FIELD, FIELD_TYPE
}

@header {
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import org.antlr.v4.runtime.Token;
}

@lexer::members {
    private int previousTokenType = 0;
    private Token previousToken = null;
    private boolean afterNewline = true;
    private boolean isJavadocBlockTag = true;
    private boolean hasSeenTagName = false;
    private int braceCounter = 0;

    private final Deque<Token> openTagNameTokens = new ArrayDeque<>();
    private final Deque<Token> closeTagNameTokens = new ArrayDeque<>();

    public boolean isAfterNewline() {
        return afterNewline;
    }

    public void setAfterNewline() {
        afterNewline = true;
    }

    public boolean isNormalText() {
        int nextChar = _input.LA(1);
        int afterNextChar = _input.LA(2);
        boolean isJavadocBlockTag = isJavadocBlockTag();
        boolean isHtmlTag = nextChar == '<'
                    && (Character.isLetter(afterNextChar) || afterNextChar == '/');

        boolean isInlineTag = nextChar == '{' && afterNextChar == '@';
        return !isJavadocBlockTag && !isHtmlTag && !isInlineTag;
    }

    public boolean isJavadocBlockTag() {
        int nextChar = _input.LA(1);

        return (previousTokenType == WS || previousTokenType == LEADING_ASTERISK
                || previousTokenType == NEWLINE) && nextChar == '@';
    }

    @Override
    public void emit(Token token) {
        super.emit(token);
        if (token.getType() == TAG_NAME) {
            if (LexerUtility.isOpenTagName(previousToken)) {
                openTagNameTokens.push(token);
            }
            else {
                closeTagNameTokens.push(token);
            }
        }
        previousTokenType = token.getType();
        previousToken = token;
        if (previousTokenType != NEWLINE) {
            afterNewline = false;
        }
    }

    public Set<SimpleToken> getUnclosedTagNameTokens() {
        return LexerUtility.getUnclosedTagNameTokens(openTagNameTokens, closeTagNameTokens);
    }
}

LEADING_ASTERISK
    : [ \t]* '*' {isAfterNewline()}? {
        if (!Character.isWhitespace(_input.LA(1))) {
           pushMode(text);
        }
    } -> channel(LEADING_ASTERISKS)
    ;

WS :   (' '|'\t')+ -> channel(WHITESPACES),  pushMode(text) ;

NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> channel(NEWLINES)
    ;

BLOCK_TAG_ENTRY
    : {isJavadocBlockTag()}? '@' -> pushMode(blockTag), more
    ;

mode text;
Text_NEWLINE: '\r'? '\n' {setAfterNewline();} -> mode(DEFAULT_MODE), type(NEWLINE), channel(NEWLINES);
TEXT: TEXT_CHAR+;
BLOCK_TAG_ENTRY2: {isJavadocBlockTag()}? '@' -> pushMode(blockTag), more;
JAVADOC_INLINE_TAG_START: '{@' { braceCounter = 1;} -> pushMode(javadocInlineTag);
TAG_OPEN: '<' -> pushMode(tag);
fragment TEXT_CHAR: {isNormalText()}? ~[\r\n];

mode javadocInlineTag;
CODE_LITERAL: 'code' -> pushMode(plainTextTag);
LINK_LITERAL: 'link'-> pushMode(link);
LINKPLAIN_LITERAL: 'linkplain' -> pushMode(link);
VALUE_LITERAL: 'value' -> pushMode(value);
INHERITDOC_LITERAL: 'inheritDoc' -> pushMode(link);
SUMMARY_LITERAL: 'summary' -> pushMode(inlineTagDescription);
SYSTEM_PROPERTY: 'systemProperty' -> pushMode(value);
INDEX: 'index' -> pushMode(indexTerm);
RETURN: 'return' -> pushMode(inlineTagDescription);
LITERAL: 'literal' -> pushMode(plainTextTag);
SNIPPET: 'snippet' -> pushMode(snippetAttribute);
CUSTOM_NAME: [a-zA-Z0-9:._-]+ -> pushMode(inlineTagDescription);

mode plainTextTag;
Code_NEWLINE: '\r'? '\n' {setAfterNewline();} -> type(NEWLINE), channel(NEWLINES), pushMode(startOfLine);
Code_LBRACE: '{' { braceCounter++; } -> type(TEXT);
Code_RBRACE: '}' { braceCounter > 1 }? { braceCounter--; } -> type(TEXT);
JAVADOC_INLINE_TAG_END: '}' { braceCounter == 1 }? { braceCounter--; } -> popMode, popMode;
Code_TEXT: ~[{}\r\n]+ -> type(TEXT);

mode snippetAttribute;
SNIPPET_ATTR_NAME: Letter LetterOrDigit*;
SNIPPET_EQUALS: '=' -> type(EQUALS), pushMode(attrValue);
COLON: ':' -> popMode, pushMode(plainTextTag);
SnippetAttribute_NEWLINE: '\r'? '\n' {setAfterNewline();} -> type(NEWLINE), channel(NEWLINES), pushMode(startOfLine);
SnippetArrtibute_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
SnippetAttribute_JAVADOC_INLINE_TAG_END: '}' { braceCounter--; } -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;

mode link;
EXTENDS: 'extends';
SUPER: 'super';
IDENTIFIER:
    Letter LetterOrDigit*
    {
        int la = _input.LA(1);
        if ((previousTokenType == HASH && la != '(')
            || (previousTokenType == DOT && Character.isWhitespace(la))) {
            pushMode(linkTagDescription);
        }
    };
QUESTION: '?';
DOT: '.';
HASH: '#';
LPAREN: '(' -> pushMode(parameterList);
SLASH: '/';
Link_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
Link_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;
LT: '<';
GT: '>' { if (Character.isWhitespace(_input.LA(1))) pushMode(linkTagDescription); };
Link_COMMA: ',' -> type(COMMA);
Link_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);

fragment LetterOrDigit: Letter | [0-9];
fragment Letter: [a-zA-Z$_];

mode linkTagDescription;
LinkDescription_TEXT: ~[{}\r\n]+ -> type(TEXT);
LinkDescription_JAVADOC_INLINE_TAG_START: '{@' { braceCounter = 1;} -> pushMode(javadocInlineTag), type(JAVADOC_INLINE_TAG_START);
LinkDescription_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
LinkDescription_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode, popMode;

mode parameterList;
ParameterList_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
PARAMETER_TYPE: ([a-zA-Z0-9_$] | '.' | '[' | ']')+;
COMMA: ',';
RPAREN: ')' -> popMode, pushMode(linkTagDescription);

mode value;
Value_IDENTIFIER: Letter LetterOrDigit* -> type(IDENTIFIER);
FORMAT_SPECIFIER: '%' [#+\- 0,(]* [0-9]* ('.' [0-9]+)? [a-zA-Z];
Value_HASH: '#' -> type(HASH);
Value_DOT: '.' -> type(DOT);
Value_WS: [ \t]+ -> channel(WHITESPACES);
Value_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
Value_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;

mode inlineTagDescription;
InlineDescription_TEXT: InlineDescription_TEXT_CHAR+ -> type(TEXT);
fragment InlineDescription_TEXT_CHAR: {isNormalText()}? ~[}\r\n];
InlineDescription_JAVADOC_INLINE_TAG_START: '{@' { braceCounter = 1;}
    -> pushMode(javadocInlineTag), type(JAVADOC_INLINE_TAG_START);
InlineDescription_TAG_OPEN: '<' -> pushMode(tag), type(TAG_OPEN);
InlineDescription_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
InlineDescription_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;

mode indexTerm;
INDEX_TERM: ( '"' (~["\r\n}])+ '"' | ~[ \t\r\n"}]+ ) -> popMode, pushMode(plainTextTag);
IndexTerm_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
IndexTerm_WS: [ \t]+ -> channel(WHITESPACES);

mode startOfLine;
StartOfLine_LEADING_ASTERISK: [ \t]* '*' -> channel(LEADING_ASTERISKS), popMode, type(LEADING_ASTERISK);

mode blockTag;
AUTHOR_LITERAL: 'author' -> pushMode(text);
DEPRECATED_LITERAL: 'deprecated' -> pushMode(text);
RETURN_LITERAL: 'return' -> pushMode(text);
PARAM_LITERAL: 'param' -> pushMode(parameterName);
EXCEPTION: 'exception' -> pushMode(qualifiedIdentifier);
THROWS: 'throws' -> pushMode(qualifiedIdentifier);
SINCE: 'since' -> pushMode(text);
VERSION: 'version' -> pushMode(text);
SEE: 'see' -> pushMode(see);
LITERAL_HIDDEN: 'hidden' -> pushMode(text);
USES: 'uses' -> pushMode(qualifiedIdentifier);
PROVIDES: 'provides' -> pushMode(qualifiedIdentifier);
SERIAL: 'serial' -> pushMode(text);
SERIAL_DATA: 'serialData' -> pushMode(text);
SERIAL_FIELD: 'serialField' -> pushMode(fieldName);
BlockTag_CUSTOM_NAME: [a-zA-Z0-9:._-]+ -> type(CUSTOM_NAME), pushMode(text);

mode fieldName;
FieldName_IDENTIFIER: Letter LetterOrDigit* -> type(IDENTIFIER), pushMode(fieldType);
FieldName_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
FieldName_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES)
    ;

mode fieldType;
FieldType_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
FIELD_TYPE: ([a-zA-Z0-9_$] | '.' | '[' | ']')+ -> mode(text);

mode see;
STRING_LITERAL: '"' .*? '"' -> mode(text);
See_TAG_OPEN: '<' {_input.seek(_input.index() - 1);} -> skip, mode(text);
See_IDENTIFIER: Letter LetterOrDigit*
    {
        int la = _input.LA(1);
        if (Character.isWhitespace(la) || la == '\n' || la == '\r') {
            _mode = text;
        }
    } -> type(IDENTIFIER);

See_HASH: '#' -> type(HASH);
See_DOT: '.' -> type(DOT);
See_LPAREN: '(' -> type(LPAREN), pushMode(seeParameterList);
See_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES)
    ;
See_WS: [ \t]+ -> type(WS), channel(WHITESPACES);

mode seeParameterList;
SeeParameterList_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
SeeParameterList_PARAMETER_TYPE: ([a-zA-Z0-9_$] | '.' | '[' | ']')+ -> type(PARAMETER_TYPE);
SeeParameterList_COMMA: ',' -> type(COMMA);
See_RPAREN: ')' -> type(RPAREN), mode(text);

mode qualifiedIdentifier;
DOTTED_IDENTIFIER: ([a-zA-Z0-9_$] | '.')+ -> type(IDENTIFIER), mode(text);
DottedIdentifier_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES)
    ;
DottedIdentifier_WS: [ \t]+ -> type(WS), channel(WHITESPACES);

mode exceptionName;
EXCEPTION_NAME: ([a-zA-Z0-9_$] | '.')+ -> type(IDENTIFIER), mode(text);
ExceptionName_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
ExceptionName_WS: [ \t]+ -> type(WS), channel(WHITESPACES);

mode parameterName;
PARAMETER_NAME: [a-zA-Z0-9<>_$]+ -> mode(text);
Param_WS: [ \t]+ -> type(WS), channel(WHITESPACES);

mode tag;
TAG_CLOSE: '>' {hasSeenTagName = false;} -> popMode;
TAG_SLASH_CLOSE: '/>' {hasSeenTagName = false;} -> popMode;
TAG_SLASH: '/';
EQUALS: '=' -> pushMode(attrValue);
TAG_NAME: {hasSeenTagName == false}? TagNameStartChar TagNameChar* {hasSeenTagName = true;};
TAG_ATTR_NAME: {hasSeenTagName == true}? TagNameStartChar TagNameChar*;
Tag_NEWLINE: '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE), channel(NEWLINES);
TAG_WHITESPACE: [ \t]+ -> type(WS), channel(WHITESPACES);

fragment TagNameChar: TagNameStartChar | '-' | '_' | '.' | DIGIT | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040';
fragment TagNameStartChar: [:a-zA-Z] | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD';
fragment DIGIT: [0-9];

mode attrValue;
ATTRIBUTE_VALUE: ' '* ATTRIBUTE -> popMode;
ATTRIBUTE: DOUBLE_QUOTE_STRING | SINGLE_QUOTE_STRING | ATTCHARS | HEXCHARS | DECCHARS;
fragment ATTCHARS: ATTCHAR+ ' '?;
fragment ATTCHAR: '-' | '_' | '.' | '/' | '+' | ',' | '?' | '=' | ':' | ';' | '#' | [0-9a-zA-Z];
fragment HEXCHARS: '#' [0-9a-fA-F]+;
fragment DECCHARS: [0-9]+ '%'?;
fragment DOUBLE_QUOTE_STRING: '"' ~[<"]* '"';
fragment SINGLE_QUOTE_STRING: '\'' ~[<']* '\'';
