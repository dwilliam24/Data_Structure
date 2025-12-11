import java.util.ArrayList;

public class DS6_MaxHeap<E extends Comparable<E>> implements DS6_HeapInterface<E> {
    private ArrayList<E> heap;

    public DS6_MaxHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(Comparable item) {
        E value = (E) item;

        heap.add(value);
        int index = heap.size() - 1;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index).compareTo(heap.get(parent)) > 0) {
                E temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);

                index = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public E remove() {
        if (heap.isEmpty()) return null;

        E root = heap.getFirst();

        E last = heap.removeLast();

        heap.set(0, last);

        int index = 0;
        int size = heap.size();

        while (true) {
            int left = index * 2 + 1;
            int right = left + 1;
            int big = index;

            if (left < size && heap.get(left).compareTo(heap.get(big)) > 0) {
                big = left;
            }

            if (right < size && heap.get(right).compareTo(heap.get(big)) > 0) {
                big = right;
            }
            if (big != index) {
                E a = heap.get(index);
                heap.set(index, heap.get(big));
                heap.set(big, a);

                index = big;
            } else {
                break;
            }
        }


        return root;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
