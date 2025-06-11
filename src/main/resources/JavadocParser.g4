parser grammar JavadocParser;

options {
    tokenVocab = JavadocLexer;
}

@parser::header {
import java.util.Set;
}


@parser::members {
    private static final Set<String> VOID_TAGS = Set.of(
        "area", "base", "basefont", "br", "col", "frame", "hr",
        "img", "input", "isindex", "link", "meta", "param"
    );

    public boolean isVoidTag() {
        String tagName = _input.LT(2).getText();
        return VOID_TAGS.contains(tagName.toLowerCase());
    }

    public String getCloseTagName() {
        return _input.LT(3).getText();
    }
}

javadoc
    : mainDescription (blockTag)* EOF;

mainDescription: (NEWLINE | TEXT | inlineTag | htmlElement)*;

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


htmlElement
    : voidElement
    | normalElement
    ;

voidElement
    : {isVoidTag()}? htmlTagStart
    ;

normalElement
    : tagStart=htmlTagStart htmlContent htmlTagEnd[$tagStart.tagName]
    ;

htmlTagStart returns[String tagName]
    : TAG_OPEN name=TAG_NAME (htmlAttribute)* (TAG_SLASH_CLOSE | TAG_CLOSE)
        {$tagName = $name.text;}
    ;

htmlTagEnd [String openTagName]
    : {
        // Lookahead to 3rd token: < / TAG_NAME >
        $openTagName.equalsIgnoreCase(getCloseTagName())
      }?
      TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE
    ;

htmlAttribute
    : TAG_NAME (TAG_EQUALS ATTRIBUTE_VALUE)?
    ;

htmlContent
    : (TEXT | htmlElement | inlineTag | NEWLINE)*
    ;