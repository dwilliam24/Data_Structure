import java.awt.*;

public class DS8_DFS {
    public static boolean depthFirstSearch_Simple(char[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DS8_Stack<Point> stack = new DS8_Stack<>();
        Point start = null;
        Point end = null;
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
                if (maze[y][x] == 'E') end = new Point(x, y);
            }
        }
        stack.push(start);
        visited[(int) start.getY()][(int) start.getX()] = true;
        while (!stack.isEmpty()) {
            Point temp = stack.pop();

            if ((int) temp.getX() == (int) end.getX() && (int) temp.getY() == (int) end.getY()) return true;

            visited[(int) temp.getY()][(int) temp.getX()] = true;
            if (((int) temp.getY()) - 1 >= 0 && maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY()) - 1][(int) temp.getX()]) {
                stack.push(new Point((int) temp.getX(), (int) (temp.getY() - 1)));
                visited[(int) temp.getY() - 1][(int) temp.getX()] = true;
            }

            if (((int) temp.getY()) + 1 < maze.length && maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY()) + 1][(int) temp.getX()]) {
                stack.push(new Point((int) temp.getX(), (int) (temp.getY() + 1)));
                visited[(int) temp.getY() + 1][(int) temp.getX()] = true;

            }
            if (((int) temp.getX()) - 1 >= 0 && maze[(int) temp.getY()][(int) temp.getX() - 1] != 'W' && !visited[(int) temp.getY()][((int) temp.getX()) - 1]) {
                stack.push(new Point(((int) temp.getX()) - 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() - 1] = true;
            }
            if (((int) temp.getX()) + 1 < maze[0].length && maze[((int) temp.getY())][((int) temp.getX()) + 1] != 'W' && !visited[((int) temp.getY())][((int) temp.getX()) + 1]) {
                stack.push(new Point(((int) temp.getX()) + 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() + 1] = true;
            }
        }
        return false;
    }

    public static boolean depthFirstSearch_Portals(char[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DS8_Stack<Point> stack = new DS8_Stack<>();
        Point start = null;
        Point end = null;
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                if (maze[y][x] == 'S') start = new Point(x, y);
                if (maze[y][x] == 'E') end = new Point(x, y);
            }
        }
        stack.push(start);
        visited[(int) start.getY()][(int) start.getX()] = true;
        while (!stack.isEmpty()) {
            Point temp = stack.pop();

            if ((int) temp.getX() == (int) end.getX() && (int) temp.getY() == (int) end.getY()) return true;

            visited[(int) temp.getY()][(int) temp.getX()] = true;

            if (((int) temp.getY()) - 1 >= 0 && maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY()) - 1][(int) temp.getX()]) {
                if (maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'S' && maze[((int) temp.getY()) - 1][(int) temp.getX()] != 'E' && maze[((int) temp.getY()) - 1][(int) temp.getX()] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getY()) - 1 == y && (int) temp.getX() == x) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY()) - 1][(int) temp.getX()])) {
                                stack.push(new Point(x, y));
                            }
                        }
                    }
                }
                stack.push(new Point((int) temp.getX(), (int) (temp.getY() - 1)));
                visited[(int) temp.getY() - 1][(int) temp.getX()] = true;
            }

            if (((int) temp.getY()) + 1 < maze.length && maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY()) + 1][(int) temp.getX()]) {
                if (maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'S' && maze[((int) temp.getY()) + 1][(int) temp.getX()] != 'E' && maze[((int) temp.getY()) + 1][(int) temp.getX()] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getY()) + 1 == y && (int) temp.getX() == x) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY()) + 1][(int) temp.getX()])) {
                                stack.push(new Point(x, y));
                            }
                        }
                    }
                }
                stack.push(new Point((int) temp.getX(), (int) (temp.getY() + 1)));
                visited[(int) temp.getY() + 1][(int) temp.getX()] = true;

            }
            if (((int) temp.getX()) - 1 >= 0 && maze[(int) temp.getY()][(int) temp.getX() - 1] != 'W' && !visited[(int) temp.getY()][((int) temp.getX()) - 1]) {
                if (maze[((int) temp.getY())][(int) temp.getX() - 1] != 'S' && maze[((int) temp.getY())][(int) temp.getX() - 1] != 'E' && maze[((int) temp.getY())][(int) temp.getX() - 1] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getX()) - 1 == x && (int) temp.getY() == y) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY())][(int) temp.getX() - 1])) {
                                stack.push(new Point(x, y));
                            }
                        }
                    }
                }
                stack.push(new Point(((int) temp.getX()) - 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() - 1] = true;
            }
            if (((int) temp.getX()) + 1 < maze[0].length && maze[((int) temp.getY())][((int) temp.getX()) + 1] != 'W' && !visited[((int) temp.getY())][((int) temp.getX()) + 1]) {
                if (maze[((int) temp.getY())][(int) temp.getX() + 1] != 'S' && maze[((int) temp.getY())][(int) temp.getX() + 1] != 'E' && maze[((int) temp.getY())][(int) temp.getX() + 1] != '-') {
                    for (int y = 0; y < maze.length; y++) {
                        for (int x = 0; x < maze[0].length; x++) {
                            if (!(((int) temp.getX()) + 1 == x && (int) temp.getY() == y) && Character.toLowerCase(maze[y][x]) == Character.toLowerCase(maze[((int) temp.getY())][(int) temp.getX() + 1])) {
                                stack.push(new Point(x, y));
                            }
                        }
                    }
                }
                stack.push(new Point(((int) temp.getX()) + 1, (int) (temp.getY())));
                visited[(int) temp.getY()][(int) temp.getX() + 1] = true;
            }
        }
        return false;
    }
}
