package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Classes.Liberarian;
import static Database.Database.connection;

public class LiberarianTable extends Database {

    public void InsertUpdateLiberarian(String query, Liberarian x) {
        try {
            PreparedStatement preparedStatement = new Database().insert_update(query);
            preparedStatement.setString(1, x.getName());
            preparedStatement.setFloat(2, x.getSSN());
            preparedStatement.setLong(3, x.getPhone());
            preparedStatement.setString(4, x.getAddress());
            preparedStatement.setString(5, x.getUsername());
            preparedStatement.setString(6, x.getPass());
            preparedStatement.setString(7, x.getEmail());
            preparedStatement.setInt(8, x.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Process Failed");
        }
    }

    public ResultSet searchLiberarian(String name) {
        ResultSet rs = null;
        try {
            intialize();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `liberarian` WHERE `name`='" + name + "'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void delete_liberarian(int id) {
        try {
            PreparedStatement preparedStatement = insert_update("DELETE FROM `liberarian` WHERE `id`=" + id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
