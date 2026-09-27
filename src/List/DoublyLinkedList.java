package List;
import java.util.Objects;

public class DoublyLinkedList<T> implements MyList<T>{
    private DoubleNode<T> head;
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
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
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
        if(count==0){
            throw new IllegalArgumentException("No se encontró ningún elemento con ese valor");
        }
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
        newNode.next = target.next;
        if(target.next != null){
            target.next.prev = newNode;
        }
        target.next = newNode;
        newNode.prev = target;
        size++;
    }
    
}