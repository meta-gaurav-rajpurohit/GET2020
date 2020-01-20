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
public class HighestCommonFactor {

    private int fInput;
    private int sInput;
    private int fExpected;

    public HighestCommonFactor(int finput, int sinput,int expected) {
        this.fInput = finput;
        this.sInput = sinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 12, 18, 6 },
                { 126, 183, 3 },
                { 213, 101, 1 },
                { 106, 130, 2 } });
    }

    @Test
    public void test() {
        Mathematical HCF = new Mathematical();
        assertEquals(fExpected, HCF.highestCommonFactor(fInput, sInput));
    }

}
