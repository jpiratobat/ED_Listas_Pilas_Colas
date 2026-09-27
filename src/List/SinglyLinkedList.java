package List;
import java.util.Objects;

// Lista enlazada simple que tiene únicamente la cabeza
public class SinglyLinkedList<T> implements MyList<T>{
    private Node<T> head;
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
    // Inserta un nodo antes de la cabeza actual
    public void pushFront(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    // Recorre la lista e inserta un nodo al final
    public void pushBack(T data){
        Node<T> newNode = new Node<>(data);
        if( head == null ){
            head = newNode;
        }
        else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
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
    // Extrae la cabeza y avanza el inicio de la lista
    public T popFront(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    // Recorre la lista y devuelve el dato del último nodo sin eliminarlo
    public T topBack() {
        Node<T> temp = head;
        T data;
        if(temp==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        else if(temp.next==null){
            data = head.data;
        }
        else{ 
            while(temp.next.next!=null){
                temp = temp.next;
            }
                data = temp.next.data;
        }
        return data;
    }

    @Override
    // Recorre la lista, extrae la cola y desconecta el último nodo
    public T popBack(){
        Node<T> temp = head;
        T data;
        if(temp==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        else if(temp.next==null){
            data = head.data;
            head=null;
        }
        else{ 
            while(temp.next.next!=null){
                temp = temp.next;
            }
                data = temp.next.data;
                temp.next = null;

        }
        size--;
        return data;
    }

    @Override
    // Elimina todas las apariciones del dato indicado
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
                }
                count++;
            } else{
                prev = temp;
            }
            temp = temp.next;
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

    // Inserta un nodo inmediatamente después del nodo objetivo
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
        target.next = newNode;
        size++;
    }

} 
