package List;

public interface MyList<T> {
    void pushFront(T data);
    void pushBack(T data);
    T popFront();
    T popBack();
    boolean isEmpty();
    int getSize();
    void erase(T data);
}
