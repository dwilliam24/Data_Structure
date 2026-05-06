import java.sql.*;

public class TeamManager {
    private static Connection connection;

    public static void main(String[] args){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","password");
        }
        catch(Exception e)
        {

            System.out.println(e);
        }





        try {connection.close();}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
