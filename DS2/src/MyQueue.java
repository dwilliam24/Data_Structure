import java.util.ArrayList;

public class MyQueue<E> implements QueueInterface<E>{
    private ArrayList<E> data;

    public MyQueue(){
        data = new ArrayList<>();
    }

    @Override
    public void offer(E o) {
        data.add(o);
    }

    @Override
    public E element() {
        return data.getFirst();
    }

    @Override
    public E poll() {
        return data.remove(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
