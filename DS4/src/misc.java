import org.w3c.dom.Node;

import java.util.LinkedList;

public class misc {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        Node cur = list.getFirstNode();
        cur.getNext().getNext().setNext(list.getLastNode());

        System.out.println(list.size());
    }
}
