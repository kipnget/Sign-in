package dao;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao {

    private DataSource ds;
    Connection con;

    //user register
    public void insertData(String name,
                           String password, String email) throws Exception {
        System.out.println("jdbc connection");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "", "");

        try {

            try {
                Statement st = con.createStatement();
                int value = st
                        .executeUpdate("INSERT INTO USER_DETAILS(NAME,PASSWORD,EMAIL) "
                                + "VALUES('"
                                + name
                                + "','"
                                + password
                                + "','"
                                + email);
                System.out.println("1 row affected" + value);
            } catch (SQLException ex) {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //user login
    public void LoginDAO() throws SQLException {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/db");
            if (ds == null) {
                throw new SQLException("Can't get data source");
            }
            // get database connection
            con = ds.getConnection();
            if (con == null) {
                throw new SQLException("Can't get database connection");
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public boolean changePassword(String userid, String oldpassword,
                                  String newpassword) {
        try {
            // Persist user
            PreparedStatement ps = con
                    .prepareStatement("UPDATE blueprintsdb.employee SET password='"
                            + newpassword
                            + "' WHERE userid='"
                            + userid + "'  and password='" + oldpassword + "'");
            int count = ps.executeUpdate();
            return (count > 0);
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean validateUser(String userid, String password) {
        try {
            // Check the logged admin/student is valid user or not
            PreparedStatement ps = con
                    .prepareStatement("select * FROM db.users WHERE userid='"
                            + userid + "'  and password='" + password + "'");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

}
