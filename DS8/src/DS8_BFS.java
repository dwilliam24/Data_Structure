
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class DS8_BFS {
    public static int breadthFirstSearch_Portals(char[][] maze) {
        int[][] visited = new int[maze.length][maze[0].length];
        for (int y = 0; y < visited.length; y++) {
            for (int x = 0; x < visited[0].length; x++) {
                visited[y][x] = -1;
            }
        }

        DS8_Queue<Point> queue = new DS8_Queue<>();
        Point start = null;

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
            }
        }

        Point[] portals = new Point[8];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                char portal = maze[y][x];
                if (portal >= 'A' && portal <= 'D') portals[portal - 'A'] = new Point(x, y);
                else if (portal >= 'a' && portal <= 'd') portals[portal - 'a' + 4] = new Point(x, y);
            }
        }

        queue.offer(start);
        visited[start.y][start.x] = 0;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            if (maze[temp.y][temp.x] == 'E') return visited[temp.y][temp.x];

            for (int[] d : direction) {
                int nx = temp.x + d[1];
                int ny = temp.y + d[0];
                if (nx >= 0 && nx < maze[0].length && ny >= 0 && ny < maze.length) {
                    if (maze[ny][nx] != 'W' && visited[ny][nx] == -1) {
                        visited[ny][nx] = visited[temp.y][temp.x] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }

            char ch = maze[temp.y][temp.x];
            int index = -1;
            if (ch >= 'A' && ch <= 'D') index = ch - 'A';
            else if (ch >= 'a' && ch <= 'd') index = ch - 'a' + 4;

            if (index != -1) {
                int q;
                if (index <= 3) {
                    q = index + 4;
                } else {
                    q = index - 4;
                }
                Point finish = portals[q];
                if (finish != null && visited[finish.y][finish.x] == -1) {
                    visited[finish.y][finish.x] = visited[temp.y][temp.x] + 1;
                    queue.offer(finish);
                }
            }
        }
        return -1;
    }


    public static String breadthFirstSearch_Unweighted(String[] edges, String vertices, char start, char end) {
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        for (int i = 0; i < vertices.length(); i++) {
            indexes[vertices.charAt(i) - 'A'] = i;
        }

        ArrayList<Character>[] graph = new ArrayList[vertices.length()];
        for (int i = 0; i < vertices.length(); i++) {
            graph[i] = new ArrayList<>();
        }
        for (String edge : edges) {
            char a = edge.charAt(0);
            char b = edge.charAt(1);
            int g = indexes[a - 'A'];
            int h = indexes[b - 'A'];
            graph[g].add(b);
            graph[h].add(a);
        }

        DS8_Queue<Character> queue = new DS8_Queue<>();
        boolean[] visited = new boolean[vertices.length()];
        char[] parent = new char[vertices.length()];
        Arrays.fill(parent, '0');

        queue.offer(start);
        visited[indexes[start - 'A']] = true;

        while (!queue.isEmpty()) {
            char temp = queue.poll();
            int index = indexes[temp - 'A'];

            if (temp == end) {
                String path = "";
                char c = end;
                while (c != start) {
                    path = c + path;
                    c = parent[indexes[c - 'A']];
                }
                path = start + path;
                return path;
            }

            ArrayList<Character> l = graph[index];
            for (char neighbor : l) {
                int h = indexes[neighbor - 'A'];
                if (!visited[h]) {
                    visited[h] = true;
                    queue.offer(neighbor);
                    parent[h] = temp;
                }
            }
        }

        return null;
    }
}
