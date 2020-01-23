package assignment6;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddPolyTest {

		private int fInput[];
		private int fInput2[];
		private String fExpected;
		private int fInput5[];
		private int fInput6[];
		
		public AddPolyTest(int input[],int input2[],String expected,int input5[],int input6[]){
			this.fInput=input;
			this.fInput2=input2;
			this.fExpected=expected;
			this.fInput5=input5;
			this.fInput6=input6;
		}
		
		@Parameters
		public static Collection<Object[]> data(){
			return Arrays.asList(new Object[][] {
				{new int[] {1,1,1},new int[] {1,2,3},"+2x^1+2x^2+2x^3",new int[]{1,1,1},new int[]{1,2,3}},
				{new int[] {1,1,1},new int[] {1,2,3},"+2x^1+2x^2+1x^3+1x^4",new int[]{1,1,1},new int[]{1,2,4}}
				});
		}

		@Test
		public void test() {
			Poly poly=new Poly(fInput,fInput2,fInput5,fInput6);
			String result=poly.AddPoly();
			assertEquals(fExpected,result);
		}

}


