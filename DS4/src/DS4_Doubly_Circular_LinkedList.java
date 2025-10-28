public class DS4_Doubly_Circular_LinkedList<E> implements DS4_Doubly_Circular_LinkedList_Interface<E>{
    private DS4_Doubly_Circular_LinkedList_Node<E> first;
    private DS4_Doubly_Circular_LinkedList_Node<E> last;
    public DS4_Doubly_Circular_LinkedList(){
        first=null;
        last=null;
    }
    public DS4_Doubly_Circular_LinkedList(E data){
        first= new DS4_Doubly_Circular_LinkedList_Node<>(data);
        last= first;
        first.setPrev(last);
        last.setPrev(first);
        first.setNext(last);
        last.setNext(first);
    }
    
    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode() {
        return first;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode() {
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
        first.setPrev(last);
        last.setNext(first);
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
            DS4_Doubly_Circular_LinkedList_Node<E> a = getLastNode().getPrev();
            E temp = last.getData();
            a.setNext(null);
            last=a;
            DS4_Doubly_Circular_LinkedList_Node<E> b = first;
            while (!b.getNext().equals(last)){
                b=b.getNext();
            }
            last.setPrev(b);
            first.setPrev(last);
            last.setNext(first);
            return temp;
    }

    @Override
    public void addFirst(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> a = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (last==null||first==null){
            first=a;
            last=a;
            first.setNext(last);
            last.setNext(first);
            first.setPrev(last);
            last.setPrev(first);
        }
        else {
        a.setNext(first);
        first.setPrev(a);
        first=a;
        first.setPrev(last);
        last.setNext(first);
        }
    }

    @Override
    public void addLast(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> a = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (first==null||last==null){
            first=a;
            last=a;
            first.setNext(last);
            last.setNext(first);
            first.setPrev(last);
            last.setPrev(first);
        }
        else {
            last.setNext(a);
            a.setPrev(last);
            last=a;
            last.setNext(first);
            first.setPrev(last);
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
        DS4_Doubly_Circular_LinkedList_Node<E> a =first;
        while (!(a.getNext().equals(first))){
            a=a.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public E get(int x) {
        if (x>size()){return null;}
        if (x==0){return first.getData();}
        DS4_Doubly_Circular_LinkedList_Node<E> a = first;
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
        else if (x==size()){
            addLast(data);
        }
        else if (!(x>size())) {
            DS4_Doubly_Circular_LinkedList_Node<E> a = first;
            for (int i = 0; i < x-1; i++) {
                    a = a.getNext();
            }
            DS4_Doubly_Circular_LinkedList_Node<E> newer = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            DS4_Doubly_Circular_LinkedList_Node<E> temp = a.getNext();
            a.setNext(newer);
            a.getNext().setPrev(a);
            a.getNext().setNext(temp);
            a.getNext().getNext().setPrev(newer);
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

        DS4_Doubly_Circular_LinkedList_Node<E> a = first;
        for (int i = 1; i < x; i++) {
            a=a.getNext();
        }
        E temp = a.getNext().getData();
        a.setNext(a.getNext().getNext());
        a.getNext().setPrev(a);
        return temp;
    }

    @Override
    public E set(int x, E data) {
        if (x>size()){return null;}
        DS4_Doubly_Circular_LinkedList_Node<E> a = first;
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
    public String backwardsToString() {
        if (size()==0){return "[]";}
        String string = "[";
        DS4_Doubly_Circular_LinkedList_Node<E> a = first;
        while (!a.getPrev().equals(first)){
            string+=a.getData()+", ";
            a=a.getPrev();
        }

        string+=getLast();
        string+="]";
        return string;
    }

    @Override
    public String toString() {
        if (size()==0){return "[]";}
        String string = "[";
        DS4_Doubly_Circular_LinkedList_Node<E> a = first;
        while (!a.getNext().equals(first)){
            string+=a.getData()+", ";
            a=a.getNext();
        }

        string+=getLast();
        string+="]";
        return string;
    }
}
