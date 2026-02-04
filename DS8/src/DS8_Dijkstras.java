import java.util.ArrayList;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;

public class DS8_Dijkstras {
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end) {
        ArrayList<DS8_Weighted_Node> list = new ArrayList<DS8_Weighted_Node>();
        list.add(new DS8_Weighted_Node(start, 0));

        for (int a = 0; a < vertices.length(); a++) {
            if (vertices.charAt(a) != start)
                list.add(new DS8_Weighted_Node(vertices.charAt(a), Integer.MAX_VALUE));
        }

        ArrayList<DS8_Weighted_Node> sorted = new ArrayList<DS8_Weighted_Node>();
        for (int i = 0; i < list.size(); i++) {
            sorted.add(list.get(i));
        }
        Collections.sort(sorted);
        while (!sorted.isEmpty()) {
            DS8_Weighted_Node temp = sorted.remove(0);
            if (temp.getLocation() == end && temp.getDistance() != Integer.MAX_VALUE) return temp.getDistance();
            if (temp.getDistance() == Integer.MAX_VALUE) break;
            for (int i = 0; i < edges.length; i++) {
                String t = edges[i].substring(0, 2);
                if (t.substring(0, 1).equals("" + (temp.getLocation()))) {

                    int distance = temp.getDistance() + Integer.parseInt(edges[i].substring(2));

                    DS8_Weighted_Node n = null;

                    for (int a = 0; a < sorted.size(); a++) {
                        if (sorted.get(a).getLocation() == (t.substring(1, 2)).toCharArray()[0]) {
                            n = sorted.get(a);
                        }
                    }

                    if (n != null && distance < n.getDistance()) {
                        n.setDistance(distance);
                    }
                }
            }
            Collections.sort(sorted);
        }
        return -1;
    }


    public static int dijkstras_Topographical(char[][] grid, ArrayList<DS8_TerrainCost> travelCosts) {
        ArrayList<DS8_Terrian_Node> nodes = new ArrayList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 'S') {
                    nodes.add(new DS8_Terrian_Node(new Point(x, y), 0));
                }
            }
        }
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != 'S') {
                    nodes.add(new DS8_Terrian_Node(new Point(x, y), Integer.MAX_VALUE));
                }
            }
        }
        ArrayList<DS8_Terrian_Node> sorted = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            sorted.add(nodes.get(i));
        }
        Collections.sort(sorted);

        while (!sorted.isEmpty()) {
            DS8_Terrian_Node temp = sorted.remove(0);

            if (grid[temp.getLocation().y][temp.getLocation().x] == 'E') return temp.getDistance();
            if (temp.getDistance() == Integer.MAX_VALUE) break;
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] i : dir) {
                int y = temp.getLocation().y + i[1];
                int x = temp.getLocation().x + i[0];
                if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length) {
                    int cost = -2;

                    for (int j = 0; j < travelCosts.size(); j++) {
                        if (grid[y][x] == travelCosts.get(j).getType()) {
                            cost = travelCosts.get(j).getCost();
                        }
                    }
                    DS8_Terrian_Node n = null;

                    for (int j = 0; j < sorted.size(); j++) {
                        if (sorted.get(j).getLocation().y == y && sorted.get(j).getLocation().x == x) {
                            n = sorted.get(j);
                        }
                    }
                    int distance = temp.getDistance() + cost;
                    if (cost > -1 && n != null && distance < n.getDistance()) {
                        n.setDistance(distance);
                    }
                }
            }
            Collections.sort(sorted);
        }
        return -1;
    }
}