package Stack;
import java.util.Objects;

public class DynamicArrayStack<T> implements MyStack<T>{
    private T[] array;
    private int size;

    public DynamicArrayStack(){
        array = (T[]) new Object[1];
        size = 0;

    }

    @Override
    public void push(T data) {
        if(size == array.length){
            T[] temporal = (T[]) new Object[size*2];
            for(int i=0; i<size; i++){
                temporal[i] = array [i];
            }
            array = temporal;
        }
        array[size] = data;
        size++;
    }

    @Override
    public T pop(){
        if(size == 0){
            throw new NullPointerException("No hay más elementos en este arreglo");
        }
        T value = array[size-1]; 
        size--;
        return value;
    }
    
    @Override
    public T peek() {
        if(size == 0){
            throw new NullPointerException("No hay más elementos en este arreglo");
        }
        return array[size-1];
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
    public void delete(T data) {
        if(size==0){
            throw new IndexOutOfBoundsException("No hay elementos en este arreglo");
        }
        int read = 0;
        int write = 0;
        int count = 0;

        for(int i = 0; i < size ; i++){
            if(!Objects.equals(array[read], data)){
                array[write] = array[read];
                write ++;
            }  else{
                count++;
            }
            read++;
        }
        size -= count;
    }

}
