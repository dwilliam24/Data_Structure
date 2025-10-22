public class DS4_LinkedList<E> implements  DS4_LinkedList_Interface<E>{
    private DS4_LinkedList_Node<E> first;
    private DS4_LinkedList_Node<E> last;

    public DS4_LinkedList(){
        first = null;
        last = null;
    }
    public DS4_LinkedList(E data){
        first = new DS4_LinkedList_Node<>(data);
        last = first;
    }
    @Override
    public DS4_LinkedList_Node getFirstNode() {
        return first;
    }

    @Override
    public DS4_LinkedList_Node getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        return first.getData();
    }

    @Override
    public E getLast() {
        return last.getData();
    }

    @Override
    public E removeFirst() {
        E temp = first.getData();
        first.setData(null);
        return temp;
    }

    @Override
    public E removeLast() {
        E temp = last.getData();
        last.setData(null);
        return temp;
    }

    @Override
    public void addFirst(E data) {
        DS4_LinkedList_Node<E> a = new DS4_LinkedList_Node<E>(data);
        a.setNext(first);
        first=a;
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> a = new DS4_LinkedList_Node<E>(data);
        last.setNext(a);
        last=a;
        last.setNext(null);
    }

    @Override
    public void clear() {
        first=null;
        last=null;
    }

    @Override
    public int size() {
        int counter=0;
        DS4_LinkedList_Node<E> a = first;

        while (!a.getNext().equals(null)){
            counter++;
            a=a.getNext();
        }
        return counter;
    }

    @Override
    public E get(int x) {
        if (x>size()){return null;}
        DS4_LinkedList_Node<E> a = first;
        for (int i = 0; i < x; i++) {
            a=a.getNext();
        }
        return a.getData();
    }

    @Override
    public void add(int x, E data) {
        if (!(x>size())) {
            DS4_LinkedList_Node<E> a = first;
            for (int i = 0; i < x - 1; i++) {
                a = a.getNext();
            }
            DS4_LinkedList_Node<E> temp = a.getNext();
            a.setNext(new DS4_LinkedList_Node<>(data));
            a.getNext().getNext().setNext(temp);
        }
    }

    @Override
    public E remove(int x) {
        if (x>size()){return null;}
        DS4_LinkedList_Node<E> a = first;
        for (int i = 0; i < x-1; i++) {
            a=a.getNext();
        }
        E temp = a.getNext().getData();
        a.setNext(a.getNext().getNext());
        return temp;
    }

    @Override
    public E set(int x, E data) {
        if (x>size()){return null;}
        DS4_LinkedList_Node<E> a = first;
        for (int i = 0; i < x; i++) {
            a=a.getNext();
        }
        E temp = a.getData();
        a.setData(data);
        return temp;
    }

    @Override
    public boolean isEmpty() {
        if (first.equals(null)) return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
