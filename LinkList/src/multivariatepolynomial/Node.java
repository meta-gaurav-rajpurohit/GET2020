package multivariatepolynomial;

public class Node {
    private PolynomialNode polynomialNode;
    private Node next;

    public Node(){}
    
    public Node(PolynomialNode polynomialNode) {
        this.polynomialNode = polynomialNode;
        this.next = null;
    }

    public PolynomialNode getData() {
        return polynomialNode;
    }

    public void setData(PolynomialNode polynomialNode) {
        this.polynomialNode = polynomialNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + polynomialNode + ", next=" + next + "]";
    }

}
