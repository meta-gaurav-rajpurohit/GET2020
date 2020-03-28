package Question3;

public class Main {

    public static void main(String[] args) {
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(5); 
        maxHeap.insert("bow1",7); 
        maxHeap.insert("bow2",6); 
        maxHeap.insert("bow3",5); 
        maxHeap.insert("bow4",4); 
        maxHeap.insert("bow5",3); 
//        maxHeap.insert(15); 
//        maxHeap.insert(10); 
//        maxHeap.insert(9); 
//        maxHeap.insert(8); 
//        maxHeap.insert(7); 
//        maxHeap.show(); 
        System.out.println("\nThe max val is " + maxHeap.extractMax());
    }
}
