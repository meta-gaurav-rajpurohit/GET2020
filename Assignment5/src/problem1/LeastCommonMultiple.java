package problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import problem1.Mathematical;

@RunWith(Parameterized.class)
public class LeastCommonMultiple {

    private int fInput;
    private int sInput;
    private int fExpected;

    public LeastCommonMultiple(int finput, int sinput,int expected) {
        this.fInput = finput;
        this.sInput = sinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 12, 18, 36 },
                { 126, 183, 7686 },
                { 213, 101, 21513 },
                { 106, 130, 6890 } });
    }

    @Test
    public void test() {
        Mathematical LCM = new Mathematical();
        assertEquals(fExpected, LCM.leastCommonMultiple(fInput, sInput));
    }

}