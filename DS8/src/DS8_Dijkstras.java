import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_Dijkstras {
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end) {
        ArrayList<DS8_Weighted_Node> list = new ArrayList<DS8_Weighted_Node>();
        list.add(new DS8_Weighted_Node(start , 0));

        for (int a = 0; a< vertices.length(); a++){
            if (vertices.charAt(a)!=start)
                list.add(new DS8_Weighted_Node(vertices.charAt(a), Integer.MAX_VALUE));
        }
        ArrayList<DS8_Weighted_Node> sorted = new ArrayList<DS8_Weighted_Node>();
        for (int i = 0; i < list.size(); i++) {
            sorted.add(list.get(i));
        }
        Collections.sort(sorted);
        while (!sorted.isEmpty()){
            DS8_Weighted_Node temp = sorted.remove(0);
            if (temp.getLocation()==end) return temp.getDistance();
            if (temp.getDistance()==Integer.MAX_VALUE) break;
            for (int i = 0; i < edges.length; i++) {
                String t = edges[i].substring(0,1);
                if (t.contains(temp.getLocation()))
            }
        }
    }
}
