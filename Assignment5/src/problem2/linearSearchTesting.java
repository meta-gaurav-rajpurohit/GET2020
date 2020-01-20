package problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import problem2.Search;

@RunWith(Parameterized.class)
public class linearSearchTesting {

    private int fInput[];
    private int sInput;
    private int tInput;
    private int fExpected;

    public linearSearchTesting(int finput[], int sinput, int tinput,int expected) {
        this.fInput = finput;
        this.sInput = sinput;
        this.tInput = tinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 4, 2, 7, 9, 3, 5 }, 6, 2 , 2},
                { new int[]{ 1, 4, 2, 7, 9, 3, 5 }, 6, 5 , 6},
                { new int[]{ 1, 4, 2, 7, 9, 3, 5 }, 6, 1 , 0},
                { new int[]{ 1, 4, 2, 7, 9, 3, 5 }, 6, 4 , 1} });
    }

    @Test
    public void test() {
        Search linearSearch = new Search();
        assertEquals(fExpected, linearSearch.linearSearch(fInput, sInput, tInput));
    }

}
