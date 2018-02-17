package UnitTests;
import com.company.Main;
import com.company.Parser;
import com.company.Token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.company.TokenKind;
import org.junit.Test;


public class ParserUnitTests {

   Parser testParser = new Parser ();

    @Test
    public void checkStyleTest () {
        String styleResult = Main.Style(TokenKind.Keyword);
        assertEquals("<b style = \"color:#C61717\" >", styleResult);
    }

    @Test
    public void parseOneTokenTest () {
            String textToParse = "//comment" ;
            testParser.setText(textToParse);
            Token parsedToken = testParser.identificationToken();
            assertEquals(TokenKind.Comment, parsedToken.getTokenKind());
            assertEquals(textToParse, parsedToken.getTokenValue());
    }

    @Test
    public void parseFourTokensTest () {
        String textToParse = "begin var a;" ;
        testParser.setText(textToParse);
        testParser.parse();
        assertEquals(4, testParser.getTokens().size());
    }

    @Test
    public void readFileTestShouldBeSomeText () {
        testParser.setPath("testFileRead.pas");
        testParser.readFile();
        assertEquals("some text", testParser.getText());
    }
}