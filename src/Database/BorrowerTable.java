package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Classes.Borrower;
import static Database.Database.connection;

public class BorrowerTable {

    public void InsertUpdateBorrower(String query, Borrower x) {

        try {
            PreparedStatement preparedStatement = new Database().insert_update(query);
            preparedStatement.setString(1, x.getName());
            preparedStatement.setString(2, x.getEmail());
            preparedStatement.setLong(3, x.getPhone());
            preparedStatement.setInt(4, x.getAge());
            preparedStatement.setString(5, x.getAddress());
            preparedStatement.setLong(6, x.getSSN());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet searchBorrower(int id) {
        ResultSet rs = null;
        try {
            new Database().intialize();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `Borrower` WHERE `id`=" + id);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void delete_Borrower(int id) {
        try {
            PreparedStatement preparedStatement = new Database().insert_update("DELETE FROM `borrower` WHERE `id`=" + id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
