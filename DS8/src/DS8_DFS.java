import java.awt.Point;

public class DS8_DFS {
    public static boolean depthFirstSearch_Simple(char[][] maze) {
        boolean[][] visited = new boolean[maze[0].length][maze.length];
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
        visited[(int) start.getX()][(int) start.getY()] = true;
        while (!stack.isEmpty()) {
            Point temp = stack.pop();

            if ((int)temp.getX()==(int)end.getX()&&(int)temp.getY()==(int)end.getY()) return true;

            visited[(int) temp.getY()][(int) temp.getX()] = true;
            if (((int) temp.getY()) - 1 >= 0 && maze[((int) temp.getY())-1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY())-1][(int) temp.getX()]) {
                stack.push(new Point((int) temp.getX(), (int) (temp.getY()-1)));
            }
            if (((int) temp.getY()) + 1 < maze[0].length && maze[((int) temp.getY())+1][(int) temp.getX()] != 'W' && !visited[((int) temp.getY())+1][(int) temp.getX()]) {
                stack.push(new Point((int) temp.getX(), (int) (temp.getY()+1)));
            }
            if (((int) temp.getX()) - 1 >= 0 && maze[(int) temp.getY()][(int) temp.getX()-1] != 'W' && !visited[(int) temp.getY()][((int) temp.getX())-1]) {
                stack.push(new Point(((int) temp.getX())-1, (int) (temp.getY())));
            }
            if (((int) temp.getX()) + 1 < maze.length && maze[((int) temp.getY())][((int) temp.getX())+1] != 'W' && !visited[((int) temp.getY())][((int) temp.getX())+1]) {
                    stack.push(new Point(((int) temp.getX())+1, (int) (temp.getY())));
            }
        }
        return false;
    }

}
