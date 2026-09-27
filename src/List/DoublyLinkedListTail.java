package List;
import java.util.Objects;

public class DoublyLinkedListTail<T> implements MyList<T> {
    private DoubleNode<T> head;
    private DoubleNode <T> tail;
    private int size = 0;

    @Override 
    public int getSize() {
        return size;
    }

    @Override 
    public boolean isEmpty() {
        return head == null;
    }

    @Override 
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
    public void erase(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        DoubleNode<T> temp = head;
        if(Objects.equals(temp.data, data)){
            popFront();
            return; 
        }
        else{
            while(temp.next != null && !Objects.equals(temp.next.data, data)){
                temp = temp.next;
            }
            if(temp.next == null){
                throw new IllegalArgumentException("No se encontró ningún elemento con ese valor");
            }
            if(temp.next.next!=null){
                temp.next.next.prev = temp;
            } else{
                popBack();
                return;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public DoubleNode<T> find(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        DoubleNode<T> temp = head;
        while(!Objects.equals(temp.data, data)){
            if(temp.next== null){
                throw new IllegalArgumentException("No se encontró ningún elemento con ese valor");
            }
            else{
                temp = temp.next;
            }   
        }
        return temp;
    }

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