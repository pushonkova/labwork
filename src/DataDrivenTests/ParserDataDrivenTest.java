package DataDrivenTests;

import com.company.Main;
import com.company.Parser;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParserDataDrivenTest {
    private static String PREFIX="src/resources/";
    private String input;
    private String expectedResult;
    private String actualResult=PREFIX+"currentActualResult.html";


    public ParserDataDrivenTest (String input, String expectedResult) {
        this.input=PREFIX+input;
        this.expectedResult=PREFIX+expectedResult;
    }

    @Test
    public void parserTest () {
        Main.Parse(input, actualResult);
        Parser parser = new Parser();
        String expected=parser.readFileIntoString(expectedResult);
        String actual=parser.readFileIntoString(actualResult);
        assertEquals(expected,actual);
    }

    @Parameterized.Parameters
    public static Collection parserTestData() {
        return Arrays.asList(new Object[][] {
                { "emptyFile-request.pas", "emptyFile-response.html"},
                {"helloWorld-request.pas", "helloWorld-response.html"},
                {"dataTypes-request.pas", "dataTypes-response.html"},
                {"literals-request.pas", "literals-response.html"},
                {"cycles-request.pas", "cycles-response.html"},
                {"simpleProgram-request.pas", "simpleProgram-response.html"},


        });
    }
}