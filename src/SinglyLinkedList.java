public class SinglyLinkedList<T>{
    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushFront(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

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

    public T popFront(){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existe más elementos ");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

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

    public void Erase(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        Node<T> temp = head;
        if(temp.data == data){
            head = head.next;
        }
        else{
            while(temp.next != null && temp.next.data != data){
                temp = temp.next;
            }
            if(temp.next == null){
                throw new IllegalArgumentException("No se encontró ningún elemento con ese valor");
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public Node<T> Find(T data){
        if(head==null){
            throw new NullPointerException("Opción Invalida, no existen elementos ");
        }
        Node<T> temp = head;
        while(temp.data !=data){
            if(temp.next== null){
                throw new IllegalArgumentException("No se encontró ningún elemento con ese valor");
            }
            else{
                temp = temp.next;
            }   
        }
        return temp;
    }

    public void AddBefore(Node<T> target, T data){
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

    public void AddAfter(Node<T> target, T data){
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
