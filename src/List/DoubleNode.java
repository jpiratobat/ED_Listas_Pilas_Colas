package List;
// Nodo genérico con enlaces al nodo siguiente y al anterior
public class DoubleNode<T> {
    T data;
    DoubleNode<T> next;
    DoubleNode<T> prev;
    // Crea un nodo que contiene el dato indicado y no tiene vecinos
    public DoubleNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }   
}
