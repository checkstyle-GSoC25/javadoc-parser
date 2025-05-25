import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AstTest extends AbstractTestSupport {
    @Override
    protected String getPackageLocation() {
        return "";
    }

    @Test
    public void testEmpty() throws IOException {
        verifyAst(getPath("empty.txt"), getPath("empty.javadoc"));
    }

    @Test
    public void testJavadocWithText() throws IOException {
        verifyAst(getPath("text.txt"), getPath("text.javadoc"));
    }

    @Test
    public void testJavadocWithText2() throws IOException {
        verifyAst(getPath("text2.txt"), getPath("text2.javadoc"));
    }

    @Test
    public void testInlineCodeTag1() throws IOException {
        verifyAst(getPath("inline1.txt"), getPath("inline1.javadoc"));
    }

    // TODO: fix line 6:3 token recognition error at: '}'
    @Test
    public void testInlineCodeTag2() throws IOException {
        verifyAst(getPath("inline2.txt"), getPath("inline2.javadoc"));
    }

    @Test
    public void testInlineLinkTag1() throws IOException {
        verifyAst(getPath("inlineLink1.txt"), getPath("inlineLink1.javadoc"));
    }

    @Test
    public void testInlineLinkTag2() throws IOException {
        verifyAst(getPath("inlineLink2.txt"), getPath("inlineLink2.javadoc"));
    }

    @Test
    public void testInlineLinkTag3() throws IOException {
        verifyAst(getPath("inlineLink3.txt"), getPath("inlineLink3.javadoc"));
    }
}
