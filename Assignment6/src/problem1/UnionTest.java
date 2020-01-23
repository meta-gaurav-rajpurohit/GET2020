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
public class UnionTest {

    private intSet fInput;
    private intSet sInput;
    private int fExpected[];

    public UnionTest(int finput[], int sinput[], int expected[]) {
        this.fInput = new intSet(finput);
        this.sInput = new intSet(sinput);
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 3, 6, 2}, new int[]{ 8, 9, 11, 13}, new int[]{ 1, 2, 3, 6, 8, 9, 11, 13}},
                { new int[]{ 1, 6, 2},  new int[]{ 11, 13, 16, 12}, new int[]{ 1, 2, 6, 11, 12, 13, 16}},
                { new int[]{5}, new int[]{ 1, 3, 6, 2}, new int[]{ 1, 2, 3, 5, 6}},
                { new int[]{ 1}, new int[]{3, 6, 2}, new int[]{ 1, 2, 3, 6}} });
    }

    @Test
    public void test() {
        intSet  union = new intSet();
        assertArrayEquals(fExpected, union.union(fInput, sInput));
        
    }

}
