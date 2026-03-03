import java.util.Scanner;

public class A10_ConnectFourMain
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        A10_ConnectFourGame connect = new A10_ConnectFourGame();
        while (connect.status()==0)
        {
            connect.draw();
            System.out.println("\n\nRed enter a column for your move (0-6):\n");
            int Rcolumn = keyboard.nextInt();
            while ((Rcolumn <0|| Rcolumn >6)|| connect.columnFull(Rcolumn))
            {
                System.out.println("Invalid move.\n");
                System.out.println("Red enter a column for your move (0-6):\n");
                Rcolumn = keyboard.nextInt();
            }
            connect.dropPiece(Rcolumn, 4);

            if (connect.status() !=0) {break;}
            connect.draw();
            System.out.println("\n\nBlack enter a column for your move (0-6):\n");
            int Bcolumn = keyboard.nextInt();
            while ((Bcolumn <0|| Bcolumn >6)|| connect.columnFull(Bcolumn))
            {
                System.out.println("Invalid move.\n");
                System.out.println("Black enter a column for your move (0-6):\n");
                Bcolumn = keyboard.nextInt();
            }
            connect.dropPiece(Bcolumn, 5);
        }
        if (connect.status()==1){connect.draw();System.out.println("\n\nRed Wins!");}
        else if (connect.status()==2){connect.draw();System.out.println("\n\nBlack Wins!");}
        else {connect.draw(); System.out.println("\n\nTie Game.");}

    }
}