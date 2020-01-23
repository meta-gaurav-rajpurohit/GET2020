package problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import problem1.intSet;

@RunWith(Parameterized.class)
public class SizeTeat {

    private int fInput[];
    private int fExpected;

    public SizeTeat(int finput[], int expected) {
        this.fInput = finput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 3, 6, 2}, 4 },
                { new int[]{ 1, 3, 6, 2}, 4 },
                { new int[]{1,1,1}, 3 },
                { new int[]{ 1}, 1 } });
    }

    @Test
    public void test() {
        intSet  is = new intSet(fInput);
        assertEquals(fExpected, is.size());
        
    }

}
