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
    private String input;
    private String expectedResult;
    private String actualResult;

    public ParserDataDrivenTest (String input, String expectedResult, String actualResult) {
        this.input=input;
        this.expectedResult=expectedResult;
        this.actualResult=actualResult;
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
                { "test2.pas", "output.html", "actual.html" }

        });
    }
}