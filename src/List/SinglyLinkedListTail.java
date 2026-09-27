package List;
import java.util.Objects;

public class SinglyLinkedListTail<T> implements MyList<T>{
    private Node<T> head;
    private Node<T> tail;
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
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
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
    public void erase(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        Node<T> temp = head;
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
            if (temp.next == tail) {
                popBack();
                return;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public Node<T> find(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        Node<T> temp = head;
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
