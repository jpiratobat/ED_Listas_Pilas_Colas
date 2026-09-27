package Queue;
import java.util.Objects;

public class DynamicArrayQueue<T> implements MyQueue<T> {
    private T[] array;
    private int size;
    private int rear;
    private int head;

    public DynamicArrayQueue(){
        array = (T[]) new Object[1];
        size = 0;
        this.rear = 0;
        this.head = 0;
    }

    @Override
    public void enqueue(T data) {
        if(array.length == size ){
            T[] temp = (T[]) new Object[size*2];
            
            for(int i = 0; i<size; i++){
                temp[i] = array[head];
                head= (head+1)% array.length;
            }
            array = temp;
            head = 0;
            rear = size;
        }
        
        array[rear] = data;
        rear = (rear + 1) % array.length;
        size ++;
    }

    @Override
    public T dequeue() {
        if(size == 0){
            throw new IndexOutOfBoundsException("No hay más elementos");
        }
        T value = array[head];
        head = ( head + 1 )% array.length;
        size --;
        if(size == 0){
            head = 0;
            rear = 0;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T front() {
        if(size == 0){
            throw new NullPointerException(" No hay más elementos en la cola");
        }
        return array[head];
    }

    @Override
    public void delete(T data) {
        if(size==0){
            throw new IndexOutOfBoundsException("No hay elementos en este arreglo");
        }
        int read = head;
        int write = head;
        int count = 0;

        for(int i = 0; i < size ; i++){
            if(!Objects.equals(array[read], data)){
                array[write] = array[read];
                write = (write + 1) % array.length;
            }  else{
                count++;
            }
            read = (read + 1) % array.length;
        }
        size -= count;
        rear = write;
        if(size==0){
            head = 0;
            rear = 0;
        }
            
    }

}
