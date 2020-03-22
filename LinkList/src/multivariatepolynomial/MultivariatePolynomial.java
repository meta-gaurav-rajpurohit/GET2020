package multivariatepolynomial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MultivariatePolynomial {
    private Node head;
    private Linklist linklist = new Linklist();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    MultivariatePolynomial() {
        this.head = null;
    }

    public void add(String variable, int node) throws NumberFormatException, IOException {
        if (this.head == null) {
            this.head = new Node(addPolynomial(node));
        } else {
            Node headReference = this.head;
            while (headReference.getNext() != null) {
                headReference = headReference.getNext();
            }
            headReference.setNext(new Node(addPolynomial(node)));
        }
    }
    
    public PolynomialNode addPolynomial(int node) throws NumberFormatException, IOException{
        int count = 0, coffe, pow;
        while (count < node) {
            System.out.println("Enter node " + (count + 1) + " : ");
            System.out.println("Enter Cofficent : ");
            coffe = Integer.parseInt(br.readLine());
            System.out.println("Enter Power : ");
            pow = Integer.parseInt(br.readLine());
            linklist.add(coffe, pow);
            count++;
        }
        
        return linklist.getHead();
    }
    
    public int showLinklist(String variable) {
        int maxDegree = 0;
        if (this.head == null) {
            System.out.println("Empty Linklist");
        } else {
            PolynomialNode headReference = linklist.getHead();
            System.out.println(headReference);
            do {
                if(maxDegree < headReference.getPow()){
                    maxDegree = headReference.getPow();
                }
                if(headReference.getNext() == null){
                    System.out.print(headReference.getCoeff()+variable+"^"+headReference.getPow());
                    break;
                }
                System.out.print(headReference.getCoeff()+variable+"^"+headReference.getPow()+"+");
                headReference = headReference.getNext();
            } while (headReference != null);
        }
        return maxDegree;
    }
}
