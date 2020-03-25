package queue;

public interface QueueInterface {

    int size();
    boolean isFull();
    boolean isEmpty();
    void add(int value);
    void delete();
    void show();
}
