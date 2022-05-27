package Classes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Book {
    
    public static ArrayList<Book> book = new ArrayList<Book>();
    
    protected int id,edition,copies,used;
    protected float cost;
    protected String title,publisher,author;

    public Book() {
    }

    public Book(String title, String publisher, String author, int edition, int copies, int used, float cost) {
        this.edition = edition;
        this.copies = copies;
        this.used = used;
        this.cost = cost;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    
     public void addBook(Book x) throws IOException, SQLException, ClassNotFoundException {
       new Database.BookTable().InsertUpdateBook("INSERT INTO `Book`( `Edition`, `Copies`, `Used`, `Cost`, `Title`, `Publisher`, `Author`) VALUES (?,?,?,?,?,?,?)", x);
     }
     
    public void updateBook(int id, Book x) throws SQLException, ClassNotFoundException{
       new Database.BookTable().InsertUpdateBook("UPDATE `Book` SET `Edition`=?,`Copies`=?,`Used`=?,`Cost`=?,`Title`=?,`Publisher`=?,`Author`=? Where `id`="+id,x); 
    } 
    
    public void deleteBook(int id) throws ClassNotFoundException, SQLException{
       new Database.BookTable().delete_Book("DELETE FROM `Book` WHERE `id`=",id);
    } 
    public  void searchBook(String name) throws SQLException, ClassNotFoundException{
      ResultSet rs =  new Database.BookTable().searchBook(name);
      while (rs.next()) {
          System.out.println("id: "+rs.getString("id"));
          System.out.println("Edition: "+rs.getString("Edition"));
          System.out.println("Copies: "+rs.getString("Copies"));
          System.out.println("Used: "+rs.getString("Used"));
          System.out.println("Cost: "+rs.getString("Cost"));
          System.out.println("Title: "+rs.getString("Title"));
          System.out.println("Publisher: "+rs.getString("Publisher"));
          System.out.println("Author: "+rs.getString("Author"));
          System.out.println("----------------------------------------------"); 
      }    
    }
    
    public  void displayAllBook() throws SQLException, ClassNotFoundException {
      ResultSet rs = new Database.Database().Select("SELECT * FROM `Book`");
      while (rs.next()) {
          System.out.println("id: "+rs.getString("id"));
          System.out.println("Edition: "+rs.getString("Edition"));
          System.out.println("Copies: "+rs.getString("Copies"));
          System.out.println("Used: "+rs.getString("Used"));
          System.out.println("Cost: "+rs.getString("Cost"));
          System.out.println("Title: "+rs.getString("Title"));
          System.out.println("Publisher: "+rs.getString("Publisher"));
          System.out.println("Author: "+rs.getString("Author"));
          System.out.println("----------------------------------------------"); 
        }      
    }
   
    
}
