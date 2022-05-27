package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Classes.Book;
import static Database.Database.connection;

public class BookTable {

    public void InsertUpdateBook(String query, Book x) {

        try {
            PreparedStatement preparedStatement = new Database().insert_update(query);
            preparedStatement.setInt(1, x.getEdition());
            preparedStatement.setInt(2, x.getCopies());
            preparedStatement.setInt(3, x.getUsed());
            preparedStatement.setFloat(4, x.getCost());
            preparedStatement.setString(5, x.getTitle());
            preparedStatement.setString(6, x.getPublisher());
            preparedStatement.setString(7, x.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet searchBook(String name) {
        ResultSet rs = null;
        try {
            new Database().intialize();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `Book` WHERE `Title`=\"" + name + "\"");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void delete_Book(String query, int id) {
        try {
            PreparedStatement preparedStatement = new Database().insert_update(query + id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
