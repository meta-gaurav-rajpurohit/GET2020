package problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddPolyTesting {

    private Poly fInput;
    private Poly sInput;
    private String fExpected;
    
    public AddPolyTesting(Poly finput,Poly sinput,String expected){
            this.fInput=finput;
            this.sInput=sinput;
            this.fExpected=expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {new Poly(new int[] {1,1,1},new int[] {1,2,3}),new Poly(new int[]{1,1,1},new int[]{1,2,3}),"+2x^1+2x^2+2x^3"},
                    {new Poly(new int[] {1,1,1},new int[] {1,2,3}),new Poly(new int[]{1,1,1},new int[]{1,2,4}),"+2x^1+2x^2+1x^3+1x^4"}
                    });
    }

    @Test
    public void test() {
            String result=Poly.AddPoly(fInput,sInput);
            assertEquals(fExpected,result);
    }

}
