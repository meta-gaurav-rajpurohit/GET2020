package multivariatepolynomial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        String variable;
        MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter variable : ");
        variable = br.readLine();
        System.out.println("Enter Number Of Node : ");
        multivariatePolynomial.add(variable, Integer.parseInt(br.readLine()));
        System.out.print("\nDegree Of Polymonial : "+multivariatePolynomial.showLinklist(variable));
        
    }

}
