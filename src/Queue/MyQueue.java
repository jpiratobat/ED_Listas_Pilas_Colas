package Queue;

public interface MyQueue<T>{
    // Inserta un elemento al final de la cola
    void enqueue(T data);
    // Extrae y devuelve el elemento situado al frente
    T dequeue();
    // Devuelve el elemento del frente sin extraerlo
    T front();
    // Indica si la cola no contiene elementos
    boolean isEmpty();
    // Devuelve la cantidad de elementos almacenados
    int getSize();
    // Elimina todas las apariciones del dato indicado
    void delete(T data);
}
