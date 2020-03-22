package multivariatepolynomial;

public class Linklist {
    private PolynomialNode head;

    Linklist() {
        this.head = null;
    }
    
    public PolynomialNode getHead(){
        return this.head;
    }
    
    public void add(int coffe, int pow) {
        if (this.head == null) {
            this.head = new PolynomialNode(coffe, pow);
        } else {
            PolynomialNode headReference = this.head;
            while (headReference.getNext() != null) {
                headReference = headReference.getNext();
            }
            headReference.setNext(new PolynomialNode(coffe, pow));
        }
    }

    public void showLinklist() {

        if (this.head == null) {
            System.out.println("Empty Linklist");
        } else {
            PolynomialNode headReference = this.head;
            System.out.println(headReference);
            do {
                System.out.print(headReference.getCoeff() + " ");
                System.out.print(headReference.getPow() + " ");
                headReference = headReference.getNext();
            } while (headReference != null);
        }
    }
}
