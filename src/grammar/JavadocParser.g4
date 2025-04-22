parser grammar JavadocParser;

/*
    Javadoc Spec: https://docs.oracle.com/en/java/javase/22/docs/specs/javadoc/doc-comment-spec.html
*/
options {
    tokenVocab = JavadocLexer;
}


/*
The overall form of a documentation comment is an initial main description, followed by a series of block tags,
which provide additional information about the declaration to which the comment applies.

*/
javadoc
    : mainDescription (blockTag)*
    ;

/*
The main description in a documentation comment is the content from the beginning of the comment,
up to the first block tag. It consists of a series of lines
*/
mainDescription
    : javadocLine*
    ;

/*
Each javadoc line is series of descriptive text tokens, starting with an asterisk? and end with a newline.
TODO: It may include inline tags and HTML Content
*/
javadocLine
    :  LEADING_ASTERISK (TEXT | NEWLINE)*
    ;

/*
After the main description, the comment may contain a series of block tags.
Each block tag starts with an optional asterisk and is followed by the actual block tag
*/

/*
TODO: extend with other block tags.
TODO: refine the subsequent subrules XXXTag to be more specific
*/
blockTag
    : paramTag
    | authorTag
    | seeTag
    | customTag
    ;

paramTag
    : PARAM_LITERAL description
    ;

authorTag
    : AUTHOR_LITERAL description
    ;

seeTag
    : SEE_LITERAL description
    ;

customTag
    : CUSTOM_NAME description
    ;

/*
The content of a block tag is any text following the tag up to, but not including,
either the next block tag, or the end of the documentation comment
*/
description
    :  descriptionLine*
    ;

descriptionLine
    : LEADING_ASTERISK? (TEXT | NEWLINE)+
    | LEADING_ASTERISK
    ;
