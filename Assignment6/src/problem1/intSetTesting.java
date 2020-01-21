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
public class intSetTesting {

    private int fInput[];
    private int sInput;
    private boolean fExpected;

    public intSetTesting(int finput[], int sinput,boolean expected) {
        this.fInput = finput;
        this.sInput = sinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 3, 6, 2}, 2, true },
                { new int[]{ 1, 3, 6, 2}, 6, true },
                { new int[]{ 1, 10, 6, 8}, 10, true },
                { new int[]{ 1, 3, 16, 12}, 10, false } });
    }

    @Test
    public void test() {
        intSet  FindMember = new intSet(fInput);
        assertEquals(fExpected, FindMember.isMember(sInput));
        
    }

}
