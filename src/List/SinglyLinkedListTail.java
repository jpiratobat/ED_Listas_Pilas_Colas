package List;
import java.util.Objects;

// Lista enlazada simple con referencias a cabeza y cola
public class SinglyLinkedListTail<T> implements MyList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    // Devuelve el número de elementos de la lista
    public int getSize() {
        return size;
    }

    @Override
    // Comprueba si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    // Inserta un nodo al principio y ajusta la cola si procede
    public void pushFront(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    // Inserta un nodo directamente usando la referencia a la cola
    public void pushBack(T data){
        Node<T> newNode = new Node<>(data);
        if( head == null ){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
            size++;
    }

    @Override
    // Devuelve el dato del primer nodo sin eliminarlo
    public T topFront() {
         if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        return head.data;
    }

    @Override
    // Extrae la cabeza y actualiza la cola cuando queda vacía
    public T popFront(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    // Devuelve el dato del último nodo usando la referencia tail
    public T topBack() {
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        return tail.data;
    }

    @Override
    // Extrae la cola recorriendo hasta el penúltimo nodo
    public T popBack(){
        Node<T> temp = head;
        T data;
        if(temp==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        else if(temp.next==null){
            data = head.data;
            head=null;
            tail= null;
        }
        else{ 
            while(temp.next.next!=null){
                temp = temp.next;
            }
                data = temp.next.data;
                temp.next = null;
                tail = temp;

        }
        size--;
        return data;
    }

    @Override
    // Elimina todas las apariciones del dato y mantiene cabeza y cola
    public void erase(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        int count = 0;
        Node<T> prev = null;
        Node<T> temp = head;

        for(int i = 0; i < size; i++){
            if(Objects.equals(temp.data, data)){
                if(prev == null){
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                    if(temp.next == null){
                        tail = prev;
                    }
                }
                count++;
            } else{
                prev = temp;
            }
            temp = temp.next;
        }
        if (head == null) {
            tail = null;
        }
        size -= count;
    }
    
    // Busca y devuelve el primer nodo cuyo dato coincide
    public Node<T> find(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        Node<T> temp = head;
        while(!Objects.equals(temp.data, data)){
            if(temp.next== null){
                return null;
            }
            else{
                temp = temp.next;
            }   
        }
        return temp;
    }

    // Inserta un nodo inmediatamente antes del nodo objetivo
    public void addBefore(Node<T> target, T data){
        if(target == null){
            throw new NullPointerException("El nodo objetivo no puede ser null");
        }
        Node<T> newNode = new Node<>(data);
        if(head == target){
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node<T> temp = head;
        while(temp != null && temp.next != target){
            temp = temp.next;
        }
        if(temp == null){
            throw new IllegalArgumentException("El nodo objetivo no pertenece a la lista");
        }
        newNode.next = target;
        temp.next = newNode;
        size++;
    }

    // Inserta un nodo inmediatamente después del objetivo y ajusta la cola
    public void addAfter(Node<T> target, T data){
        if(target == null){
            throw new NullPointerException("El nodo objetivo no puede ser null");
        }
        Node<T> temp = head;
        while(temp != null && temp != target){
            temp = temp.next;
        }
        if(temp == null){
            throw new IllegalArgumentException("El nodo objetivo no pertenece a la lista");
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = target.next;
        if (target == tail) {
            tail = newNode;
        }
        target.next = newNode;
        size++;
    }

} 
