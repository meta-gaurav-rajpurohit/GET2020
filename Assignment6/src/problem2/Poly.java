package problem2;

public final class Poly {

    final int[] coeff;
    final int[] power;

    /**
     * Constructor to initialize the input arrays
     * 
     * @param input
     *            denotes input coefficient of 1st polynomial
     * @param input2
     *            denotes input power of 1st polynomial
     * @param input3
     *            denotes input coefficient of 2nd polynomial
     * @param input4
     *            denotes input power of 2nd polynomial
     */
    public Poly(int[] input, int[] input2) {
        coeff = input;
        power = input2;

    }

    /**
     * Returns the evaluated result of the polynomial
     * 
     * @param x
     *            denotes the value of x
     * @return evaluated result of the polynomial
     */
    public double Evaluate(double x) {
        double result = 0;
        for (int i = 0; i < this.coeff.length; i++)
            result += (this.coeff[i] * Math.pow(x, this.power[i]));

        return result;
    }

    /**
     * Returns the degree of the polynomial
     * 
     * @return degree of the polynomial
     */
    public int Degree() {
        int max = 0;
        for (int i = 0; i < coeff.length; i++) {
            if (power[i] > max)
                max = power[i];
        }
        return max;
    }

    /**
     * Returns the string which shows the addition of two polynomials
     * 
     * @return the string which shows the addition of two polynomials
     */
    public static String AddPoly(Poly p1, Poly p2) {
        String str = "";
        int sum, flag;
        for (int i = 0; i < p1.coeff.length; i++) {
            sum = 0;
            flag = 0;
            for (int j = 0; j < p2.coeff.length; j++) {
                if (p1.power[i] == p2.power[j]) {
                    sum = p1.coeff[j] + p2.coeff[j];
                    str += "+" + sum + "x^" + p1.power[j];
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                str += "+" + p1.coeff[i] + "x^" + p1.power[i];
            }
        }

        for (int i = 0; i < p2.coeff.length; i++) {
            sum = 0;
            flag = 0;
            for (int j = 0; j < p1.coeff.length; j++) {
                if (p1.power[i] == p2.power[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                str += "+" + p2.coeff[i] + "x^" + p2.power[i];
            }
        }
        return str;
    }

    /**
     * Returns the string which shows the multiplication of two polynomials
     * 
     * @return the string which shows the multiplication of two polynomials
     */
    public static String MultiPoly(Poly p1, Poly p2) {
        String str = "";
        int coe = 0;
        int pow = 0;
        int l=0;
        int temporaryArrayCoe[] = new int[p1.coeff.length * p2.coeff.length];
        int temporaryArrayPow[] = new int[p1.coeff.length * p2.coeff.length];
        int ansCoe[] = new int[p1.coeff.length * p2.coeff.length];
        int ansPow[] = new int[p1.coeff.length * p2.coeff.length];
        System.out.println(p1.coeff.length+" "+p2.coeff.length);
        for (int i = 0; i < p1.coeff.length; i++) {
            for (int j = 0; j < p2.coeff.length; j++) {
                coe = p1.coeff[i] * p2.coeff[j];
                pow = p1.power[i] + p2.power[j];
                temporaryArrayCoe[l] = coe;
                temporaryArrayPow[l] = pow;
                l++;
                
                System.out.println(temporaryArrayCoe[i]+" "+temporaryArrayPow[i]);
            }
        }
        for (int i = 0; i < temporaryArrayPow.length-1; i++) {
            for (int j = 0; j < temporaryArrayPow.length-i-1; j++){ 
                if (temporaryArrayPow[j] > temporaryArrayPow[j+1]) 
                { 
                    int temp = temporaryArrayCoe[j]; 
                    temporaryArrayCoe[j] = temporaryArrayCoe[j+1]; 
                    temporaryArrayCoe[j+1] = temp; 
                    
                    int temp1 = temporaryArrayPow[j]; 
                    temporaryArrayPow[j] = temporaryArrayPow[j+1]; 
                    temporaryArrayPow[j+1] = temp1;                                         
                } 
            }
        }
        int count = 0;
        int temp = 0;
        for(int i=0;i<temporaryArrayPow.length-1;i++){
            temp=i;
            if(temporaryArrayPow[i] == temporaryArrayPow[i+1]){
                ansCoe[count] += temporaryArrayCoe[i];
            }
            else{
                ansCoe[count] += temporaryArrayCoe[i];
                ansPow[count] = temporaryArrayPow[i];
                count++; 
            }
        }
        ansCoe[count] = temporaryArrayCoe[temp++];
        ansPow[count] = temporaryArrayPow[temp++];
        count++;

        for(int i=0;i<count;i++)
            str += "+" + ansCoe[i] + "x^" + ansPow[i];
        
        return str;
    }

}
