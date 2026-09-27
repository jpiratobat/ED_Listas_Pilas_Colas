package Stack;

public interface MyStack<T> {
    void push(T data);
    T pop();
    T peek();
    boolean isEmpty();
    int getSize();
    void delete(T data);
}
