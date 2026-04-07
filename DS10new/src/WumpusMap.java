public class WumpusMap {;
    public static final int NUM_ROWS=10;
    public static final int NUM_COLUMNS=10;
    public static final int NUM_PITS=10;
    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;
    public WumpusMap(){
        createMap();
    }
    public void createMap(){

    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }
    public WumpusSquare getSquare(int col, int row){
        if (col>grid.length||row>grid[0].length||col<0||row<0){
            return null;
        }
        return grid[row][col];
    }
    public String toString(){
        String a ="";
        for(int y=0; y<grid[0].length; y++){
            for (int x=0; x< grid.length; x++){
                a+=grid[y][x].toString();
            }
            a+="\n";
        }
        return a;
    }
}
