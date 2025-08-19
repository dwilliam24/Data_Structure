public class DS0_CH12 {
    public static void floodFill(char[][] grid, int col, int row, char toReplace, char newValue){
        if (grid[row][col]==toReplace) grid[row][col]=newValue;
        if (row+1<grid.length&&grid[row+1][col]==toReplace){
            floodFill(grid, col, row+1, toReplace, newValue);
        }
        if (row-1>0&&grid[row-1][col]==toReplace){
            floodFill(grid, col, row-1, toReplace, newValue);
        }
        if (col+1<grid[0].length&&grid[row][col+1]==toReplace){
            floodFill(grid, col+1, row, toReplace, newValue);
        }
        if (col-1>0&&grid[row][col-1]==toReplace){
            floodFill(grid, col-1, row, toReplace, newValue);
        }
    }
}

/*[[w, i, -, -],
[w, w, -, -],
[w, -, w, w],
[w, w, -, w],
 [w, w, -, w],
  [w, w, -, w],
   [w, w, -, w],
    [w, w, w, w]]

[[a, i, -, -],
[a, a, -, -],
[a, -, w, w],
[a, w, -, w],
[a, w, -, w]
[a, w, -, w],
[a, w, -, w],
[a, w, w, w]]
*/