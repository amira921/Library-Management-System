package Classes;

import Main.Person;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.Database;
import Database.BorrowerTable;

public class Borrower extends Person{

    public static ArrayList<Borrower> borrower = new ArrayList<Borrower>();
    
    public Borrower(){
    
    }
    
    public Borrower(String Name,String email,long phone,int age, String Address,long SSN) {
        super(age, Name, Address,email,SSN,phone);
    }
    
    public  void addBorrower(Borrower x) throws IOException, SQLException, ClassNotFoundException {
         new BorrowerTable().InsertUpdateBorrower("INSERT INTO `borrower`(`Name`, `Email`, `Phone`, `Age`, `Address`, `SSN`)VALUES (?,?,?,?,?,?)", x);
     }
     
    public void updateBorrower(int id, Borrower x) throws SQLException, ClassNotFoundException{
        new BorrowerTable().InsertUpdateBorrower("UPDATE `borrower` SET `Name`=?,`Email`=?,`Phone`=?,`Age`=?,`Address`=?,`SSN`=? Where `id`="+id,x); 
    } 
    
    public void deleteBorrower(int id) throws ClassNotFoundException, SQLException{
       new BorrowerTable().delete_Borrower(id);
    } 
    public  void searchBorrower(int id) throws SQLException, ClassNotFoundException{
      ResultSet rs =  new BorrowerTable().searchBorrower(id);
      while (rs.next()) {
          System.out.println("id: "+rs.getString("id"));
          System.out.println("Name: "+rs.getString("Name"));
          System.out.println("National Id: "+rs.getString("SSN"));
          System.out.println("Phone: "+rs.getString("Phone"));
          System.out.println("Email: "+rs.getString("Email"));
          System.out.println("Age: "+rs.getString("Age"));
          System.out.println("Address: "+rs.getString("Address"));
          System.out.println("----------------------------------------------"); 
      }    
    }
    
    public  void displayAllBorrower() throws SQLException, ClassNotFoundException {
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
   
}
