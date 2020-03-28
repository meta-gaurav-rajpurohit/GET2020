package Question2;

public interface priority_queue {
    int size();
//    boolean isFull();
    boolean isEmpty();
    void add(int value, int priority);
    void delete();
    void show();
}
