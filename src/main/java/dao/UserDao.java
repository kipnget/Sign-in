package dao;


import models.Cohort;
import models.User;
import DB.DBConnection;

import java.sql.*;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public abstract class UserDao {

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
    public static String authenticateUser(User user) {
        String userName = User.getName();
        String password = User.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password,role from users");

            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                    return "Admin_Role";
                else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
                    return "Editor_Role";
                else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
                    return "User_Role";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }

    public abstract void add(User user);

    public abstract List<User> getAll();

    public abstract List<User>findById(int id);

    public abstract List<Cohort> getAll(int cohort_id);

    public abstract List<Cohort>getAllCohortById(int cohort_id);

    public abstract void clearAll();
}

