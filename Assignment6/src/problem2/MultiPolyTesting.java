package problem2;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MultiPolyTesting {

    private Poly fInput;
    private Poly sInput;
    private String fExpected;
    
    public MultiPolyTesting(Poly finput,Poly sinput,String expected){
            this.fInput=finput;
            this.sInput=sinput;
            this.fExpected=expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {new Poly(new int[] {1,1,1},new int[] {3, 1, 0}),new Poly(new int[]{1,1,1},new int[]{2,1,0}),"+1x^0+2x^1+2x^2+2x^3+1x^4+1x^5"},
                    {new Poly(new int[] {1,1,1},new int[] {1,2,3}),new Poly(new int[]{1,1,1},new int[]{1,2,4}),"+1x^2+2x^3+2x^4+2x^5+1x^6+1x^7"}
                    });
    }

    @Test
    public void test() {
            String result=Poly.MultiPoly(fInput,sInput);
            assertEquals(fExpected,result);
    }

}
