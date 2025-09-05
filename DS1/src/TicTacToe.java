import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
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
                String[] fixed = new String[3];
                if (list.get(x).split(",").length!=3) {
                    System.out.println(list.get(x).split(",").length);
                    for (int a = 0; a < list.get(x).split(",").length; a++) {
                        fixed[a] = list.get(x).split(",")[a];
                    }
                    for (int a = list.get(x).split(",").length; a < 3; a++) {
                        fixed[a] = " ";
                    }
                    stringBoard[x] = fixed;
                }
            }

            for (int x = 0; x < stringBoard.length; x++) {
                for (int y = 0; y < stringBoard[0].length; y++) {
                if (stringBoard[y][x]==null){
                    stringBoard[y][x]=" ";
                }
                }
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
            int xMove = scanner.nextInt();
            while (xMove<0||xMove>3)
            {
                System.out.println("Enter a column from 0 to 2:");
                xMove = scanner.nextInt();
            }

            if (xMove==3){
                saveBoard(board);
                break;
            }
            System.out.println("Enter a row from 0 to 2:");
            int yMove = scanner.nextInt();
            while (yMove <0|| yMove >3)
            {
                System.out.println("Enter a row from 0 to 2:");
                yMove = scanner.nextInt();
            }
            if (yMove==3){
                saveBoard(board);
                break;
            }

            boolean x = play(board, xMove, yMove, 'X');
            bot(board);

            while (!x){
                printBoard(board);
                System.out.println("Entering a 3 for the column or row will save the game.");
                System.out.println("Enter a column from 0 to 2:");
                xMove= scanner.nextInt();
                while (xMove<0||xMove>3)
                {
                    System.out.println("Enter a column from 0 to 2:");
                    xMove = scanner.nextInt();
                }
                if (xMove==3){
                    saveBoard(board);
                    break;
                }
                System.out.println("Enter a row from 0 to 2:");
                yMove = scanner.nextInt();
                while (yMove <0|| yMove >3)
                {
                    System.out.println("Enter a row from 0 to 2:");
                    yMove = scanner.nextInt();
                }
                if (yMove==3){
                    saveBoard(board);
                    break;
                }
                x = play(board, xMove, yMove, 'X');
                bot(board);
            }

        }


    }


    public static void saveBoard(Character[][] board) {
        try{
            File fileRef = new File("C:\\Users\\k2306075\\OneDrive - Katy Independent School District\\GitHub\\Data_Structure\\DS1\\TicTacToe.txt");
            FileWriter fileWriter = new FileWriter(fileRef,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(board[0][0]+","+board[0][1]+","+board[0][2]);
            printWriter.println(board[1][0]+","+board[1][1]+","+board[1][2]);
            printWriter.print(board[2][0]+","+board[2][1]+","+board[2][2]);
            fileWriter.close();
            printWriter.close();
            System.out.println("Save Complete.");
            System.out.println("Good bye.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static boolean isWin(Character[][] board)
    {
        if (board[0][0].equals(board[0][1])&&board[0][1].equals(board[0][2])&&board[0][0]!=' '){System.out.println(board[0][0]+" Wins!"); return true;}
        if (board[1][0].equals(board[1][1])&&board[1][1].equals(board[1][2])&&board[1][0]!=' '){System.out.println(board[1][0]+" Wins!"); return true;}
        if (board[2][0].equals(board[2][1])&&board[2][1].equals(board[2][2])&&board[2][0]!=' '){System.out.println(board[2][0]+" Wins!"); return true;}

        if (board[0][0].equals(board[1][0])&&board[1][0].equals(board[2][0])&&board[0][0]!=' '){System.out.println(board[0][0]+" Wins!"); return true;}
        if (board[0][1].equals(board[1][1])&&board[1][1].equals(board[2][1])&&board[0][1]!=' '){System.out.println(board[0][1]+" Wins!"); return true;}
        if (board[0][2].equals(board[1][2])&&board[1][2].equals(board[2][2])&&board[0][2]!=' '){System.out.println(board[0][2]+" Wins!"); return true;}

        if (board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])&&board[0][0]!=' '){System.out.println(board[0][0]+" Wins!"); return true;}
        if (board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0])&&board[0][2]!=' '){System.out.println(board[0][2]+" Wins!"); return true;}

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

    public static void bot(Character[][] board)
    {
        int x = (int) (Math.random() * 3);
        int y = (int) (Math.random() * 3);
        while (!isWin(board)&&board[y][x]!=' '){
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        play(board, x, y,'O');
    }

    public static void printBoard(Character[][] board){
        System.out.println(" "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" ");
        System.out.println("-----------");
        System.out.println(" "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" ");
        System.out.println("-----------");
        System.out.println(" "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" ");
    }
}