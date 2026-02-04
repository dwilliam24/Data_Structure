import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_AStar {
    public static DS8_Path_Solution aStar_Simple(char[][] maze) {

        int rows = maze.length;
        int cols = maze[0].length;

        Point start = null;
        Point end = null;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
                if (maze[y][x] == 'E') end = new Point(x, y);
            }
        }

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


    public static int aStar_JetPack(char[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        Point start = null;
        Point end = null;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
                if (maze[y][x] == 'E') end = new Point(x, y);
            }
        }

        ArrayList<DS8_AStar_Node<Point>> open = new ArrayList<>();
        ArrayList<DS8_AStar_Node<Point>> closed = new ArrayList<>();

        open.add(new DS8_AStar_Node<>(start, null, 0, 0));

        while (!open.isEmpty()) {

            Collections.sort(open);

            DS8_AStar_Node<Point> temp = open.remove(0);

            if (temp.getLocation().equals(end)) {
                return temp.getG();
            }

            closed.add(temp);

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

            for (int[] d : dirs) {
                int x = temp.getLocation().x + d[0];
                int y = temp.getLocation().y + d[1];

                if (y < 0 || y >= rows || x < 0 || x >= cols) continue;

                Point next = new Point(x, y);

                boolean f = false;
                for (int i = 0; i < closed.size(); i++) {
                    if (closed.get(i).getLocation().equals(next)) {
                        f = true;
                        break;
                    }
                }
                if (f) continue;

                int g = 0;

                if (maze[y][x] == 'O') {
                    g = temp.getG() + 1;
                } else {
                    g = temp.getG();
                }

                int h = 0;

                open.add(new DS8_AStar_Node<Point>(next, temp, g, h));
            }
        }
        return -1;
    }
}