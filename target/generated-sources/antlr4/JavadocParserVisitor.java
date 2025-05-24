// Generated from JavadocParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavadocParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavadocParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavadocParser#javadoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavadoc(JavadocParser.JavadocContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#mainDescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDescription(JavadocParser.MainDescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#javadocLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavadocLine(JavadocParser.JavadocLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#blockTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockTag(JavadocParser.BlockTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#paramTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamTag(JavadocParser.ParamTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#authorTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthorTag(JavadocParser.AuthorTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#seeTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeeTag(JavadocParser.SeeTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#customTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomTag(JavadocParser.CustomTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(JavadocParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#descriptionLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptionLine(JavadocParser.DescriptionLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#inlineTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineTag(JavadocParser.InlineTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#codeInlineTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeInlineTag(JavadocParser.CodeInlineTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#linkInlineTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkInlineTag(JavadocParser.LinkInlineTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavadocParser#linkPlainInlineTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkPlainInlineTag(JavadocParser.LinkPlainInlineTagContext ctx);
}