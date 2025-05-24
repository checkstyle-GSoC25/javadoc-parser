// Generated from JavadocLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JavadocLexer extends Lexer {
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
		JavadocInlineTag=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "JavadocInlineTag"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LEADING_ASTERISK", "NEWLINE", "AUTHOR_LITERAL", "SEE_LITERAL", "PARAM_LITERAL", 
			"CUSTOM_NAME", "JAVADOC_INLINE_TAG_START", "ASTERISK_IN_TEXT", "AT_IN_TEXT", 
			"TEXT", "CODE_LITERAL", "LINK_LITERAL", "LINKPLAIN_LITERAL", "JavadocInlineTag_TEXT", 
			"JavadocInlineTag_AT_IN_TEXT", "JavadocInlineTag_ASTERISK_IN_TEXT", "JAVADOC_INLINE_TAG_END"
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


	    private int previousTokenType = 0;
	    private Token previousToken = null;
	    private boolean afterNewline = true;
	    private boolean isJavadocTag = true;

	    public boolean isAfterNewline() {
	        return afterNewline;
	    }

	    public void setAfterNewline() {
	        afterNewline = true;
	    }

	    /*
	        Each block tag must appear at the beginning of a line, ignoring leading asterisks,
	        whitespace characters. This means you can use the @ character elsewhere in the text
	        and it will not be interpreted as the start of a tag.
	    */
	    private boolean isJavadocTag() {
	        if (previousToken == null) {
	            return true;
	        }
	        return previousTokenType == LEADING_ASTERISK || previousToken.getText().isBlank();
	    }

	    @Override
	    public void emit(Token token) {
	        super.emit(token);
	        previousTokenType = token.getType();
	        previousToken = token;

	        if (previousTokenType != NEWLINE) {
	            afterNewline = false;
	        }
	    }


	public JavadocLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavadocLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setAfterNewline(); 
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return LEADING_ASTERISK_sempred((RuleContext)_localctx, predIndex);
		case 2:
			return AUTHOR_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 3:
			return SEE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 4:
			return PARAM_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 5:
			return CUSTOM_NAME_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean LEADING_ASTERISK_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isAfterNewline();
		}
		return true;
	}
	private boolean AUTHOR_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isJavadocTag();
		}
		return true;
	}
	private boolean SEE_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isJavadocTag();
		}
		return true;
	}
	private boolean PARAM_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return isJavadocTag();
		}
		return true;
	}
	private boolean CUSTOM_NAME_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return isJavadocTag();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000\u000e\u0090\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"+
		"\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"+
		"\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"+
		"\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"+
		"\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001"+
		"\u0000\u0005\u0000&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0004"+
		"\u0005P\b\u0005\u000b\u0005\f\u0005Q\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0004\tc\b\t\u000b"+
		"\t\f\td\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0004\r\u007f\b\r\u000b\r\f\r\u0080\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000"+
		"\u0011\u0002\u0001\u0004\u0002\u0006\u0003\b\u0004\n\u0005\f\u0006\u000e"+
		"\u0007\u0010\r\u0012\u000e\u0014\b\u0016\t\u0018\n\u001a\u000b\u001c\u0000"+
		"\u001e\u0000 \u0000\"\f\u0002\u0000\u0001\u0003\u0002\u0000\t\t  \u0005"+
		"\u0000-.0:AZ__az\u0006\u0000\n\n\r\r**@@{{}}\u0093\u0000\u0002\u0001\u0000"+
		"\u0000\u0000\u0000\u0004\u0001\u0000\u0000\u0000\u0000\u0006\u0001\u0000"+
		"\u0000\u0000\u0000\b\u0001\u0000\u0000\u0000\u0000\n\u0001\u0000\u0000"+
		"\u0000\u0000\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001\u0000\u0000\u0000"+
		"\u0000\u0010\u0001\u0000\u0000\u0000\u0000\u0012\u0001\u0000\u0000\u0000"+
		"\u0000\u0014\u0001\u0000\u0000\u0000\u0001\u0016\u0001\u0000\u0000\u0000"+
		"\u0001\u0018\u0001\u0000\u0000\u0000\u0001\u001a\u0001\u0000\u0000\u0000"+
		"\u0001\u001c\u0001\u0000\u0000\u0000\u0001\u001e\u0001\u0000\u0000\u0000"+
		"\u0001 \u0001\u0000\u0000\u0000\u0001\"\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00063\u0001"+
		"\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000"+
		"\fM\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010Y\u0001"+
		"\u0000\u0000\u0000\u0012]\u0001\u0000\u0000\u0000\u0014b\u0001\u0000\u0000"+
		"\u0000\u0016f\u0001\u0000\u0000\u0000\u0018l\u0001\u0000\u0000\u0000\u001a"+
		"r\u0001\u0000\u0000\u0000\u001c~\u0001\u0000\u0000\u0000\u001e\u0084\u0001"+
		"\u0000\u0000\u0000 \u0088\u0001\u0000\u0000\u0000\"\u008c\u0001\u0000"+
		"\u0000\u0000$&\u0007\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&)\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005*\u0000\u0000"+
		"+,\u0004\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-/\u0005\r\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0005\n\u0000\u000012\u0006\u0001\u0000\u00002\u0005\u0001"+
		"\u0000\u0000\u000034\u0005@\u0000\u000045\u0005a\u0000\u000056\u0005u"+
		"\u0000\u000067\u0005t\u0000\u000078\u0005h\u0000\u000089\u0005o\u0000"+
		"\u00009:\u0005r\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0004\u0002\u0001"+
		"\u0000<\u0007\u0001\u0000\u0000\u0000=>\u0005@\u0000\u0000>?\u0005s\u0000"+
		"\u0000?@\u0005e\u0000\u0000@A\u0005e\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"BC\u0004\u0003\u0002\u0000C\t\u0001\u0000\u0000\u0000DE\u0005@\u0000\u0000"+
		"EF\u0005p\u0000\u0000FG\u0005a\u0000\u0000GH\u0005r\u0000\u0000HI\u0005"+
		"a\u0000\u0000IJ\u0005m\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0004\u0004"+
		"\u0003\u0000L\u000b\u0001\u0000\u0000\u0000MO\u0005@\u0000\u0000NP\u0007"+
		"\u0001\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000ST\u0004\u0005\u0004\u0000T\r\u0001\u0000\u0000\u0000UV\u0005{\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WX\u0006\u0006\u0001\u0000X\u000f\u0001"+
		"\u0000\u0000\u0000YZ\u0005*\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0006"+
		"\u0007\u0002\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0005@\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0006\b\u0002\u0000`\u0013\u0001\u0000\u0000"+
		"\u0000ac\b\u0002\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0015\u0001"+
		"\u0000\u0000\u0000fg\u0005@\u0000\u0000gh\u0005c\u0000\u0000hi\u0005o"+
		"\u0000\u0000ij\u0005d\u0000\u0000jk\u0005e\u0000\u0000k\u0017\u0001\u0000"+
		"\u0000\u0000lm\u0005@\u0000\u0000mn\u0005l\u0000\u0000no\u0005i\u0000"+
		"\u0000op\u0005n\u0000\u0000pq\u0005k\u0000\u0000q\u0019\u0001\u0000\u0000"+
		"\u0000rs\u0005@\u0000\u0000st\u0005l\u0000\u0000tu\u0005i\u0000\u0000"+
		"uv\u0005n\u0000\u0000vw\u0005k\u0000\u0000wx\u0005p\u0000\u0000xy\u0005"+
		"l\u0000\u0000yz\u0005a\u0000\u0000z{\u0005i\u0000\u0000{|\u0005n\u0000"+
		"\u0000|\u001b\u0001\u0000\u0000\u0000}\u007f\b\u0002\u0000\u0000~}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0006\r\u0002\u0000\u0083\u001d\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005@\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0006\u000e\u0002\u0000\u0087\u001f\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005*\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0006\u000f\u0002\u0000\u008b!\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005}\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0006"+
		"\u0010\u0003\u0000\u008f#\u0001\u0000\u0000\u0000\u0007\u0000\u0001\'"+
		".Qd\u0080\u0004\u0001\u0001\u0000\u0005\u0001\u0000\u0007\b\u0000\u0004"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}