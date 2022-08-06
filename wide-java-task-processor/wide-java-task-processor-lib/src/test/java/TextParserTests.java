import com.widejava.task.processor.constant.RegexConstant;
import constant.Constants;
import org.junit.jupiter.api.Test;
import util.TxtReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTests {

    @Test
    public void externalTestResultParserTest() {
        final String actual = RegexConstant.TEST_RESULT.getResult(TxtReader.getText(Constants.RESOURCE_PATH
                + "test-result-parser-source.txt"));
        final String expected = TxtReader.getText(Constants.RESOURCE_PATH + "test-result-parser-expected.txt");
        assertEquals(expected, actual);
    }

}
