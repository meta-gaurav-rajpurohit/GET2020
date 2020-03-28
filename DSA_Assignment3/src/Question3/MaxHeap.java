package Question3;

public class MaxHeap {

    private Bowler[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Bowler[this.maxsize + 1];
        Heap[0] = new Bowler(null, Integer.MAX_VALUE);
    }
    
    private int parent(int positio) {
        return positio / 2;
    }

    private int leftChild(int positio) {
        return (2 * positio);
    }

    private int rightChild(int positio) {
        return (2 * positio) + 1;
    }

    private void swap(int firstpositio, int secondpositio) {
        Bowler temporary;
        temporary = Heap[firstpositio];
        Heap[firstpositio] = Heap[secondpositio];
        Heap[secondpositio] = temporary;
    }

    private boolean isLeaf(int positio) 
    { 
        if (positio > (size / 2) && positio <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void maxHeapify(int positio) {
        if (isLeaf(positio)) 
            return; 
        if (Heap[positio].balls < Heap[leftChild(positio)].balls
                || Heap[positio].balls < Heap[rightChild(positio)].balls) {

            if (Heap[leftChild(positio)].balls > Heap[rightChild(positio)].balls) {
                swap(positio, leftChild(positio));
                maxHeapify(leftChild(positio));
            } else {
                swap(positio, rightChild(positio));
                maxHeapify(rightChild(positio));
            }
        }
    }

    public void insert(String name, int balls) 
    { 
        Heap[++size] = new Bowler(name, balls); 
  
        int current = size; 
        while (Heap[current].balls > Heap[parent(current)].balls) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 

    public void show() {
        System.out.println("Virat play "+Heap[1].name+" balls");
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT("+Heap[i].name+") : " + Heap[i].balls + " LEFT CHILD("+Heap[2 * i].name+") : "
                    + Heap[2 * i].balls + " RIGHT CHILD("+Heap[2 * i + 1].name+") :" + Heap[2 * i + 1].balls);
            System.out.println();
        }
    }

    public int extractMax() {
        int popped = Heap[1].balls - 1;
        Heap[1].balls = popped;
        if (Heap[1].balls == 0 && Heap[2].balls == 0 && Heap[3].balls == 0) {
            show();
            return popped;
        } else if (Heap[1].balls >= 0 && Heap[2].balls >= 0 && Heap[3].balls >= 0) {
            maxHeapify(1);
            show();
            extractMax();
        }
        return popped;
    }
}
