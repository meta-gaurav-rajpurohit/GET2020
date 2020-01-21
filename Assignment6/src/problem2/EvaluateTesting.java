package problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EvaluateTesting {

    private int fInput[];
    private int sInput[];
    private double tInput;
    private String fExpected;
    
    public EvaluateTesting(int finput[], int sinput[], double tinput, String expected){
            this.fInput=finput;
            this.sInput=sinput;
            this.tInput=tinput;
            this.fExpected=expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {new int[] {1,1,1},new int[] {1,2,3},2.0,"14.0"},
                    {new int[] {1,1,1},new int[] {1,2,4},2.0,"22.0"}
                    });
    }

    @Test
    public void test() {
        Poly p = new Poly(fInput,sInput);
        String result=Double.toString(p.Evaluate(tInput));
        assertEquals(fExpected,result);
    }

}
