package linklist;

public class Linklist {
    private Node head;

    public Linklist() {
        this.head = null;
    }
    
    public void add(int value) {
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            Node headReference = this.head;
            while (headReference.getNext() != null) {
                headReference = headReference.getNext();
            }
            headReference.setNext(new Node(value));
        }
    }

    public void rotate(int left, int right, int rotate) {
        int currentRotation = 0;
        int count = 1;

        if (left >= right) {
            System.out.println("invalid");
            System.exit(1);
        } else if (left == right) {
            showLinklist();
            System.exit(0);
        } else {
            while (currentRotation < rotate) {
                count=1;
                Node headReference = this.head;
                if (head == null) {
                    System.out.println("empty Linklist");
                    break;
                } else {
                    Node temporaryNode = new Node(); 
                    while (headReference.getNext() != null) {
                        System.out.println("1111111111");
                        System.out.println("head :"+headReference.getData());
                        System.out.println("headnext :"+headReference.getNext());
                        System.out.println("data :"+headReference.getData());
                        if (left <= count && count <= right) {
                            System.out.println("left\tright\tcount");
                            System.out.println(left+"\t"+right+"\t"+count);
                            if(count == right){
                                temporaryNode.setNext(headReference.getNext());
                                headReference.setNext(temporaryNode);
                            }
                            if(count == left){
                                headReference.setData(headReference.getNext().getData());
                                headReference.setNext(headReference.getNext().getNext());
                            }
                            showLinklist();
                        }
                        if(count != left){
                            headReference = headReference.getNext();
                        }
                        if((count+1) == left){
                            temporaryNode.setData(headReference.getData());
                            temporaryNode.setNext(null);
                            System.out.println(temporaryNode);
                            System.out.println("jjjjjjjjjjjjj");
                        }
                        count++;
                    } 
                    if(count == right){
                        System.out.println("ooooookkkkkkkkkkk");
                        
                        System.out.println(temporaryNode);
                        headReference.setNext(temporaryNode);
                    }
//                    rotation(current1, rotate);
//                }
                
                currentRotation++;
            }
        }
        }
        showLinklist();
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
