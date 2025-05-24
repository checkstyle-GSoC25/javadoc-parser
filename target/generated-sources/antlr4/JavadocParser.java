// Generated from JavadocParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JavadocParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEADING_ASTERISK=1, NEWLINE=2, AUTHOR_LITERAL=3, SEE_LITERAL=4, PARAM_LITERAL=5, 
		CUSTOM_NAME=6, JAVADOC_INLINE_TAG_START=7, TEXT=8, CODE_LITERAL=9, LINK_LITERAL=10, 
		LINKPLAIN_LITERAL=11, JAVADOC_INLINE_TAG_END=12, ASTERISK_IN_TEXT=13, 
		AT_IN_TEXT=14;
	public static final int
		RULE_javadoc = 0, RULE_mainDescription = 1, RULE_javadocLine = 2, RULE_blockTag = 3, 
		RULE_paramTag = 4, RULE_authorTag = 5, RULE_seeTag = 6, RULE_customTag = 7, 
		RULE_description = 8, RULE_descriptionLine = 9, RULE_inlineTag = 10, RULE_codeInlineTag = 11, 
		RULE_linkInlineTag = 12, RULE_linkPlainInlineTag = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"javadoc", "mainDescription", "javadocLine", "blockTag", "paramTag", 
			"authorTag", "seeTag", "customTag", "description", "descriptionLine", 
			"inlineTag", "codeInlineTag", "linkInlineTag", "linkPlainInlineTag"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'@author'", "'@see'", "'@param'", null, "'{'", null, 
			"'@code'", "'@link'", "'@linkplain'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEADING_ASTERISK", "NEWLINE", "AUTHOR_LITERAL", "SEE_LITERAL", 
			"PARAM_LITERAL", "CUSTOM_NAME", "JAVADOC_INLINE_TAG_START", "TEXT", "CODE_LITERAL", 
			"LINK_LITERAL", "LINKPLAIN_LITERAL", "JAVADOC_INLINE_TAG_END", "ASTERISK_IN_TEXT", 
			"AT_IN_TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JavadocParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavadocParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JavadocContext extends ParserRuleContext {
		public MainDescriptionContext mainDescription() {
			return getRuleContext(MainDescriptionContext.class,0);
		}
		public List<BlockTagContext> blockTag() {
			return getRuleContexts(BlockTagContext.class);
		}
		public BlockTagContext blockTag(int i) {
			return getRuleContext(BlockTagContext.class,i);
		}
		public JavadocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javadoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterJavadoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitJavadoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitJavadoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JavadocContext javadoc() throws RecognitionException {
		JavadocContext _localctx = new JavadocContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_javadoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			mainDescription();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) {
				{
				{
				setState(29);
				blockTag();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainDescriptionContext extends ParserRuleContext {
		public List<JavadocLineContext> javadocLine() {
			return getRuleContexts(JavadocLineContext.class);
		}
		public JavadocLineContext javadocLine(int i) {
			return getRuleContext(JavadocLineContext.class,i);
		}
		public MainDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterMainDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitMainDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitMainDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDescriptionContext mainDescription() throws RecognitionException {
		MainDescriptionContext _localctx = new MainDescriptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEADING_ASTERISK) {
				{
				{
				setState(35);
				javadocLine();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JavadocLineContext extends ParserRuleContext {
		public TerminalNode LEADING_ASTERISK() { return getToken(JavadocParser.LEADING_ASTERISK, 0); }
		public List<TerminalNode> TEXT() { return getTokens(JavadocParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(JavadocParser.TEXT, i);
		}
		public List<InlineTagContext> inlineTag() {
			return getRuleContexts(InlineTagContext.class);
		}
		public InlineTagContext inlineTag(int i) {
			return getRuleContext(InlineTagContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JavadocParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JavadocParser.NEWLINE, i);
		}
		public JavadocLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javadocLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterJavadocLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitJavadocLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitJavadocLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JavadocLineContext javadocLine() throws RecognitionException {
		JavadocLineContext _localctx = new JavadocLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_javadocLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(LEADING_ASTERISK);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 388L) != 0)) {
				{
				setState(45);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(42);
					match(TEXT);
					}
					break;
				case JAVADOC_INLINE_TAG_START:
					{
					setState(43);
					inlineTag();
					}
					break;
				case NEWLINE:
					{
					setState(44);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockTagContext extends ParserRuleContext {
		public ParamTagContext paramTag() {
			return getRuleContext(ParamTagContext.class,0);
		}
		public AuthorTagContext authorTag() {
			return getRuleContext(AuthorTagContext.class,0);
		}
		public SeeTagContext seeTag() {
			return getRuleContext(SeeTagContext.class,0);
		}
		public CustomTagContext customTag() {
			return getRuleContext(CustomTagContext.class,0);
		}
		public BlockTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterBlockTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitBlockTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitBlockTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTagContext blockTag() throws RecognitionException {
		BlockTagContext _localctx = new BlockTagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockTag);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARAM_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				paramTag();
				}
				break;
			case AUTHOR_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				authorTag();
				}
				break;
			case SEE_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				seeTag();
				}
				break;
			case CUSTOM_NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				customTag();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamTagContext extends ParserRuleContext {
		public TerminalNode PARAM_LITERAL() { return getToken(JavadocParser.PARAM_LITERAL, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public ParamTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterParamTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitParamTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitParamTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamTagContext paramTag() throws RecognitionException {
		ParamTagContext _localctx = new ParamTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(PARAM_LITERAL);
			setState(57);
			description();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AuthorTagContext extends ParserRuleContext {
		public TerminalNode AUTHOR_LITERAL() { return getToken(JavadocParser.AUTHOR_LITERAL, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public AuthorTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_authorTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterAuthorTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitAuthorTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitAuthorTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuthorTagContext authorTag() throws RecognitionException {
		AuthorTagContext _localctx = new AuthorTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_authorTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(AUTHOR_LITERAL);
			setState(60);
			description();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeeTagContext extends ParserRuleContext {
		public TerminalNode SEE_LITERAL() { return getToken(JavadocParser.SEE_LITERAL, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public SeeTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seeTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterSeeTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitSeeTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitSeeTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeeTagContext seeTag() throws RecognitionException {
		SeeTagContext _localctx = new SeeTagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_seeTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(SEE_LITERAL);
			setState(63);
			description();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CustomTagContext extends ParserRuleContext {
		public TerminalNode CUSTOM_NAME() { return getToken(JavadocParser.CUSTOM_NAME, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public CustomTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterCustomTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitCustomTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitCustomTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomTagContext customTag() throws RecognitionException {
		CustomTagContext _localctx = new CustomTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_customTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(CUSTOM_NAME);
			setState(66);
			description();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public List<DescriptionLineContext> descriptionLine() {
			return getRuleContexts(DescriptionLineContext.class);
		}
		public DescriptionLineContext descriptionLine(int i) {
			return getRuleContext(DescriptionLineContext.class,i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 390L) != 0)) {
				{
				{
				setState(68);
				descriptionLine();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionLineContext extends ParserRuleContext {
		public TerminalNode LEADING_ASTERISK() { return getToken(JavadocParser.LEADING_ASTERISK, 0); }
		public List<TerminalNode> TEXT() { return getTokens(JavadocParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(JavadocParser.TEXT, i);
		}
		public List<InlineTagContext> inlineTag() {
			return getRuleContexts(InlineTagContext.class);
		}
		public InlineTagContext inlineTag(int i) {
			return getRuleContext(InlineTagContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JavadocParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JavadocParser.NEWLINE, i);
		}
		public DescriptionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterDescriptionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitDescriptionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitDescriptionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionLineContext descriptionLine() throws RecognitionException {
		DescriptionLineContext _localctx = new DescriptionLineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_descriptionLine);
		int _la;
		try {
			int _alt;
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEADING_ASTERISK) {
					{
					setState(74);
					match(LEADING_ASTERISK);
					}
				}

				setState(80); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(80);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case TEXT:
							{
							setState(77);
							match(TEXT);
							}
							break;
						case JAVADOC_INLINE_TAG_START:
							{
							setState(78);
							inlineTag();
							}
							break;
						case NEWLINE:
							{
							setState(79);
							match(NEWLINE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(82); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(LEADING_ASTERISK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineTagContext extends ParserRuleContext {
		public TerminalNode JAVADOC_INLINE_TAG_START() { return getToken(JavadocParser.JAVADOC_INLINE_TAG_START, 0); }
		public TerminalNode JAVADOC_INLINE_TAG_END() { return getToken(JavadocParser.JAVADOC_INLINE_TAG_END, 0); }
		public CodeInlineTagContext codeInlineTag() {
			return getRuleContext(CodeInlineTagContext.class,0);
		}
		public LinkInlineTagContext linkInlineTag() {
			return getRuleContext(LinkInlineTagContext.class,0);
		}
		public LinkPlainInlineTagContext linkPlainInlineTag() {
			return getRuleContext(LinkPlainInlineTagContext.class,0);
		}
		public InlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitInlineTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitInlineTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTagContext inlineTag() throws RecognitionException {
		InlineTagContext _localctx = new InlineTagContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inlineTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(JAVADOC_INLINE_TAG_START);
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODE_LITERAL:
				{
				setState(88);
				codeInlineTag();
				}
				break;
			case LINK_LITERAL:
				{
				setState(89);
				linkInlineTag();
				}
				break;
			case LINKPLAIN_LITERAL:
				{
				setState(90);
				linkPlainInlineTag();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(93);
			match(JAVADOC_INLINE_TAG_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeInlineTagContext extends ParserRuleContext {
		public TerminalNode CODE_LITERAL() { return getToken(JavadocParser.CODE_LITERAL, 0); }
		public List<TerminalNode> TEXT() { return getTokens(JavadocParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(JavadocParser.TEXT, i);
		}
		public CodeInlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeInlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterCodeInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitCodeInlineTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitCodeInlineTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeInlineTagContext codeInlineTag() throws RecognitionException {
		CodeInlineTagContext _localctx = new CodeInlineTagContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_codeInlineTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(CODE_LITERAL);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXT) {
				{
				{
				setState(96);
				match(TEXT);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinkInlineTagContext extends ParserRuleContext {
		public TerminalNode LINK_LITERAL() { return getToken(JavadocParser.LINK_LITERAL, 0); }
		public List<TerminalNode> TEXT() { return getTokens(JavadocParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(JavadocParser.TEXT, i);
		}
		public LinkInlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkInlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterLinkInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitLinkInlineTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitLinkInlineTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkInlineTagContext linkInlineTag() throws RecognitionException {
		LinkInlineTagContext _localctx = new LinkInlineTagContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_linkInlineTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(LINK_LITERAL);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXT) {
				{
				{
				setState(103);
				match(TEXT);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinkPlainInlineTagContext extends ParserRuleContext {
		public TerminalNode LINKPLAIN_LITERAL() { return getToken(JavadocParser.LINKPLAIN_LITERAL, 0); }
		public List<TerminalNode> TEXT() { return getTokens(JavadocParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(JavadocParser.TEXT, i);
		}
		public LinkPlainInlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkPlainInlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).enterLinkPlainInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocParserListener ) ((JavadocParserListener)listener).exitLinkPlainInlineTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavadocParserVisitor ) return ((JavadocParserVisitor<? extends T>)visitor).visitLinkPlainInlineTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkPlainInlineTagContext linkPlainInlineTag() throws RecognitionException {
		LinkPlainInlineTagContext _localctx = new LinkPlainInlineTagContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_linkPlainInlineTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LINKPLAIN_LITERAL);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXT) {
				{
				{
				setState(110);
				match(TEXT);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000eu\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005\u0000\u001f\b"+
		"\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0001\u0005\u0001%\b\u0001\n\u0001"+
		"\f\u0001(\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002.\b\u0002\n\u0002\f\u00021\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u00037\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0005\bF\b\b\n\b\f"+
		"\bI\t\b\u0001\t\u0003\tL\b\t\u0001\t\u0001\t\u0001\t\u0004\tQ\b\t\u000b"+
		"\t\f\tR\u0001\t\u0003\tV\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\\"+
		"\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000bb\b\u000b\n\u000b"+
		"\f\u000be\t\u000b\u0001\f\u0001\f\u0005\fi\b\f\n\f\f\fl\t\f\u0001\r\u0001"+
		"\r\u0005\rp\b\r\n\r\f\rs\t\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0000y\u0000"+
		"\u001c\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004)\u0001"+
		"\u0000\u0000\u0000\u00066\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000"+
		"\u0000\n;\u0001\u0000\u0000\u0000\f>\u0001\u0000\u0000\u0000\u000eA\u0001"+
		"\u0000\u0000\u0000\u0010G\u0001\u0000\u0000\u0000\u0012U\u0001\u0000\u0000"+
		"\u0000\u0014W\u0001\u0000\u0000\u0000\u0016_\u0001\u0000\u0000\u0000\u0018"+
		"f\u0001\u0000\u0000\u0000\u001am\u0001\u0000\u0000\u0000\u001c \u0003"+
		"\u0002\u0001\u0000\u001d\u001f\u0003\u0006\u0003\u0000\u001e\u001d\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0001\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		")/\u0005\u0001\u0000\u0000*.\u0005\b\u0000\u0000+.\u0003\u0014\n\u0000"+
		",.\u0005\u0002\u0000\u0000-*\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000027\u0003\b\u0004\u000037\u0003\n\u0005\u0000"+
		"47\u0003\f\u0006\u000057\u0003\u000e\u0007\u000062\u0001\u0000\u0000\u0000"+
		"63\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000"+
		"\u00007\u0007\u0001\u0000\u0000\u000089\u0005\u0005\u0000\u00009:\u0003"+
		"\u0010\b\u0000:\t\u0001\u0000\u0000\u0000;<\u0005\u0003\u0000\u0000<="+
		"\u0003\u0010\b\u0000=\u000b\u0001\u0000\u0000\u0000>?\u0005\u0004\u0000"+
		"\u0000?@\u0003\u0010\b\u0000@\r\u0001\u0000\u0000\u0000AB\u0005\u0006"+
		"\u0000\u0000BC\u0003\u0010\b\u0000C\u000f\u0001\u0000\u0000\u0000DF\u0003"+
		"\u0012\t\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0011\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JL\u0005\u0001\u0000\u0000KJ\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LP\u0001\u0000\u0000\u0000MQ\u0005"+
		"\b\u0000\u0000NQ\u0003\u0014\n\u0000OQ\u0005\u0002\u0000\u0000PM\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TV\u0005\u0001\u0000\u0000UK\u0001\u0000"+
		"\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0013\u0001\u0000\u0000\u0000"+
		"W[\u0005\u0007\u0000\u0000X\\\u0003\u0016\u000b\u0000Y\\\u0003\u0018\f"+
		"\u0000Z\\\u0003\u001a\r\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005"+
		"\f\u0000\u0000^\u0015\u0001\u0000\u0000\u0000_c\u0005\t\u0000\u0000`b"+
		"\u0005\b\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0017\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000fj\u0005\n\u0000\u0000gi\u0005\b"+
		"\u0000\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u0019\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000mq\u0005\u000b\u0000\u0000np\u0005\b\u0000"+
		"\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000qr\u0001\u0000\u0000\u0000r\u001b\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000\u000e &-/6GKPRU[cjq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}