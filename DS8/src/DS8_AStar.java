import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_AStar {
    public static DS8_Path_Solution aStar_Simple(char[][] maze){
        ArrayList<DS8_AStar_Node<Point>> open = new ArrayList();
        ArrayList<DS8_AStar_Node<Point>> closed = new ArrayList<>();
        Point start = null;
        Point end = null;
        for (int y = 0; y < maze.length; y++) {
            for (int x =0 ;x<maze[0].length; x++){
                if (maze[y][x]=='S') start = new Point(x,y);
                else if (maze[y][x]=='E') end = new Point(x,y);
            }
        }
        int h = Math.abs(start.x- end.x)+ Math.abs(start.y- end.y);
        open.add(new DS8_AStar_Node<>(start,null, 0, h));

        while(!open.isEmpty()){
            Collections.sort(open);
            DS8_AStar_Node<Point> temp = open.remove(open.size()-1);

            if (temp.getLocation().equals(end)){
                return new DS8_Path_Solution(closed, temp.getF());
            }

            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] i : dir) {
                int y = temp.getLocation().y + i[1];
                int x = temp.getLocation().x + i[0];
                if (x >= 0 && x < maze[0].length && y >= 0 && y < maze.length) {
                    for (int a = 0; a< closed.size(); )
                }
            }


        }
    }
}
