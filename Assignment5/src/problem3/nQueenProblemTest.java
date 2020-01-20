package problem3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import problem3.nQueenProblem;

@RunWith(Parameterized.class)
public class nQueenProblemTest {

    private int firstInput;
    private int fExpected[];

    public nQueenProblemTest(int firstinput, int expected[]) {
        this.firstInput = firstinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, new int[]{ 0, 2, 4, 1, 3}},
                { 4, new int[]{ 1, 3, 0, 2}},
                { 2, new int[]{ -1}},
                { 6, new int[]{ 1, 3, 5, 0, 2, 4}}});
    }

    @Test
    public void test() {
        nQueenProblem nQueen = new nQueenProblem();
        assertArrayEquals(fExpected, nQueen.setNQueenBoard(firstInput));
    }

}
