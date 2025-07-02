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
    public void testInlineLinkTag4() throws IOException {
        verifyAst(getPath("inlineLink4.txt"), getPath("inlineLink4.javadoc"));
    }

    @Test
    public void testInlineLinkTag5() throws IOException {
        verifyAst(getPath("inlineLink5.txt"), getPath("inlineLink5.javadoc"));
    }

    @Test
    public void testInlineLinkTag6() throws IOException {
        verifyAst(getPath("inlineLink6.txt"), getPath("inlineLink6.javadoc"));
    }

    @Test
    public void testInlineInheritDoc() throws IOException {
        verifyAst(getPath("inheritDoc.txt"), getPath("inheritDoc.javadoc"));
    }

    @Test
    public void testInlineSummary() throws IOException {
        verifyAst(getPath("inlineSummary.txt"), getPath("inlineSummary.javadoc"));
    }

    @Test
    public void testSystemPropertyTag() throws IOException {
        verifyAst(getPath("systemPropertyTag.txt"), getPath("systemPropertyTag.javadoc"));
    }

    @Test
    public void testInlineIndex() throws IOException {
        verifyAst(getPath("indexTag.txt"), getPath("indexTag.javadoc"));
    }

    @Test
    public void testInlineReturn() throws IOException {
        verifyAst(getPath("inlineReturn.txt"), getPath("inlineReturn.javadoc"));
    }

    @Test
    public void testInlineLiteral() throws IOException {
        verifyAst(getPath("literalTag.txt"), getPath("literalTag.javadoc"));
    }

    @Test
    public void testCustomInlineTag() throws IOException {
        verifyAst(getPath("customInlineTag.txt"), getPath("customInlineTag.javadoc"));
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

    @Test
    public void testNonTightTags() throws IOException {
        verifyAst(getPath("htmlNonTight1.txt"), getPath("htmlNonTight1.javadoc"));
    }


    @Test
    public void testCodeTagWithNestedBraces() throws IOException {
        verifyAst(getPath("codeTagWithNestedBraces.txt"), getPath("codeTagWithNestedBraces.javadoc"));
    }

    @Test
    public void testNonTightTags2() throws IOException {
        verifyAst(getPath("htmlNonTight2.txt"), getPath("htmlNonTight2.javadoc"));
    }

    @Test
    public void testNonTightTags3() throws IOException {
        verifyAst(getPath("htmlNonTight3.txt"), getPath("htmlNonTight3.javadoc"));
    }

    @Test
    public void testNonTightTags4() throws IOException {
        verifyAst(getPath("htmlNonTight4.txt"), getPath("htmlNonTight4.javadoc"));
    }

    @Test
    public void testNonTightTags5() throws IOException {
        verifyAst(getPath("htmlNonTight5.txt"), getPath("htmlNonTight5.javadoc"));
    }

    @Test
    public void testNonTightTags6() throws IOException {
        verifyAst(getPath("htmlNonTight6.txt"), getPath("htmlNonTight6.javadoc"));
    }

    @Test
    public void testEmptyHtmlContent() throws IOException {
        verifyAst(getPath("emptyHtmlContent.txt"), getPath("emptyHtmlContent.javadoc"));
    }

    @Test
    public void testComplex() throws IOException {
        verifyAst(getPath("complex.txt"), getPath("complex.javadoc"));
    }

    @Test
    public void testValueTag() throws IOException {
        verifyAst(getPath("valueInlineTag.txt"), getPath("valueInlineTag.javadoc"));
    }

    @Test
    public void testTagEnd() throws IOException {
        verifyAst(getPath("tagEnd.txt"), getPath("tagEnd.javadoc"));
    }

    @Test
    public void testComplex2() throws IOException {
        verifyAst(getPath("complex2.txt"), getPath("complex2.javadoc"));
    }
}
