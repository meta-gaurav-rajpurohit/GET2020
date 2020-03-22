package linklistloop;

import linklist.Node;

public class Linklist {
    private Node head;

    Linklist() {
        this.head = null;
    }

    public void add(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node headReference = this.head;
            while (headReference.getNext() != null) {
                headReference = headReference.getNext();
            }
            headReference.setNext(node);
        }
    }
    
    public boolean loopExists(){
        Node next = this.head;
        Node nextToNext = this.head;
        while(next != null && nextToNext != null){
            next = next.getNext();
            nextToNext = nextToNext.getNext().getNext();
            if (next == nextToNext)
                    return true;
        }
        return false;
    }
    
    public void showLinklist() {

        if (this.head == null) {
            System.out.println("Empty Linklist");
        } else {
            Node headReference = this.head;
            System.out.println(headReference);
            do {
                System.out.print(headReference.getData() + " ");
                headReference = headReference.getNext();
            } while (headReference != null);
        }
    }
}
