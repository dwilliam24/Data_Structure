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
    public DS4_LinkedList_Node<E> getFirstNode() {
        return first;
    }

    @Override
    public DS4_LinkedList_Node<E> getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        if (first==null){return null;}
        return first.getData();
    }

    @Override
    public E getLast() {
        if (last==null) return null;
        return last.getData();
    }

    @Override
    public E removeFirst() {
        if (first==null) return null;
        E temp = first.getData();
        first.setData(null);
        first=first.getNext();
        return temp;
    }

    @Override
    public E removeLast() {
        if (last==null) return null;
        if (size()==1){
            E temp = last.getData();
            first=null;
            last=null;
            return temp;
        }
        DS4_LinkedList_Node<E> a = first;
        while (a.getNext()!=null){
            if (a.getNext().getNext() != null){
                a=a.getNext();
            }
            else break;
        }
        E temp = last.getData();
        a.setNext(null);
        last=a;
        return temp;
    }

    @Override
    public void addFirst(E data) {

        DS4_LinkedList_Node<E> a = new DS4_LinkedList_Node<E>(data);
        if (last==null){last=a;}
        a.setNext(first);
        first=a;
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> a = new DS4_LinkedList_Node<>(data);
        if (first==null||last==null){
            first=a;
            last=a;
        }
        else {
        last.setNext(a);
        last=a;
        }
    }

    @Override
    public void clear() {
        first=null;
        last=null;
    }

    @Override
    public int size() {
        if (first==null) return 0;
        int counter=1;
        DS4_LinkedList_Node<E> a = first;
        while (a.getNext() != null){
            a=a.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public E get(int x) {
        if (x>size()){return null;}
        if (x==0){return first.getData();}
        DS4_LinkedList_Node<E> a = first;
        for (int i = 0; i < x; i++) {
            a=a.getNext();
        }
        return a.getData();
    }

    @Override
    public void add(int x, E data) {
        if (x == 0) {
            addFirst(data);
        }
        else if (x==size()-1||(x==1&&size()==1)){
            addLast(data);
        }
        else if (!(x>size())) {
            DS4_LinkedList_Node<E> a = first;
            for (int i = 1; i < x; i++) {
                    if (a.getNext().getNext() != null) {
                        a = a.getNext();
                    }
            }
            DS4_LinkedList_Node<E> temp = a.getNext();
            a.setNext(new DS4_LinkedList_Node<>(data));
            a = a.getNext();
            a.setNext(temp);
        }
    }

    @Override
    public E remove(int x) {
        if (x>size()){return null;}
        if (x==size()-1){
            return removeLast();
        }
        if (x==0){
            return removeFirst();
        }

        DS4_LinkedList_Node<E> a = first;
        for (int i = 1; i < x; i++) {
            if (a.getNext().getNext()!=null)
            {
                a=a.getNext();
            }
        }
        E temp = a.getNext().getData();
        if (a.getNext().getNext()!=null){
        a.setNext(a.getNext().getNext());
        }
        else {
            a.setNext(null);
            last=a;
        }
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
        if (first==null) return true;
        else return false;
    }

    @Override
    public String toString() {
        if (first==null){return "[]";}
        String array = "[";
        DS4_LinkedList_Node<E> a = first;
        while (a.getNext()!=null){
            array+=(a.getData()+", ");
            a=a.getNext();
        }
        array+=(a.getData()+"]");
        return array;
    }
}
