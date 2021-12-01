import java.sql.Array;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleWzimBoundedQueue<E> implements WzimBoundedQueue<E> {

    private E[] arr;
    private int curr;

    public SimpleWzimBoundedQueue(final int maxCapacity) {
        curr = 0;
        arr = (E[]) new Object[maxCapacity];
    }


    @Override
    public boolean add(E e) {
        if(curr<arr.length)
        {
            arr[curr++] = e;
            return true;
        }
        else{
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean offer(E e) {
        if(curr<arr.length)
        {
            arr[curr++] = e;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public E remove() {
        if(arr[0] != null){
            curr--;
            return poll();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public E poll() {
        if(arr[0] != null){
            E head = arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            return head;
        }
        return null;
    }

    @Override
    public E element() {
        if(arr[0] != null){
            E head = arr[0];
            return head;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public E peek() {
        if(arr[0] != null){
            E head = arr[0];
            return head;
        }
        return null;
    }

    @Override
    public int size() {
        return curr+1;
    }

    @Override
    public int capacity() {
        return arr.length;
    }
}