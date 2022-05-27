package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Classes.Borrowing;
import static Database.Database.connection;

public class BorrowingTable {

    public void InsertUpdateBorrowing(String query, Borrowing x) {
        try {
            PreparedStatement preparedStatement = new Database().insert_update(query);
            preparedStatement.setInt(1, x.getBook_id());
            preparedStatement.setInt(2, x.getBorrower_id());
            preparedStatement.setString(3, x.getRecieved_date());
            preparedStatement.setString(4, x.getDue_date());
            preparedStatement.setString(5, x.getReturn_date());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet searchBorrowing(int process_id) {
        ResultSet rs = null;
        try {
            new Database().intialize();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `Borrowing` WHERE `process_id`=" + process_id);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void delete_Borrowing(int id) {
        try {
            PreparedStatement preparedStatement = new Database().insert_update("DELETE FROM `borrowing` WHERE `process_id`=" + id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
