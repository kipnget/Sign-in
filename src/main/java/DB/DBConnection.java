package DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "123";

        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Post establishing a DB connection - "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}