package UnitTests;
import com.company.Main;
import com.company.Parser;
import com.company.Token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import java.util.ArrayList;

import com.company.TokenKind;
import org.junit.Test;


public class ParserUnitTests {

   Parser testParser = new Parser ();

   @Test(expected = NullPointerException.class)
   public void notExistingFileTest () {
       Main.Parse("notExisitngFile.pas", "result.html");
   }

    @Test
    public void readFileTextShouldBeSomeText () {
        testParser.setPath("testFileRead.pas");
        testParser.readFile();
        assertEquals("some text", testParser.getText());
    }

    @Test
    public void parseIdentificationOneTokenTest () {
            String textToParse = "//comment" ;
            testParser.setText(textToParse);
            Token parsedToken = testParser.identificationToken();
            assertEquals(TokenKind.Comment, parsedToken.getTokenKind());
            assertEquals(textToParse, parsedToken.getTokenValue());
    }

    @Test
    public void parseTestNumberOfTokensShouldBe4Test () {
        String textToParse = "begin var a;" ;
        testParser.setText(textToParse);
        testParser.parse();
        assertEquals(4, testParser.getTokens().size());
    }

    @Test
    public void getResultFewTokensTest () {
        testParser.setPath("testParse3Tokens.pas");
        ArrayList<Token> parsedTokens = testParser.getResult();
        ArrayList<Token> expectedTokens = new ArrayList<Token>();
        Token token1 = new Token ("program", TokenKind.Keyword);
        Token token2 = new Token ("a", TokenKind.Identifier);
        Token token3 = new Token (";", TokenKind.Punctuator);
        expectedTokens.add(token1);
        expectedTokens.add(token2);
        expectedTokens.add(token3);
        for (int i=0; i<3; i++) {
            assertEquals(expectedTokens.get(i).getTokenValue(), parsedTokens.get(i).getTokenValue());
            assertEquals(expectedTokens.get(i).getTokenKind(), parsedTokens.get(i).getTokenKind());
        }

    }

    @Test
    public void checkStyleTest () {
        String styleResult = Main.Style(TokenKind.Keyword);
        assertEquals("<b style = \"color:#C61717\" >", styleResult);
    }
}