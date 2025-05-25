parser grammar JavadocParser;

options {
    tokenVocab = JavadocLexer;
}

javadoc
    : mainDescription EOF;

mainDescription: (NEWLINE | TEXT | inlineTag)*;

inlineTag
    : JAVADOC_INLINE_TAG_START
      (codeInlineTag | linkInlineTag)
      JAVADOC_INLINE_TAG_END
    ;

codeInlineTag: CODE_LITERAL (TEXT|NEWLINE)*;

linkInlineTag: LINK_LITERAL reference description?;

reference
        : qualifiedName (HASH memberReference)?
        | (HASH memberReference)
        ;

qualifiedName: IDENTIFIER (DOT IDENTIFIER)*;

memberReference: IDENTIFIER (LEFT_BRACE parameterList? RIGHT_BRACE)?;

parameterList: IDENTIFIER (COMMA IDENTIFIER)*;

description : (TEXT | NEWLINE)+ ;
