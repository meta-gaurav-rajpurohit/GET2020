package assignment6;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EvaluateTest {

	private int fInput[];
	private int fInput2[];
	private double fExpected;
	private double fInput4;
	private int fInput5[];
	private int fInput6[];
	
	public EvaluateTest(int input[],int input2[],double input3,double expected,int input5[],int input6[]){
		this.fInput=input;
		this.fInput2=input2;
		this.fInput4=input3;
		this.fExpected=expected;
		this.fInput5=input5;
		this.fInput6=input6;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[] {1,1,1},new int[] {1,2,3},1,3,new int[]{},new int[]{}}
			});
	}

	@Test
	public void test() {
		Poly poly=new Poly(fInput,fInput2,fInput5,fInput6);
		double result=poly.Evaluate(fInput4);
		assertEquals((int)fExpected,(int)result);
	}

}
