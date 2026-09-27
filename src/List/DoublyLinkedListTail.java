package List;
import java.util.Objects;

// Lista doblemente enlazada con referencias a cabeza y cola
public class DoublyLinkedListTail<T> implements MyList<T> {
    private DoubleNode<T> head;
    private DoubleNode <T> tail;
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
    // Inserta un nodo al principio y actualiza la cabeza y la cola
    public void pushFront(T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if(head != null){
            head.prev = newNode;
        }
        else{
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        
        size++;
    }

    @Override 
    // Inserta un nodo directamente después de la cola actual
    public void pushBack(T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if( head == null ){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
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
    // Extrae la cabeza y mantiene ambas referencias consistentes
    public T popFront(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = head.data;
        head = head.next;
        if(head != null){
            head.prev = null;
        } else {
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
    // Extrae la cola usando su referencia directa
    public T popBack(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = tail.data;
        if(tail == head){
            tail = null;
            head = null;
        } else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override 
    // Elimina todas las apariciones y actualiza cabeza, cola y enlaces
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
                    if(current.next == null){
                        tail = previous;
                    }
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
        if (head == null) {
            tail = null;
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

    // Inserta un nodo antes del objetivo y ajusta sus vecinos
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

    // Inserta un nodo después del objetivo y ajusta la cola si procede
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
        if(target == tail){
            tail = newNode;
        } else{
            newNode.next = target.next;
            target.next.prev = newNode;
        }
        
        target.next = newNode;
        newNode.prev = target;
        size++;
    }
    
}