// Generated from JavadocParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavadocParser}.
 */
public interface JavadocParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavadocParser#javadoc}.
	 * @param ctx the parse tree
	 */
	void enterJavadoc(JavadocParser.JavadocContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#javadoc}.
	 * @param ctx the parse tree
	 */
	void exitJavadoc(JavadocParser.JavadocContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#mainDescription}.
	 * @param ctx the parse tree
	 */
	void enterMainDescription(JavadocParser.MainDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#mainDescription}.
	 * @param ctx the parse tree
	 */
	void exitMainDescription(JavadocParser.MainDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#javadocLine}.
	 * @param ctx the parse tree
	 */
	void enterJavadocLine(JavadocParser.JavadocLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#javadocLine}.
	 * @param ctx the parse tree
	 */
	void exitJavadocLine(JavadocParser.JavadocLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#blockTag}.
	 * @param ctx the parse tree
	 */
	void enterBlockTag(JavadocParser.BlockTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#blockTag}.
	 * @param ctx the parse tree
	 */
	void exitBlockTag(JavadocParser.BlockTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#paramTag}.
	 * @param ctx the parse tree
	 */
	void enterParamTag(JavadocParser.ParamTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#paramTag}.
	 * @param ctx the parse tree
	 */
	void exitParamTag(JavadocParser.ParamTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#authorTag}.
	 * @param ctx the parse tree
	 */
	void enterAuthorTag(JavadocParser.AuthorTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#authorTag}.
	 * @param ctx the parse tree
	 */
	void exitAuthorTag(JavadocParser.AuthorTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#seeTag}.
	 * @param ctx the parse tree
	 */
	void enterSeeTag(JavadocParser.SeeTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#seeTag}.
	 * @param ctx the parse tree
	 */
	void exitSeeTag(JavadocParser.SeeTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#customTag}.
	 * @param ctx the parse tree
	 */
	void enterCustomTag(JavadocParser.CustomTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#customTag}.
	 * @param ctx the parse tree
	 */
	void exitCustomTag(JavadocParser.CustomTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(JavadocParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(JavadocParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#descriptionLine}.
	 * @param ctx the parse tree
	 */
	void enterDescriptionLine(JavadocParser.DescriptionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#descriptionLine}.
	 * @param ctx the parse tree
	 */
	void exitDescriptionLine(JavadocParser.DescriptionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#inlineTag}.
	 * @param ctx the parse tree
	 */
	void enterInlineTag(JavadocParser.InlineTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#inlineTag}.
	 * @param ctx the parse tree
	 */
	void exitInlineTag(JavadocParser.InlineTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#codeInlineTag}.
	 * @param ctx the parse tree
	 */
	void enterCodeInlineTag(JavadocParser.CodeInlineTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#codeInlineTag}.
	 * @param ctx the parse tree
	 */
	void exitCodeInlineTag(JavadocParser.CodeInlineTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#linkInlineTag}.
	 * @param ctx the parse tree
	 */
	void enterLinkInlineTag(JavadocParser.LinkInlineTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#linkInlineTag}.
	 * @param ctx the parse tree
	 */
	void exitLinkInlineTag(JavadocParser.LinkInlineTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavadocParser#linkPlainInlineTag}.
	 * @param ctx the parse tree
	 */
	void enterLinkPlainInlineTag(JavadocParser.LinkPlainInlineTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavadocParser#linkPlainInlineTag}.
	 * @param ctx the parse tree
	 */
	void exitLinkPlainInlineTag(JavadocParser.LinkPlainInlineTagContext ctx);
}