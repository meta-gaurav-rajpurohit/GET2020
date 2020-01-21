package problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DegreeTesting {

    private int fInput[];
    private int sInput[];
    private int fExpected;
    
    public DegreeTesting(int finput[], int sinput[], int expected){
            this.fInput=finput;
            this.sInput=sinput;
            this.fExpected=expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {new int[] {1,1,1},new int[] {1,2,3},3},
                    {new int[] {1,1,1},new int[] {1,2,4},4}
                    });
    }

    @Test
    public void test() {
        Poly p = new Poly(fInput,sInput);
        int result=p.Degree();
        assertEquals(fExpected,result);
    }

}
