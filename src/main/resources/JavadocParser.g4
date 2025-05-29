parser grammar JavadocParser;

options {
    tokenVocab = JavadocLexer;
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

memberReference: IDENTIFIER (LEFT_BRACE parameterList? RIGHT_BRACE)?;

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
    : normalElement
    | singltonElement
    ;

normalElement
    : htmlTagStart TAG_CLOSE (htmlContent TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE)?
    ;

singltonElement
    : htmlTagStart TAG_SLASH_CLOSE
    ;

htmlTagStart
    : TAG_OPEN TAG_NAME (htmlAttribute)*
    ;

htmlAttribute
    : TAG_NAME (TAG_EQUALS ATTRIBUTE_VALUE)?
    ;

htmlContent
    : (TEXT | htmlElement | inlineTag | NEWLINE)*
    ;