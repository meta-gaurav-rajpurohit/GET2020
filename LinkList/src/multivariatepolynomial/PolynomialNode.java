package multivariatepolynomial;

public class PolynomialNode {
    private int coeff; 
    private int pow; 
    private PolynomialNode next;
    
    public PolynomialNode(int coeff, int pow) {
        this.coeff = coeff;
        this.pow = pow;
        this.next = null;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public PolynomialNode getNext() {
        return next;
    }

    public void setNext(PolynomialNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "PolynomialNode [coeff=" + coeff + ", pow=" + pow + ", next="
                + next + "]";
    }
}
