import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WumpusMap {
    ;
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 10;
    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;

    public WumpusMap() {
        createMap();
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_COLUMNS][NUM_ROWS];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[y][x] = new WumpusSquare();
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        while (a.size() < 10) {
            int generator = (int) (Math.random() * 100);
            if (!a.contains(generator)) {
                a.add(generator);
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) - 10 < 0) {
                grid[0][a.get(i)].setPit(true);
            } else if (a.get(i) == 100) {
                grid[10][10].setPit(true);
            } else {
                grid[Integer.parseInt(String.valueOf(a.get(i).toString().charAt(0)))][Integer.parseInt(String.valueOf(a.get(i).toString().charAt(1)))].setPit(true);
            }
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[y][x].getPit()) {
                    if (y - 1 >= 0 && !grid[y - 1][x].getPit()) {
                        grid[y - 1][x].setBreeze(true);
                    }
                    if (y + 1 < grid[0].length && !grid[y + 1][x].getPit()) {
                        grid[y + 1][x].setBreeze(true);
                    }
                    if (x - 1 >= 0 && !grid[y][x - 1].getPit()) {
                        grid[y][x - 1].setBreeze(true);
                    }
                    if (x + 1 < grid.length && !grid[y][x + 1].getPit()) {
                        grid[y][x + 1].setBreeze(true);
                    }
                }
            }
        }
        boolean test = true;
        while (test) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (!grid[y][x].getPit()) {
                grid[y][x].setGold(true);
                test = false;
            }
        }

        boolean test2 = true;
        while (test2) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (!grid[y][x].getPit() && !grid[y][x].getGold()) {
                grid[y][x].setWumpus(true);
                test2 = false;
            }
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[y][x].getWumpus()) {
                    if (y - 1 >= 0 && !grid[y - 1][x].getPit()) {
                        grid[y - 1][x].setStench(true);
                    }
                    if (y + 1 < grid[0].length && !grid[y + 1][x].getPit()) {
                        grid[y + 1][x].setStench(true);
                    }
                    if (x - 1 >= 0 && !grid[y][x - 1].getPit()) {
                        grid[y][x - 1].setStench(true);
                    }
                    if (x + 1 < grid.length && !grid[y][x + 1].getPit()) {
                        grid[y][x + 1].setStench(true);
                    }
                }
            }
        }
        boolean test3 = true;
        while (test3) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (!grid[y][x].getPit() && !grid[y][x].getGold() && !grid[y][x].getWumpus()) {
                grid[y][x].setLadder(true);
                ladderC = x;
                ladderR = y;
                test3 = false;
            }
        }
    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }

    public WumpusSquare getSquare(int col, int row) {
        if (col > grid.length || row > grid[0].length || col < 0 || row < 0) {
            return null;
        }
        return grid[row][col];
    }

    public String toString() {
        String a = "";
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                a += grid[y][x].toString();
            }
            a += "\n";
        }
        return a;
    }
}
