package Classes;

import Main.Person;
import Database.Database;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.LiberarianTable;

public class Liberarian extends Person{

    protected String username,pass;
    
    public Liberarian(){
    }
    
    public Liberarian(String Name, int age, String username, String pass, String Address,String email,long phone, long SSN) {
        super( age, Name, Address,email,SSN,phone);
        this.username=username;
        this.pass=pass;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public  void addLiberarian(Liberarian x) throws IOException, SQLException, ClassNotFoundException {
         new LiberarianTable().InsertUpdateLiberarian("INSERT INTO `liberarian`( `name`, `ssn`, `phone`, `address`, `username`, `password`, `email`, `age`) VALUES (?,?,?,?,?,?,?,?)", x);
     }
     
    public  void updateLiberarian(int id, Liberarian x) throws SQLException, ClassNotFoundException{
       new LiberarianTable().InsertUpdateLiberarian("UPDATE `liberarian` SET `name`=?,`ssn`=?,`phone`=?,`address`=?,`username`=?,`password`=?,`email`=?,`age`=? Where `id`"+id,x); 
    } 
    
    public  void deleteLiberarian(int id) throws ClassNotFoundException, SQLException{
       new LiberarianTable().delete_liberarian(id);
    } 
    public  void searchLiberarian(String name) throws SQLException, ClassNotFoundException{
      ResultSet rs =  new LiberarianTable().searchLiberarian(name);
      while (rs.next()) {
          System.out.println("id: "+rs.getString("id"));
          System.out.println("Name: "+rs.getString("name"));
          System.out.println("National Id: "+rs.getString("ssn"));
          System.out.println("Phone: "+rs.getString("phone"));
          System.out.println("Username: "+rs.getString("username"));
          System.out.println("Password: "+rs.getString("password"));
          System.out.println("Email: "+rs.getString("email"));
          System.out.println("Age: "+rs.getString("age"));
          System.out.println("Address: "+rs.getString("address"));
          System.out.println("----------------------------------------------"); 
      }    
    }
    
    public  void displayAllLiberarians() throws SQLException, ClassNotFoundException {
      ResultSet rs = new Database().Select("SELECT * FROM `liberarian`");
      while (rs.next()) {
          System.out.println("id: "+rs.getString("id"));
          System.out.println("Name: "+rs.getString("name"));
          System.out.println("National Id: "+rs.getString("ssn"));
          System.out.println("Phone: "+rs.getString("phone"));
          System.out.println("Username: "+rs.getString("username"));
          System.out.println("Password: "+rs.getString("password"));
          System.out.println("Email: "+rs.getString("email"));
          System.out.println("Age: "+rs.getString("age"));
          System.out.println("Address: "+rs.getString("address"));
          System.out.println("----------------------------------------------");
        }      
    }
   
   
    
    public boolean login(String username, String password) throws ClassNotFoundException {

        if (username.length() == 0 && password.length() == 0) {
            System.out.println("Please enter your Username and Password");
        } else if (username.length() == 0) {
            System.out.println("Please enter your Username");
        } else if (password.length() == 0) {
            System.out.println("Please enter your Password");
        } else {
            try {
                ResultSet rs = new Database().Select("SELECT `username`,`password` FROM `liberarian`");
                while (rs.next()) {

                    String p = rs.getString(1);
                    String pp = rs.getString(2);

                    if (username.equals(p) && password.equals(pp)) {
                              return true;
                    } else {
                        System.out.println("Wrong Username/Password");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
