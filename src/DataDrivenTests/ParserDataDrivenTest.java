package DataDrivenTests;

import com.company.Main;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParserDataDrivenTest {
    private String input;
    private String expectedResult;

    public ParserDataDrivenTest

    @Test
    public void parserTest () {

    }

    @Parameterized.Parameters
    public static Collection parserTestData() {
        return Arrays.asList(new Object[][] {
                { 2, true },
                { 6, false },
                { 19, true },
                { 22, false },
                { 23, true }
        });
    }
}