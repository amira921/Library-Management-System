package Database;

import java.sql.*;

public class Database {

    public static Connection connection;

    public void intialize() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/l.m.s", "root", "");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PreparedStatement insert_update(String query) {
        PreparedStatement preparedStatement = null;
        try {
            intialize();
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return preparedStatement;
    }

    public ResultSet Select(String query) {
        ResultSet rs = null;
        try {
            intialize();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

}
