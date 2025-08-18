public class DS0_CH11 {

    public static boolean isSolvable(char[][] maze, boolean[][] beenThere, int column, int row){
        boolean x =false;
        beenThere[column][row]=true;
        if (maze[column][row]=='E') return true;

        if (column+1<maze.length&&!beenThere[column+1][row]&&maze[column+1][row]!='W'){
            x= isSolvable(maze,beenThere,column+1,row);
        }
        if(column-1>=0&&!beenThere[column-1][row]&&maze[column-1][row]!='W'&&!x){
            x= isSolvable(maze,beenThere,column-1,row);
        }
        if(row-1>=0&&!beenThere[column][row-1]&&maze[column][row-1]!='W'&&!x){
            x= isSolvable(maze,beenThere,column,row-1);
        }
        if(row+1<maze[0].length&&!beenThere[column][row+1]&&maze[column][row+1]!='W'&&!x){
            x= isSolvable(maze,beenThere,column,row+1);
        }
         return x;
    }
}