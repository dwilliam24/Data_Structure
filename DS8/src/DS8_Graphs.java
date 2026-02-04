import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;

public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices) {
        for (int l = 0; l < vertices.length(); l++) {
            char start = vertices.charAt(l);
            for (int d = 0; d < vertices.length(); d++) {
                if (l==d) continue;
                char end = vertices.charAt(d);


                ArrayList<DS8_AStar_Node<Point>> open = new ArrayList<>();
                ArrayList<DS8_AStar_Node<Point>> closed = new ArrayList<>();

                open.add(new DS8_AStar_Node<>(start, null, 0, Math.abs(start.x - end.x) + Math.abs(start.y - end.y)));

                while (!open.isEmpty()) {

                    Collections.sort(open);
                    DS8_AStar_Node<Point> temp = open.remove(0);

                    if (temp.getLocation().equals(end)) {
                        ArrayList<Point> path = new ArrayList<>();
                        DS8_AStar_Node<Point> h = temp;

                        while (h != null) {
                            path.add(0, h.getLocation());
                            h = h.getParent();
                        }

                        return new DS8_Path_Solution<Point>(path, path.size() - 1);
                    }

                    closed.add(temp);

                    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                    for (int[] d : dirs) {
                        int x = temp.getLocation().x + d[0];
                        int y = temp.getLocation().y + d[1];

                        if (y < 0 || y >= rows || x < 0 || x >= cols) continue;
                        if (maze[y][x] == 'W') continue;

                        Point next = new Point(x, y);

                        boolean visited = false;
                        for (DS8_AStar_Node<Point> p : closed) {
                            if (p.getLocation().equals(next)) {
                                visited = true;
                                break;
                            }
                        }
                        if (visited) continue;

                        int g = temp.getG() + 1;
                        int h = Math.abs(x - end.x) + Math.abs(y - end.y);

                        open.add(new DS8_AStar_Node<Point>(next, temp, g, h));
                    }
                }
                return null;
            }
        }
    }
}
