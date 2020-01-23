package assignment6;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MultiPolyTest {

	private Poly fInput;
	private Poly fInput2;
	private String fExpected;
	
	public MultiPolyTest(int finput,int sinput,String expected){
		this.fInput=finput;
		this.sInput=sinput;
		this.fExpected=expected;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {1,1,1},new int[] {1,2,3},"+1x^2+1x^3+1x^4+1x^3+1x^4+1x^5+1x^4+1x^5+1x^6",new int[]{1,1,1},new int[]{1,2,3}},
			{new int[] {1,1,1},new int[] {1,2,3},"+1x^2+1x^3+1x^5+1x^3+1x^4+1x^6+1x^4+1x^5+1x^7",new int[]{1,1,1},new int[]{1,2,4}}
			});
	}

	@Test
	public void test() {
		Poly poly=new Poly(fInput,fInput2,fInput5,fInput6);
		String result=poly.MultiPoly();
		assertEquals(fExpected,result);
	}


}
