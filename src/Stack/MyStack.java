package Stack;

public interface MyStack<T> {
    // Inserta un elemento en la cima
    void push(T data);
    // Extrae y devuelve el elemento situado en la cima
    T pop();
    // Devuelve la cima sin extraerla
    T peek();
    // Indica si la pila no contiene elementos
    boolean isEmpty();
    // Devuelve la cantidad de elementos almacenados
    int getSize();
    // Elimina todas las apariciones del dato indicado
    void delete(T data);
}
