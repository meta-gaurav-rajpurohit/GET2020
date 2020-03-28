package Question2;

public class PriorityQueue implements priority_queue{

    private int rear, front;
    private Element elements[] = null;
    private int capacity;
    
    PriorityQueue(int capacity){
        this.rear = -1;
        this.front = -1;
        this.capacity = capacity;
        elements = new Element[capacity];
    }
    
    @Override
    public int size() {
        return ((this.capacity - this.front + this.rear + 1) % (this.capacity));
    }

    public boolean isFull() {
        return ((this.rear + 1) % this.capacity == this.front);
    }
    
    public boolean checkPrirority(int priority) {
        for(Element element : elements){
            if(priority < element.getPriority()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return (this.front == -1);
    }

    @Override
    public void add(int value, int priority) {
        int temporary1;
        int i = 0, size;
        boolean flag = false;
        Element temporaryelement1 = null;
        
        if (isFull() && checkPrirority(priority)) {
            System.out.println("Overflow");
        } else {
            if(this.rear == -1 && this.front == -1){
                this.rear = (this.rear + 1) % this.capacity;
                this.front = this.rear;
                this.elements[this.rear] = new Element(value, priority);
            }
            else{
                temporary1 = this.front;
                if(size() != 0){
                    flag = true;
                    this.rear = (this.rear + 1) % this.capacity;
                }
                while (i < this.capacity && temporary1 != (this.rear)) {
                    if(this.elements[temporary1].getPriority() > priority){
                        temporaryelement1 = this.elements[temporary1];
                        this.elements[temporary1] = new Element(value, priority);
                        flag = false;
                        break;
                    }
                    temporary1 = (temporary1 + 1) % this.capacity;
                    i++;
                }
                while(temporary1 != this.rear){
                    temporary1 = (temporary1 + 1) % this.capacity;
                    Element temporaryelement2 =  this.elements[temporary1];//temporary;
                    this.elements[temporary1] = temporaryelement1;
                    temporaryelement1 = temporaryelement2;
                }
                System.out.println("size :"+size());
                if(size() != this.capacity && flag){
                    this.elements[this.rear] = new Element(value, priority);
                }
            }
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (this.front == this.rear) {
                this.front = this.rear = -1;
            } else {
                this.front = (this.front + 1) % this.capacity;
            }
        }
    }

    @Override
    public void show() {
        int temporary1 = this.front;
        int i = 0, size;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (size() == 0) {
                size = 4;
            } else {
                size = size();
                System.out.println(size);
            }
            System.out.println("front : "+this.front+" rear : "+this.rear);
            while (i < size) {
                System.out.println(this.elements[temporary1].getData());
                temporary1 = (temporary1 + 1) % this.capacity;
                i++;
            }
        }
    }
    
}
