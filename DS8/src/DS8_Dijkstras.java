import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_Dijkstras {
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end) {
        System.out.println("start:");
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
        System.out.println(sorted);
        Collections.sort(sorted);
        System.out.println(sorted+"\n\n\n");
        while (!sorted.isEmpty()){
            DS8_Weighted_Node temp = sorted.remove(0);
            System.out.println("\n");
            System.out.println(temp.getLocation());
            if (temp.getLocation()==end&&temp.getDistance()!=Integer.MAX_VALUE) return temp.getDistance();
            if (temp.getDistance()==Integer.MAX_VALUE) break;
            for (int i = 0; i < edges.length; i++) {
                String t = edges[i].substring(0,2);
                System.out.println(t);
                if (t.substring(0, 1).equals("" + (temp.getLocation()))){
                    int distance = temp.getDistance()+Integer.parseInt(edges[i].substring(2));
                    System.out.println(distance);
                    DS8_Weighted_Node n = null;
                    for (int a = 0; a<sorted.size(); a++){
                        if (sorted.get(a).getLocation()==(t.substring(1,2)).toCharArray()[0]){
                            n=sorted.get(a);
                        }
                    }
                    if (distance<n.getDistance()) {
                        n.setDistance(distance);
                        System.out.println("a");
                    }
                }
            }
            System.out.println(sorted);
            Collections.sort(sorted);
            System.out.println(sorted+"\n\n\n");
        }
        return -1;
    }
}
