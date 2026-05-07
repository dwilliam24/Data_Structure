import java.sql.*;
import java.util.Scanner;

public class TeamManager {
    private static Connection connection;

    public static void main(String[] args){
        String menu = """
                Team Roster Manager
                
                1. Add Team
                2. Add Player
                3. Add Game Result
                4. Edit Player Jersey Number
                5. Remove Player
                6. Display Teams
                7. Display Players
                8. Display Games
                9. Print Team Report
                10. Exit
                
                Enter choice:
                """;
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","password");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        while(loop) {
            System.out.println(menu);
            int choice = scanner.nextInt();
            while (choice > 10 || choice < 1) {
                System.out.println(menu);
                choice = scanner.nextInt();
            }
            if (choice == 1) {

            } else if (choice == 2) {

            } else if (choice == 3) {

            } else if (choice == 4) {

            } else if (choice == 5) {

            } else if (choice == 6) {

            } else if (choice == 7) {

            } else if (choice == 8) {

            } else if (choice == 9) {

            } else {
                loop=false;
            }
        }





        try {
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
