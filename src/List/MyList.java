package List;

public interface MyList<T> {
    // Inserta un elemento al principio de la lista
    void pushFront(T data);
    // Inserta un elemento al final de la lista
    void pushBack(T data);
    // Devuelve el primer elemento sin eliminarlo
    T topFront();
    // Extrae y devuelve el primer elemento
    T popFront();
    // Devuelve el último elemento sin eliminarlo
    T topBack();
    // Extrae y devuelve el último elemento
    T popBack();
    // Indica si la lista está vacía
    boolean isEmpty();
    // Devuelve el número de elementos almacenados
    int getSize();
    // Elimina todas las apariciones del dato indicado
    void erase(T data);
}
