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
}
