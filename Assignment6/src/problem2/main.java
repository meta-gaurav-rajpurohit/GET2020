package problem2;

public class main {
    public static void main(String args[]){
        
        Poly p1 = new Poly(new int[]{1,1,1}, new int[]{2,1,0});
        Poly p2 = new Poly(new int[]{1,2,3}, new int[]{2,1,0});
        System.out.println(Poly.AddPoly(p1, p2));
    }

}
