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
public class IsSubSetTest {

    private int fInput[];
    private intSet sInput;
    private boolean fExpected;

    public IsSubSetTest(int finput[], intSet sinput,boolean expected) {
        this.fInput = finput;
        this.sInput = sinput; 
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 3, 6, 2}, new intSet(new int[]{ 1, 3, 6}), true },
                { new int[]{ 1, 13, 63, 25}, new intSet(new int[]{ 12, 3, 65, 2}), false},
                { new int[]{ 1, 13, 16, 21}, new intSet(new int[]{ 1, 2}), false},
                { new int[]{ 12, 54}, new intSet(new int[]{ 12}), true} });
    }

    @Test
    public void test() {
        intSet  subset = new intSet(fInput);
        assertEquals(fExpected, subset.isSubSet(sInput));
        
    }

}
