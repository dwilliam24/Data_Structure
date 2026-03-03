public class A10_ConnectFourGame
{
    public static final int PLAYING = 0;
    public static final int RED_WINS = 1;
    public static final int BLACK_WINS = 2;
    public static final int DRAW = 3;
    public static final int RED = 4;
    public static final int BLACK = 5;
    public static final int EMPTY = 6;

    private int[][] board;

    public A10_ConnectFourGame()
    {
        board = new int[][]{
                {6,6,6,6,6,6,6},
                {6,6,6,6,6,6,6},
                {6,6,6,6,6,6,6},
                {6,6,6,6,6,6,6},
                {6,6,6,6,6,6,6},
                {6,6,6,6,6,6,6}};
    }

    public boolean dropPiece (int column, int player)
    {
        if (columnFull(column)){return false;}
        else if (column<0||column>7){return false;}
        else {
            int b = 5;
            while (b >= 0 && board[b][column] != 6) {
                b--;
            }
            board[b][column] = player;
            return true;
        }
    }

    public int status()
    {
        //horizontal
        for(int y = 0; y <6; y++)
        {
            for(int x = 0; x <=3; x++)
            {
                if(board[y][x] == RED && board[y][x+1] == RED && board[y][x+2] == RED && board[y][x+3] == RED)
                    return RED_WINS;
                else if(board[y][x] == BLACK && board[y][x+1] == BLACK && board[y][x+2] == BLACK && board[y][x+3] == BLACK)
                    return BLACK_WINS;
            }
        }
        //vertical
        for(int y = 3; y <6; y++)
        {
            for(int x = 0; x <7; x++)
            {
                if(board[y][x] == RED && board[y-1][x] == RED && board[y-2][x] == RED && board[y-3][x] == RED)
                    return RED_WINS;
                else if(board[y][x] == BLACK && board[y-1][x] == BLACK && board[y-2][x] == BLACK && board[y-3][x] == BLACK)
                    return BLACK_WINS;
            }
        }
        //angle right
        for(int y = 0; y <3; y++)
        {
            for(int x = 3; x <7; x++)
            {
                if(board[y][x] == RED && board[y+1][x-1] == RED && board[y+2][x-2] == RED && board[y+3][x-3] == RED)
                    return RED_WINS;
                else if(board[y][x] == BLACK && board[y+1][x -1] == BLACK && board[y+2][x-2] == BLACK && board[y+3][x-3] == BLACK)
                    return BLACK_WINS;
            }
        }
        //angle left
        for(int y = 3; y <6; y++)
        {
            for(int x = 3; x <7; x++)
            {
                if(board[y][x] == RED && board[y-1][x-1] == RED && board[y-2][x-2] == RED && board[y-3][x -3] == RED)
                    return RED_WINS;
                else if(board[y][x] == BLACK && board[y-1][x -1] == BLACK && board[y-2][x-2] == BLACK && board[y-3][x-3] == BLACK)
                    return BLACK_WINS;
            }
        }

        for (int y=0; y<board.length; y++)
        {
            for(int x=0; x<board[0].length; x++)
            {
                if (board[y][x]==EMPTY)
                {
                    return PLAYING;
                }
            }
        }
        return DRAW;
    }

    public boolean columnFull(int column)
    {
        for (int x=0; x<6; x++)
        {
            if (board[x][column]==6){return false;}
        }
        return true;
    }
    public int[][] getBoard()
    {
        return board;
    }

    public void draw()
    {
        for (int y=0; y<board.length; y++)
        {
            System.out.print("|");
            for (int x=0; x<board[0].length; x++)
            {
                char a;
                if (board[y][x]==6) {a=' ';}
                else if (board[y][x]==4){a='R';}
                else {a='B';}
                System.out.print(" "+a+" |");
            }
            System.out.print("\n");
        }
        System.out.print("-----------------------------");
    }
}