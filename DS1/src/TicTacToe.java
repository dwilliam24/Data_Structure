import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class TicTacToe {
    public static void main(String[] args)
    {
        Character[][] board = new Character[3][3];
        board = new Character[][]{{'a', 'c', 'b'}, {'a', 'v', 'c'}, {'d', 'f', 'j'}};
        //make a method
        try{
            File fileRef = new File("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS1\\TicTacToe.txt");
            if(!fileRef.exists())
                fileRef.createNewFile();
            FileWriter fileWriter = new FileWriter(fileRef,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(board[0][0]+" "+board[0][1]+" "+board[0][2]);
            printWriter.println(board[1][0]+" "+board[1][1]+" "+board[1][2]);
            printWriter.print(board[2][0]+" "+board[2][1]+" "+board[2][2]);
            fileWriter.close();
            printWriter.close();

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static boolean isWin(Character[][] board)
    {
        return false;
    }

    public static boolean play(Character[][] board, int col, int row, int player)
    {
        return false;
    }

    public static int[] bot(Character[][] board)
    {
        return new int[]{1};
    }


}
