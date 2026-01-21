import java.awt.Point;
import java.util.Arrays;

public class DS8_BFS {
    public static int breadthFirstSearch_Portals(char[][] maze){
        int[][] visited = new int[maze.length][maze[0].length];
        for (int y=0; y< visited.length; y++){
            for (int x=0; x< visited[0].length; x++){
                visited[y][x]=-1;
            }
        }
        DS8_Queue<Point> queue = new DS8_Queue<>();
        Point start = null;
        Point end = null;
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
                if (maze[y][x] == 'E') end = new Point(x, y);
            }
        }
        queue.offer(start);
        visited[(int) start.getY()][(int) start.getX()] = 0;
        int count=0;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            System.out.println(Arrays.deepToString(visited));
            System.out.println("a");
            if ((int) temp.getX() == (int) end.getX() && (int) temp.getY() == (int) end.getY()) return visited[end.y][end.x];
            count++;
            visited[(int) temp.getY()][(int) temp.getX()] = count;
            if (((int) temp.getY()) - 1 >= 0 && maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'W' && visited[((int) temp.getY()) - 1][(int) temp.getX()]==-1) {
                if (maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'S' && maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'E' && maze[((int) temp.getY()) - 1][(int) temp.getX()] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getY()) - 1 == y && (int) temp.getX() == x) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY()) - 1][(int) temp.getX()])) {
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
                queue.offer(new Point((int) temp.getX(), (int) (temp.getY() - 1)));
                visited[(int) temp.getY() - 1][(int) temp.getX()] = count;
            }

            if (((int) temp.getY()) + 1 < maze.length && maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'W' && visited[((int) temp.getY()) + 1][(int) temp.getX()]==-1) {
                if (maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'S' && maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'E' && maze[((int) temp.getY()) + 1][(int) temp.getX()] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getY()) + 1 == y && (int) temp.getX() == x) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY()) + 1][(int) temp.getX()])) {
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
                queue.offer(new Point((int) temp.getX(), (int) (temp.getY() + 1)));
                visited[(int) temp.getY() + 1][(int) temp.getX()] = count;
            }
            if (((int) temp.getX()) - 1 >= 0 && maze[(int) temp.getY()][(int) temp.getX() - 1] != 'W' && visited[(int) temp.getY()][((int) temp.getX()) - 1]==-1) {
                if (maze[((int) temp.getY())][(int) temp.getX() - 1] != 'S' && maze[((int) temp.getY())][(int) temp.getX() - 1] != 'E' && maze[((int) temp.getY())][(int) temp.getX() - 1] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getX()) - 1 == x && (int) temp.getY() == y) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY())][(int) temp.getX() - 1])) {
                               queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
                queue.offer(new Point(((int) temp.getX()) - 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() - 1] = count;
            }
            if (((int) temp.getX()) + 1 < maze[0].length && maze[((int) temp.getY())][((int) temp.getX()) + 1] != 'W' && visited[((int) temp.getY())][((int) temp.getX()) + 1]==-1) {
                if (maze[((int) temp.getY())][(int) temp.getX() + 1] != 'S' && maze[((int) temp.getY())][(int) temp.getX() + 1] != 'E' && maze[((int) temp.getY())][(int) temp.getX() + 1] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getX()) + 1 == x && (int) temp.getY() == y) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY())][(int) temp.getX() + 1])) {
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
                queue.offer(new Point(((int) temp.getX()) + 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() + 1] = count;
            }
        }
        return -1;
    }
}
