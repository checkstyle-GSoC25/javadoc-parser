lexer grammar JavadocLexer;

channels {
    LEADING_ASTERISKS, WHITESPACES
}

tokens {
    JAVADOC, LEADING_ASTERISK, NEWLINE, TEXT, WS, JAVADOC_INLINE_TAG_START, JAVADOC_INLINE_TAG_END,
    CODE_LITERAL, LINK_LITERAL, IDENTIFIER, DOT, HASH, LPAREN, RPAREN, COMMA, LINKPLAIN_LITERAL,
    AUTHOR_LITERAL, DEPRECATED_LITERAL, RETURN_LITERAL, PARAM_LITERAL, TAG_OPEN, TAG_CLOSE, TAG_SLASH_CLOSE,
    TAG_SLASH, TAG_EQUALS, TAG_NAME, ATTRIBUTE_VALUE, SLASH, PARAMETER_TYPE, LT, GT, EXTENDS,
    SUPER, QUESTION, VALUE_LITERAL, FORMAT_SPECIFIER
}

@header {
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Set;
import org.antlr.v4.runtime.Token;
}

@lexer::members {
    private int previousTokenType = 0;
    private Token previousToken = null;
    private boolean afterNewline = true;
    private boolean isJavadocTag = true;
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
        boolean isJavadocTag = isJavadocTag();
        boolean isHtmlTag = nextChar == '<'
                    && (Character.isLetter(afterNextChar) || afterNextChar == '/');

        boolean isInlineTag = nextChar == '{' && afterNextChar == '@';
        return !isJavadocTag && !isHtmlTag && !isInlineTag;
    }

    public boolean isJavadocTag() {
        if (previousToken == null) {
            return true;
        }
        int nextChar = _input.LA(1);

        return (previousTokenType == WS || previousTokenType == LEADING_ASTERISK)
                        && nextChar == '@';
    }

//    public int nextNonWhitespaceChar() {
//        int offset = 1;
//        int la;
//        while (true) {
//            la = _input.LA(offset);
//            if (!Character.isWhitespace(la)) {
//                return la;
//            }
//            offset++;
//        }
//    }

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
    : '\r'? '\n' {setAfterNewline();}
    ;

mode text;

Text_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> mode(DEFAULT_MODE), type(NEWLINE)
    ;

TEXT
    : TEXT_CHAR+
    ;

fragment TEXT_CHAR
    : {isNormalText()}? ~[\r\n]
    ;

BLOCK_TAG_ENTRY
    : {isJavadocTag()}? '@' -> pushMode(blockTag), more
    ;

JAVADOC_INLINE_TAG_START: '{@' { braceCounter = 1;} -> pushMode(javadocInlineTag);

TAG_OPEN: '<' -> pushMode(tag);


mode javadocInlineTag;

CODE_LITERAL: 'code' -> pushMode(code);
LINK_LITERAL : 'link'-> pushMode(link);
LINKPLAIN_LITERAL : 'linkplain' -> pushMode(link);
VALUE_LITERAL: 'value' -> pushMode(value);
CUSTOM_NAME:  [a-zA-Z0-9:._-]+ -> pushMode(inlineTagDescription);

mode code;
// TODO: Allow '}' to be treated as regular text within code blocks.

Code_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;

Code_TEXT
    :   ( ~[{}\r\n]
        | '{' {braceCounter++;}
        | '}' {braceCounter != 1}? {braceCounter--;})+  -> type(TEXT)
    ;

JAVADOC_INLINE_TAG_END: '}' {braceCounter == 1}? {braceCounter--;} -> popMode, popMode;


mode link;
EXTENDS: 'extends';
SUPER: 'super';
IDENTIFIER:
    Letter LetterOrDigit*
    {
        int la = _input.LA(1);
        if ((previousTokenType == HASH && la != '(')
            || (previousTokenType == DOT && Character.isWhitespace(la))) {
            _mode = inlineTagDescription;
        }
    };
QUESTION: '?';
DOT: '.';
HASH: '#';
LPAREN: '(' -> pushMode(parameterList);
SLASH: '/';
Link_WS: [ \t]+ -> type(WS), channel(WHITESPACES);
Link_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), mode(text);
LT: '<';
// Switch to description mode after '>' if followed by whitespace,
// indicating end of the type reference in {@link ...}.
GT: '>'
    {
        int la = _input.LA(1);
        if (Character.isWhitespace(la)) {
            _mode = linkTagDescription;
        }
    };
Link_COMMA: ',' -> type(COMMA);

fragment LetterOrDigit
    : Letter
    | [0-9]
    ;

fragment Letter: [a-zA-Z$_];


mode linkTagDescription;

LinkDescription_TEXT
    : ~[{}\r\n]+ -> type(TEXT)
    ;

LinkDescription_JAVADOC_INLINE_TAG_START:
    '{@' { braceCounter = 1;} -> pushMode(javadocInlineTag), type(JAVADOC_INLINE_TAG_START);

LinkDescription_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;

LinkDescription_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), mode(text);


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
Value_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;
Value_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;

mode inlineTagDescription;

InlineDescription_TEXT
    : ~[}\r\n]+ -> type(TEXT)
    ;

InlineDescription_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;

InlineDescription_JAVADOC_INLINE_TAG_END: '}' -> type(JAVADOC_INLINE_TAG_END), popMode, popMode;

mode startOfLine;

StartOfLine_LEADING_ASTERISK
    : [ \t]* '*' -> channel(LEADING_ASTERISKS), popMode, type(LEADING_ASTERISK)
    ;

mode blockTag;
AUTHOR_LITERAL: 'author' -> pushMode(text);
DEPRECATED_LITERAL : 'deprecated' -> pushMode(text);
RETURN_LITERAL: 'return' -> pushMode(text);
PARAM_LITERAL: 'param' -> pushMode(parameterName);
BlockTag_CUSTOM_NAME: [a-zA-Z0-9:._-]+ -> type(CUSTOM_NAME), pushMode(text);

mode parameterName;
PARAMETER_NAME: Letter LetterOrDigit* -> type(IDENTIFIER), mode(text);
Param_WS: [ \t]+ -> type(WS), channel(WHITESPACES);


mode tag;

TAG_CLOSE: '>' {hasSeenTagName = false;} -> popMode;
TAG_SLASH_CLOSE: '/>' {hasSeenTagName = false;} -> popMode;
TAG_SLASH: '/';
TAG_EQUALS: '=' -> pushMode(attrValue);
// TODO: this can be one rule maybe?
TAG_NAME: {hasSeenTagName == false}? TagNameStartChar TagNameChar* {hasSeenTagName = true;};
TAG_ATTR_NAME: {hasSeenTagName == true}? TagNameStartChar TagNameChar*;
Tag_NEWLINE
    : '\r'? '\n' {setAfterNewline();} -> pushMode(startOfLine), type(NEWLINE)
    ;
TAG_WHITESPACE:  [ \t]+ -> type(WS), channel(WHITESPACES);

fragment TagNameChar:
    TagNameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT
    | '\u00B7'
    | '\u0300' ..'\u036F'
    | '\u203F' ..'\u2040'
;

fragment TagNameStartChar:
    [:a-zA-Z]
    | '\u2070' ..'\u218F'
    | '\u2C00' ..'\u2FEF'
    | '\u3001' ..'\uD7FF'
    | '\uF900' ..'\uFDCF'
    | '\uFDF0' ..'\uFFFD'
;

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
