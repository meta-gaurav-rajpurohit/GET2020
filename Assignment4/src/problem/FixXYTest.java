package problem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FixXYTest {

    private int fInput[];
    private int sInput;
    private int tInput;
    private int fExpected[];

    public FixXYTest(int finput[], int sinput, int tinput, int expected[]) {
        this.fInput = finput;
        this.sInput = sinput;
        this.tInput = tinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5,
                        new int[] { 9, 4, 5, 4, 5, 9 } },
                { new int[] { 1, 4, 1, 5 }, 4, 5, new int[] { 1, 4, 5, 1 } },
                { new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5,
                        new int[] { 1, 4, 5, 1, 1, 4, 5 } } });
    }

    @Test
    public void test() {
        ArrOperation fixXY = new ArrOperation();
        assertArrayEquals(fExpected, fixXY.fixXY(fInput, sInput, tInput));
    }

}
