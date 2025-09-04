import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        ArrayList<String> list = null;
        try {
            File fileRef = new File("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS1\\TicTacToe.txt");
            if (!fileRef.exists())
                fileRef.createNewFile();
            Scanner scanner = new Scanner(fileRef);
            list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        Character[][] board = new Character[3][3];
        if (list.isEmpty()){
            board= new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        }
        else {
            String[][] stringBoard = new String[3][3];
            for (int x = 0; x < list.size(); x++) {
                stringBoard[x] = list.get(x).split(" ");
            }

            for (int x = 0; x < stringBoard.length; x++) {
                for (int y = 0; y < stringBoard[0].length; y++) {
                    board[y][x] = stringBoard[y][x].charAt(0);
                }
            }
            System.out.println("Game save loaded.");
        }
        Scanner scanner = new Scanner(System.in);
        while(!isWin(board))
        {
            printBoard(board);
            System.out.println("Entering a 3 for the column or row will save the game.");
            System.out.println("Enter a column from 0 to 2:");
            while (scanner.nextInt()<0||scanner.nextInt()>3)
            {
                System.out.println("Enter a column from 0 to 2:");
                if (scanner.nextInt())
            }
        }


    }


    public static void saveBoard(Character[][] board) {
        try{
            File fileRef = new File("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS1\\TicTacToe.txt");
            FileWriter fileWriter = new FileWriter(fileRef,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(board[0][0]+" "+board[0][1]+" "+board[0][2]);
            printWriter.println(board[1][0]+" "+board[1][1]+" "+board[1][2]);
            printWriter.print(board[2][0]+" "+board[2][1]+" "+board[2][2]);
            fileWriter.close();
            printWriter.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static boolean isWin(Character[][] board)
    {
        if (board[0][0].equals(board[0][1])&&board[0][1].equals(board[0][2])){return true;}
        if (board[1][0].equals(board[1][1])&&board[1][1].equals(board[1][2])){return true;}
        if (board[2][0].equals(board[2][1])&&board[2][1].equals(board[2][2])){return true;}

        if (board[0][0].equals(board[1][0])&&board[1][0].equals(board[2][0])){return true;}
        if (board[0][1].equals(board[1][1])&&board[1][1].equals(board[2][1])){return true;}
        if (board[0][2].equals(board[1][2])&&board[1][2].equals(board[2][2])){return true;}

        if (board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])){return true;}
        if (board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0])){return true;}

        return false;
    }

    public static boolean play(Character[][] board, int col, int row, Character player)
    {
        if (!isWin(board)&&board[row][col]==' '){
            board[row][col]=player;
            return true;
        }
        return false;
    }

    public static int[] bot(Character[][] board)
    {
        int x = (int) (Math.random() * 3);
        int y = (int) (Math.random() * 3);
        while (!isWin(board)&&board[y][x]!=' '){
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        return new int[]{x, y};
    }

    public static void printBoard(Character[][] board){
        System.out.println(" "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" ");
        System.out.println("-----------");
        System.out.println(" "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" ");
        System.out.println("-----------");
        System.out.println(" "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" ");
    }
}