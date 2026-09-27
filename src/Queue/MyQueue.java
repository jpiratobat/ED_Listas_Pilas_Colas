package Queue;

public interface MyQueue<T>{
    void enqueue(T data);
    T dequeue();
    T front();
    boolean isEmpty();
    int getSize();
    void delete(T data);
}
