import grammar.JavadocLexer;
import grammar.JavadocParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile = "src/javadoc/input.javadoc";
            String input = new String(Files.readAllBytes(Paths.get(inputFile)));
            printInputStats(input);

            CommonTokenStream tokens = lexingAndPrintStats(input);
            printLexedTokens(tokens);

            JavadocParser parser = new JavadocParser(tokens);
            JavadocParser.JavadocContext tree = ParseAndPrintStats(parser);
            printParseTree(tree, parser);
            DisplayTreeInGUI(tree, parser);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Prints the statistics of the input string.
     *
     * @param input the input string
     */
    private static void printInputStats(String input) {
        int charCount = input.length();
        int lineCount = input.split("\r\n|\r|\n").length;
        System.out.printf("Input size: %d chars, %d lines\n", charCount, lineCount);
    }

    /**
     * Lexes the input string and prints the number of tokens and lexing time.
     *
     * @param input the input string to lex
     * @return the CommonTokenStream containing the lexed tokens
     */
    private static CommonTokenStream lexingAndPrintStats(String input) {
        long lexStart = System.nanoTime();
        CharStream chars = CharStreams.fromString(input);
        JavadocLexer lexer = new JavadocLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        long lexEnd = System.nanoTime();
        double lexTimeMs = (lexEnd - lexStart) / 1_000_000.0;

        System.out.printf("Number of tokens: %d\n", tokens.size());
        System.out.printf("Lex time (ms): %.3f\n", lexTimeMs);

        return tokens;
    }

    /**
     * Prints the lexed tokens.
     *
     * @param tokens the CommonTokenStream containing the lexed tokens
     */
    private static void printLexedTokens(CommonTokenStream tokens) {
        System.out.println("\n=== TOKENS ===");
        for (Token token : tokens.getTokens()) {
            System.out.printf("%-20s '%s'%n",
                    JavadocLexer.VOCABULARY.getSymbolicName(token.getType()),
                    token.getText()
                            .replace("\n", "\\n")
                            .replace("\r", "\\r")
                            .replace("\t", "\\t"));
        }

//        System.out.println("\n=== TOKEN DETAILS ===");
//        for (Token token : tokens.getTokens()) {
//            System.out.println(token.toString());
//        }
    }

    /**
     * Parses the input and prints the parse time.
     *
     * @param parser the JavadocParser instance
     * @return the JavadocContext tree (parse tree)
     */
    private static JavadocParser.JavadocContext ParseAndPrintStats(JavadocParser parser) {

        long parseStart = System.nanoTime();
        JavadocParser.JavadocContext tree = parser.javadoc();
        long parseEnd = System.nanoTime();
        double parseTimeMs = (parseEnd - parseStart) / 1_000_000.0;

        System.out.printf("Parse time (ms): %.3f\n", parseTimeMs);

        return tree;
    }

    private static void printParseTree(JavadocParser.JavadocContext tree, JavadocParser parser) {
        System.out.println("\n=== PARSE TREE ===");
        System.out.println(tree.toStringTree(parser));
    }

    private static void DisplayTreeInGUI(JavadocParser.JavadocContext tree, JavadocParser parser) {
        TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewer.open();
    }
}