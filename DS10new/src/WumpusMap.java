public class WumpusMap {;
    public static final int NUM_ROWS=10;
    public static final int NUM_COLUMNS=10;
    public static final int NUM_PITS=10;
    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;
    public WumpusMap(){

    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }
    public WumpusSquare getSquare(int col, int row){
        return grid[row][col];
    }
    public String toString(){
        return"a";
    }
}
