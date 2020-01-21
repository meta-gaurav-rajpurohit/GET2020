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
public class GetComplementTest {

    private int fInput[];
    private int fExpected[];

    public GetComplementTest(int finput[], int expected[]) {
        this.fInput = finput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 3, 6, 2}, new int[]{ 4, 5, 7, 8, 9, 10} },
                { new int[]{ 1, 3, 6, 2, 4}, new int[]{ 5, 7, 8, 9, 10} },
                { new int[]{1}, new int[]{ 2, 3, 4, 5, 6, 7, 8, 9, 10} },
                { new int[]{ 1, 10, 8, 9}, new int[]{ 2, 3, 4, 5, 6, 7} } });
    }

    @Test
    public void test() {
        intSet  complement = new intSet(fInput);
        assertArrayEquals(fExpected, complement.getComplement());
        
    }

}
