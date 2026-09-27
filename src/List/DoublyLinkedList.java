package List;
import java.util.Objects;

// Lista doblemente enlazada que mantiene únicamente la cabeza
public class DoublyLinkedList<T> implements MyList<T>{
    private DoubleNode<T> head;
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
    // Inserta un nodo antes de la cabeza y actualiza su enlace anterior
    public void pushFront(T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if(head != null){
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    // Recorre la lista e inserta un nodo al final
    public void pushBack(T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if( head == null ){
            head = newNode;
        }
        else{
            DoubleNode<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            newNode.prev = temp;
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
    // Extrae la cabeza y elimina el enlace hacia atrás del nuevo inicio
    public T popFront(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = head.data;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        size--;
        return data;
    }
    
    @Override
    // Recorre la lista y devuelve el dato del último nodo sin eliminarlo
    public T topBack() {
        DoubleNode<T> temp = head;
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
    // Extrae la cola y desconecta sus enlaces anterior y siguiente
    public T popBack(){
        DoubleNode<T> temp = head;
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
                temp.next.prev = null;
                temp.next = null;

        }
        size--;
        return data;
    }

    @Override
    // Elimina todas las apariciones y arregla ambos sentidos de los enlaces
    public void erase(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        int count = 0;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = head;

        for(int i = 0; i < size; i++){
            if(Objects.equals(current.data, data)){
                if(previous == null){
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
        
                if(current.next != null){
                    current.next.prev = previous;
                }
                count++;
            } else{
                previous = current;
            }
            current = current.next;
        }
        size -= count;
    }
    
    // Busca y devuelve el primer nodo cuyo dato coincide
    public DoubleNode<T> find(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        DoubleNode<T> temp = head;
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

    // Inserta un nodo antes del objetivo y repara sus enlaces dobles
    public void addBefore(DoubleNode<T> target, T data){
        if(target == null){
            throw new NullPointerException("El nodo objetivo no puede ser null");
        }
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if(head == target){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        DoubleNode<T> temp = head;
        while(temp != null && temp.next != target){
            temp = temp.next;
        }
        if(temp == null){
            throw new IllegalArgumentException("El nodo objetivo no pertenece a la lista");
        }
        newNode.next = target;
        target.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    // Inserta un nodo después del objetivo y repara sus enlaces dobles
    public void addAfter(DoubleNode<T> target, T data){
        if(target == null){
            throw new NullPointerException("El nodo objetivo no puede ser null");
        }
        DoubleNode<T> temp = head;
        while(temp != null && temp != target){
            temp = temp.next;
        }
        if(temp == null){
            throw new IllegalArgumentException("El nodo objetivo no pertenece a la lista");
        }
        DoubleNode<T> newNode = new DoubleNode<>(data);
        newNode.next = target.next;
        if(target.next != null){
            target.next.prev = newNode;
        }
        target.next = newNode;
        newNode.prev = target;
        size++;
    }
    
}