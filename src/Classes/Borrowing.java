package Classes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Borrowing {
    
    public static ArrayList<Borrowing> borrowing = new ArrayList<Borrowing>();
    
    protected int book_id,borrower_id,process_id;
    protected String recieved_date,due_date,return_date;

    public Borrowing() {
    }

    public Borrowing(int book_id, int borrower_id, String recieved_date, String due_date, String return_date) {
        this.book_id = book_id;
        this.borrower_id = borrower_id;
        this.recieved_date = recieved_date;
        this.due_date = due_date;
        this.return_date = return_date;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(int borrower_id) {
        this.borrower_id = borrower_id;
    }

    public String getRecieved_date() {
        return recieved_date;
    }

    public void setRecieved_date(String recieved_date) {
        this.recieved_date = recieved_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
    
      public void addBorrowing(Borrowing x) throws IOException, SQLException, ClassNotFoundException {
       new Database.BorrowingTable().InsertUpdateBorrowing("INSERT INTO `borrowing`(`book_id`, `borrower_id`, `recieved_date`, `due_date`, `return_date`)  VALUES (?,?,?,?,?)", x);
     }
     
    public void updateBorrowing(int id, Borrowing x) throws SQLException, ClassNotFoundException{
       new Database.BorrowingTable().InsertUpdateBorrowing("UPDATE `borrowing` SET `book_id`=?,`borrower_id`=?,`recieved_date`=?,`due_date`=?,`return_date`=? Where `process_id`="+id,x); 
    } 
    
    public void deleteBorrowing(int id) throws ClassNotFoundException, SQLException{
       new Database.BorrowingTable().delete_Borrowing(id);
    } 
    public  void searchBorrowing(int Borrower_id) throws SQLException, ClassNotFoundException{
      ResultSet rs =  new Database.BorrowingTable().searchBorrowing(Borrower_id);
      while (rs.next()) {
          System.out.println("Process id: "+rs.getString("process_id"));
          System.out.println("Book id: "+rs.getString("book_id"));
          System.out.println("Recieved date: "+rs.getString("recieved_date"));
          System.out.println("Due date: "+rs.getString("due_date"));
          System.out.println("Return date: "+rs.getString("return_date"));
          System.out.println("----------------------------------------------"); 
      }    
    }
    
    public  void displayAllBorrowing() throws SQLException, ClassNotFoundException {
      ResultSet rs = new Database.Database().Select("SELECT * FROM `Borrowing`");
      while (rs.next()) {
          System.out.println("Process id: "+rs.getString("process_id"));
          System.out.println("Book id: "+rs.getString("book_id"));
          System.out.println("Recieved date: "+rs.getString("recieved_date"));
          System.out.println("Due date: "+rs.getString("due_date"));
          System.out.println("Return date: "+rs.getString("return_date"));
          System.out.println("----------------------------------------------"); 
        }      
    }
   
    
}
