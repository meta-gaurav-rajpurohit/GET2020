package problem;

public class mm {
    public static void main(String args[]){
    int a[] = new int[]{1, 4, 1, 5, 5, 4, 1};
    
    ArrOperation ao = new ArrOperation();
//    System.out.println(ao.largMirrorSection(a));
    
    int b[] = new int[10];
    b = ao.fixXY(a,4,5);
    for(int i : b){
        System.out.print(i+" ");
    }
//    System.out.println(ao.splitArray(a));
}
}