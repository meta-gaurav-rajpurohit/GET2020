package Question2;

public class Element {

    private int data;
    private int priority;
    
    public Element(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Element [data=" + data + ", priority=" + priority + "]";
    }
    
    
}
