import java.util.ArrayList;

public class MyStack<E> implements StackInterface<E>{
    private ArrayList<E> data;

    @Override
    public void push(E o) {
            data.add(o);
    }
    public MyStack() {
        data = new ArrayList<>();
    }
    @Override
    public E peek() {
        if (data.isEmpty()) return null;
        return data.get(size()-1);
    }

    @Override
    public E pop() {
        if (data.isEmpty()) return null;
        return data.remove(size()-1);
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
