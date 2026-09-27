package List;
// Nodo genérico de una lista simplemente enlazada
public class Node<T>{
    T data;
    Node<T> next;

    // Crea un nodo con el dato indicado y sin sucesor
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}