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
        return false;
    }

    @Override
    public E remove() {
        if(arr[0] != null){
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
                arr[i] = arr[i-1];
            }
            return head;
        }
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }
}