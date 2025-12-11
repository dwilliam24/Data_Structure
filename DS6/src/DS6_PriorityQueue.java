public class DS6_PriorityQueue<E extends Comparable<E>> implements DS6_PriorityQueueInterface<E>{
    DS6_MinHeap<E> heap = new DS6_MinHeap<>();
    @Override
    public void offer(Comparable o) {
        heap.insert(o);
    }

    @Override
    public E poll() {
        if (heap.isEmpty()) return null;
        return heap.remove();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public E get(int x) {
        if (heap.isEmpty()) return null;
        return heap.get(x);
    }

    @Override
    public E element() {
        if (heap.isEmpty()) return null;
        E a = heap.remove();
        heap.insert(a);
        return a;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
