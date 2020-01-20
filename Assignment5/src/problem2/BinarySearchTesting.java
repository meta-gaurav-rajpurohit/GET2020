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
public class BinarySearchTesting {

    private int firstInput[];
    private int secondInput;
    private int thirdInput;
    private int fourthInput;
    private int fExpected;

    public BinarySearchTesting(int firstinput[], int secondinput, int thirdinput, int fourthinput, int expected) {
        this.firstInput = firstinput;
        this.secondInput = secondinput;
        this.thirdInput = thirdinput;
        this.fourthInput = fourthinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 2, 3, 4, 5, 6, 7 }, 0, 6 , 2, 1},
                { new int[]{ 1, 4, 5, 7, 9, 16, 17 }, 0, 6 , 7, 3},
                { new int[]{ 1, 4, 6, 17, 29, 33, 55 }, 0, 6 , 33, 5},
                { new int[]{ 1, 14, 22, 37, 49, 53, 65 }, 0, 6, 65, 6} });
    }

    @Test
    public void test() {
        Search linearSearch = new Search();
        assertEquals(fExpected, linearSearch.binarySearch(firstInput, secondInput, thirdInput, fourthInput));
    }

}
