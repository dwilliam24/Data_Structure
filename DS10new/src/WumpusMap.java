import java.util.ArrayList;

public class WumpusMap {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 10;
    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;

    public WumpusMap() {
        boolean solved = false;
        while (!solved) {
            createMap();
            solved = hasSolution();
        }
    }

    private char[][] toMaze(int startR, int startC, int endR, int endC) {
        char[][] maze = new char[NUM_ROWS][NUM_COLUMNS];
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                if (r == startR && c == startC)
                    maze[r][c] = 'S';
                else if (r == endR && c == endC)
                    maze[r][c] = 'E';
                else if (grid[r][c].getPit())
                    maze[r][c] = 'W';
                else
                    maze[r][c] = '-';
            }
        }
        return maze;
    }

    private boolean hasSolution() {
        int goldR = -1, goldC = -1;
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                if (grid[r][c].getGold()) {
                    goldR = r;
                    goldC = c;
                }
            }
        }
        boolean ladderToGold = DS8_DFS.depthFirstSearch_Simple(toMaze(ladderR, ladderC, goldR, goldC));
        return ladderToGold;
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_ROWS][NUM_COLUMNS];
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                grid[r][c] = new WumpusSquare();
            }
        }

        ArrayList<Integer> pitNums = new ArrayList<>();
        while (pitNums.size() < NUM_PITS) {
            int gen = (int) (Math.random() * 100);
            if (!pitNums.contains(gen)) pitNums.add(gen);
        }
        for (int num : pitNums) {
            int r = num / 10;
            int c = num % 10;
            grid[r][c].setPit(true);
        }

        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                if (grid[r][c].getPit()) {
                    if (r - 1 >= 0 && !grid[r - 1][c].getPit()) grid[r - 1][c].setBreeze(true);
                    if (r + 1 < NUM_ROWS && !grid[r + 1][c].getPit()) grid[r + 1][c].setBreeze(true);
                    if (c - 1 >= 0 && !grid[r][c - 1].getPit()) grid[r][c - 1].setBreeze(true);
                    if (c + 1 < NUM_COLUMNS && !grid[r][c + 1].getPit()) grid[r][c + 1].setBreeze(true);
                }
            }
        }

        boolean placing = true;
        while (placing) {
            int r = (int) (Math.random() * NUM_ROWS);
            int c = (int) (Math.random() * NUM_COLUMNS);
            if (!grid[r][c].getPit()) {
                grid[r][c].setGold(true);
                placing = false;
            }
        }

        placing = true;
        while (placing) {
            int r = (int) (Math.random() * NUM_ROWS);
            int c = (int) (Math.random() * NUM_COLUMNS);
            if (!grid[r][c].getPit() && !grid[r][c].getGold()) {
                grid[r][c].setWumpus(true);
                placing = false;
            }
        }

        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                if (grid[r][c].getWumpus()) {
                    if (r - 1 >= 0) grid[r - 1][c].setStench(true);
                    if (r + 1 < NUM_ROWS) grid[r + 1][c].setStench(true);
                    if (c - 1 >= 0) grid[r][c - 1].setStench(true);
                    if (c + 1 < NUM_COLUMNS) grid[r][c + 1].setStench(true);
                }
            }
        }

        placing = true;
        while (placing) {
            int r = (int) (Math.random() * NUM_ROWS);
            int c = (int) (Math.random() * NUM_COLUMNS);
            if (!grid[r][c].getPit() && !grid[r][c].getGold() && !grid[r][c].getWumpus()) {
                grid[r][c].setLadder(true);
                ladderC = c;
                ladderR = r;
                placing = false;
            }
        }
    }

    public int[] wumpusLoc() {
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                if (grid[r][c].getWumpus()) return new int[]{c, r};
            }
        }
        return null;
    }

    public int getLadderCol() {
        return ladderC;
    }

    public int getLadderRow() {
        return ladderR;
    }

    public WumpusSquare getSquare(int col, int row) {
        if (col < 0 || col >= NUM_COLUMNS || row < 0 || row >= NUM_ROWS) return null;
        return grid[row][col];
    }

    public String toString() {
        String result = "";
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                result += grid[r][c].toString();
            }
            result += "\n";
        }
        return result;
    }
}