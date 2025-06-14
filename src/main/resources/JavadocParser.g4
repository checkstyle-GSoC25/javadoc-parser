parser grammar JavadocParser;

options {
    tokenVocab = JavadocLexer;
}

@parser::header {
import java.util.Set;
import java.util.stream.Collectors;
}


@parser::members {
    private static final Set<String> VOID_TAGS = Set.of(
        "area", "base", "basefont", "br", "col", "frame", "hr",
        "img", "input", "isindex", "link", "meta", "param"
    );

    private Set<SimpleToken> unclosedTagNameTokens;

    public boolean isVoidTag() {
        String tagName = _input.LT(2).getText();
        return VOID_TAGS.contains(tagName.toLowerCase());
    }

    public JavadocParser(CommonTokenStream tokens, Set<SimpleToken> unclosed) {
        super(tokens);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
        this.unclosedTagNameTokens = unclosed;
    }
}

javadoc
    : mainDescription (blockTag)* EOF
    | blockTag+ EOF
    ;

inlineTag
    : JAVADOC_INLINE_TAG_START
     ( codeInlineTag | linkInlineTag | linkPlainInlineTag | customInlineTag)
      JAVADOC_INLINE_TAG_END
    ;

codeInlineTag: CODE_LITERAL (TEXT|NEWLINE)*;

linkPlainInlineTag: LINKPLAIN_LITERAL reference description?;

linkInlineTag: LINK_LITERAL reference description?;

reference
        : qualifiedName (HASH memberReference)?
        | (HASH memberReference)
        ;

qualifiedName: IDENTIFIER (DOT IDENTIFIER)*;

memberReference: IDENTIFIER (LPAREN parameterList? RPAREN)?;

parameterList: IDENTIFIER (COMMA IDENTIFIER)*;

customInlineTag: CUSTOM_NAME description?;

blockTag
    : authorTag
    | deprecatedTag
    | returnTag
    | parameterTag
    | customBlockTag
    ;

authorTag: AUTHOR_LITERAL description;

deprecatedTag: DEPRECATED_LITERAL description;

returnTag: RETURN_LITERAL description;

parameterTag: PARAM_LITERAL parameterName description;

parameterName: IDENTIFIER;

customBlockTag: CUSTOM_NAME description;

description : (TEXT | NEWLINE |inlineTag)+ ;

// HTML stuff

mainDescription: (NEWLINE | TEXT | inlineTag | htmlElement)+;

htmlElement
    : voidElement
    | selfClosingElement
    | tight
    | nonTight
    ;

voidElement
    : {isVoidTag()}? htmlTagStart
    ;

tight: {!ParserUtility.isNonTightTag(_input, unclosedTagNameTokens)}? htmlTagStart htmlContent htmlTagEnd;

nonTight: htmlTagStart nonTightHtmlContent;

selfClosingElement
    : TAG_OPEN TAG_NAME (htmlAttribute)* TAG_SLASH_CLOSE
    ;

htmlTagStart
    : TAG_OPEN TAG_NAME (htmlAttribute)* TAG_CLOSE
    ;

htmlTagEnd
    : TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE
    ;

htmlAttribute
    : TAG_ATTR_NAME (TAG_EQUALS ATTRIBUTE_VALUE)?
    ;

htmlContent
    : (TEXT | htmlElement | inlineTag | NEWLINE)+
    ;

nonTightHtmlContent
    : (TEXT | inlineTag | NEWLINE)+
    ;
