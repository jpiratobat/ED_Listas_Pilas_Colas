package Stack;
import java.util.Objects;

// Pila por un arreglo de capacidad creciente
public class DynamicArrayStack<T> implements MyStack<T>{
    private T[] array;
    private int size;

    // Crea una pila vacía con capacidad inicial de un elemento
    public DynamicArrayStack(){
        array = (T[]) new Object[1];
        size = 0;

    }

    @Override
    // Inserta un elemento en la cima y amplía el arreglo si es necesario
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
    // Extrae y devuelve el elemento situado en la cima
    public T pop(){
        if(size == 0){
            throw new NullPointerException("No hay más elementos en este arreglo");
        }
        T value = array[size-1]; 
        size--;
        return value;
    }
    
    @Override
    // Consulta el elemento de la cima sin extraerlo
    public T peek() {
        if(size == 0){
            throw new NullPointerException("No hay más elementos en este arreglo");
        }
        return array[size-1];
    }

    @Override
    // Comprueba si la pila está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    // Devuelve el número de elementos almacenados
    public int getSize() {
        return size;
    }

    @Override
    // Elimina todas las apariciones del dato indicado
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
