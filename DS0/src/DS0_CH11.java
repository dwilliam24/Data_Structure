public class DS0_CH11 {

    public static boolean isSolvable(char[][] maze, boolean[][] beenThere, int column, int row){
        boolean x =false;
        beenThere[row][column]=true;
        if (maze[row][column]=='E') return true;

        if (row+1<maze.length&&!beenThere[row+1][column]&&maze[row+1][column]!='W'){
            x= isSolvable(maze,beenThere,column,row+1);
        }
        if(row-1>=0&&!beenThere[row-1][column]&&maze[row-1][column]!='W'&&!x){
            x= isSolvable(maze,beenThere,column,row-1);
        }
        if(column-1>=0&&!beenThere[row][column-1]&&maze[row][column-1]!='W'&&!x){
            x= isSolvable(maze,beenThere,column-1,row);
        }
        if(column+1<maze[0].length&&!beenThere[row][column+1]&&maze[row][column+1]!='W'&&!x){
            x= isSolvable(maze,beenThere,column+1,row);
        }
         return x;
    }
}