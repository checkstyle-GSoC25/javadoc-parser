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
    public void testSpecialCharacter() throws IOException {
    verifyAst(getPath("specialCharacter.txt"), getPath("specialCharacter.javadoc"));
    }

    @Test
    public void testInlineCodeTag1() throws IOException {
        verifyAst(getPath("inline1.txt"), getPath("inline1.javadoc"));
    }

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

    @Test
    public void testBlockAuthorTag() throws IOException {
        verifyAst(getPath("blockAuthor.txt"), getPath("blockAuthor.javadoc"));
    }

    @Test
    public void testBlockReturnTag() throws IOException {
        verifyAst(getPath("blockReturn.txt"), getPath("blockReturn.javadoc"));
    }

    @Test
    public void testBlockParamTag() throws IOException {
        verifyAst(getPath("blockParam.txt"), getPath("blockParam.javadoc"));
    }

    @Test
    public void testHTML1() throws IOException {
        verifyAst(getPath("html1.txt"), getPath("html1.javadoc"));
    }

    @Test
    public void testHTML2() throws IOException {
        verifyAst(getPath("html2.txt"), getPath("html2.javadoc"));
    }

    @Test
    public void testVoidTags() throws IOException {
        verifyAst(getPath("htmlVoidTags1.txt"), getPath("htmlVoidTags1.javadoc"));
    }

    // TODO: Handle non-tight html tags
    @Test
    public void testNonTightTags() throws IOException {
        verifyAst(getPath("htmlNonTight1.txt"), getPath("htmlNonTight1.javadoc"));
    }
}
