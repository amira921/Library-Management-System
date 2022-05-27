package Main;

import Classes.Admin;
import Classes.Book;
import Classes.Borrower;
import Classes.Borrowing;
import Classes.Liberarian;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Home {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int ch = 1;
        try {
            while (ch != 0) {

                System.out.print("\n\nWelecome to Liberary Management System\n");

                System.out.println("\n\t ------------------------\n\t"
                        + "| Enter 1: Admin.        |\n\t| Enter 2: Liberarian.   |"
                        + "\n\t ------------------------\n\t");

                System.out.print("\nChoose: ");
                ch = input.nextInt();
                switch (ch) {
                    case 1:
                        CaseAdmin();
                        break;
                    case 2:
                        CaseLiberarian();
                        break;
                    default:
                        System.out.println("Enter a Valid Choise");
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("choose a number!");
            main(args);
        }

    } 
      public static void CaseAdmin() throws IOException, SQLException, ClassNotFoundException {
        
        Admin admin = new Admin("Ahmed Saad",30, "admin", "admin","Cairo","Admin@yahoo.com",0112223456,301040201);
   
        Scanner input = new Scanner(System.in);
        Scanner spaces = new Scanner(System.in).useDelimiter(" ");
       
        int ch = 1;

        String userName, Pass, name, address, email;
        int id, oldID, age;
        long phone, ssn;

        Liberarian liberarian = new Liberarian();

        System.out.print("\n\nWelecome Admin... !\n\nUser Name : ");
        userName = input.next();
        System.out.print("Password  : ");
        Pass = input.next();

        if (admin.login(userName, Pass)) {

            while (ch != 0) {
                System.out.println("\n\t ______________________________________\n\t"
                        + "| Enter 1: Add New Liberarian.         |"
                        + "\n\t| Enter 2: Update Liberarian.          |"
                        + "\n\t| Enter 3: Delete Liberarian.          |"
                        + "\n\t| Enter 4: Display All Liberarian.     |"
                        + "\n\t| Enter 5: Search Liberarian.          |"
                        + "\n\t| Enter 6: Exit.                       |"
                        + "\n\t ______________________________________\n\t");
                System.out.print("Choose: ");
                
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("\nEnter Liberarian Info ... ");
                        System.out.print("\nName : ");
                        name = spaces.nextLine().toString();
                        System.out.print("Age : ");
                        age = input.nextInt();
                        System.out.print("Username : ");
                        userName = spaces.nextLine().toString();
                        System.out.print("Password : ");
                        Pass = spaces.nextLine().toString();
                        System.out.print("Address : ");
                        address = spaces.nextLine().toString();
                        System.out.print("Email: ");
                        email = spaces.nextLine().toString();
                        System.out.print("Phone: ");
                        phone = input.nextLong();
                        System.out.print("SSN: ");
                        ssn = input.nextLong();
                      
                        Liberarian x = new Liberarian( name, age, userName, Pass, address, email, phone, ssn);
                        liberarian.addLiberarian(x);
                        new Message().add_confirmation();
                        break;

                    case 2:
                        System.out.print("\nEnter Liberarian name : ");
                        name= spaces.nextLine().toString();
                        System.out.println("info");
                        System.out.println("-------------------------------------");
                        liberarian.searchLiberarian(name);
                        
                        System.out.print("\nUpdate Liberarian info ...!\nEnter Liberarian ID : ");
                        oldID = input.nextInt();

                        System.out.println("\nEnter Liberarian Info ... ");
                        System.out.print("Name : ");
                        name = spaces.nextLine().toString();
                        System.out.print("Age : ");
                        age = input.nextInt();
                        System.out.print("Username : ");
                        userName = spaces.nextLine().toString();
                        System.out.print("Password : ");
                        Pass = spaces.nextLine().toString();
                        System.out.print("Address : ");
                        address = spaces.nextLine().toString();
                        System.out.print("Email: ");
                        email = spaces.nextLine().toString();
                        System.out.print("Phone: ");
                        phone = input.nextLong();
                        System.out.print("SSN: ");
                        ssn = input.nextLong();

                        Liberarian y = new Liberarian( name, age, userName, Pass, address, email, phone, ssn);
                        liberarian.updateLiberarian(oldID, y);
                        new Message().update_confirmation();
                        break;

                    case 3:
                        System.out.print("\nDelete Liberarian info ...!\nEnter Liberarian ID : ");
                        id = input.nextInt();
                        liberarian.deleteLiberarian(id);
                        new Message().delete_confirmation();
                        break;

                    case 4:
                        liberarian.displayAllLiberarians();
                        break;
                    case 5:
                        System.out.print("\nSearch for Liberarian ...!\nEnter Liberarian Name : ");
                        name = spaces.nextLine().toString();
                        System.out.println("------------------------------");
                        liberarian.searchLiberarian(name);
                        break;
                     case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter vaild Option");
                }
            }
        } else {
                System.out.println("Enter a Valid username or password ");
                CaseAdmin();
            }
       }
        
    

    public static void CaseLiberarian() throws IOException, ClassNotFoundException, SQLException {

        Scanner input = new Scanner(System.in);
        Scanner spaces = new Scanner(System.in).useDelimiter(" ");

        int ch = 1;

        String userName, Pass, name, address, email, recieved_date, due_date, return_date,title,publisher,author;
        int id, oldID, age, edition, copies, used, book_id,borrower_id;
        float cost;
        long phone, ssn;

        Liberarian liberarian = new Liberarian();
        Borrower   borrower =new Borrower();
        Book book =new Book();
        Borrowing borrowing = new Borrowing();
       
        System.out.println("-----------------------------------------");
        System.out.print("\nWelecome Liberarian... !\n\nUsername : ");
        userName = input.next();
        System.out.print("Password  : ");
        Pass = input.next();

        if (liberarian.login(userName,Pass)) {

            while (ch != 0) {
                System.out.println("\n\t -----------------------------------------\n\t"
                        + "| Enter 1: Add New Borrower.               |"
                        + "\n\t| Enter 2: Update Borrower.                |"
                        + "\n\t| Enter 3: Delete Borrower.                |"
                        + "\n\t| Enter 4: Display All Borrower.           |"
                        + "\n\t| Enter 5: Search Borrower.                |"
                        + "\n\t| Enter 6: Add Book.                       |"
                        + "\n\t| Enter 7: Update Book.                    |"
                        + "\n\t| Enter 8: Delete Book.                    |"
                        + "\n\t| Enter 9: Display All Book.               |"
                        + "\n\t| Enter 10: Search Book.                   |"
                        + "\n\t| Enter 11: Add New Borrowing Process.     |"
                        + "\n\t| Enter 12: Update Borrowing Process.      |"
                        + "\n\t| Enter 13: Delete Borrowing Process.      |"
                        + "\n\t| Enter 14: Display All Borrowing Process. |"
                        + "\n\t| Enter 15: Search Borrowing Process.      |"
                        + "\n\t| Enter 16: Exit                           |"
                        + "\n\t -----------------------------------------\n\t");
           
                System.out.print("Choose: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("Enter Borrower Info ... ");
                        System.out.print("Name : ");
                        name = spaces.nextLine().toString();
                        System.out.print("Age : ");
                        age = input.nextInt();
                        System.out.print("Address : ");
                        address = spaces.nextLine().toString();
                        System.out.print("Email: ");
                        email =spaces.nextLine().toString();
                        System.out.print("Phone: ");
                        phone = input.nextLong();
                        System.out.print("SSN: ");
                        ssn = input.nextLong();
                        Borrower a =new Borrower(name,email,phone,age,address,ssn);
                        borrower.addBorrower(a);
                        new Message().add_confirmation();
                        break;

                    case 2:
                        System.out.print("\nUpdate Borrower info ...!\nEnter Borrower OldID : ");
                        oldID = input.nextInt();
                       
                        borrower.searchBorrower(oldID);

                        System.out.println("Enter Borrower Info ... ");
                        System.out.print("Name : ");
                        name = spaces.nextLine().toString();
                        System.out.print("Age : ");
                        age = input.nextInt();
                        System.out.print("Address : ");
                        address = spaces.nextLine().toString();
                        System.out.print("Email: ");
                        email = spaces.nextLine().toString();
                        System.out.print("Phone: ");
                        phone = input.nextLong();
                        System.out.print("SSN: ");
                        ssn = input.nextLong();

                        Borrower a2 = new Borrower(name,email,phone,age,address,ssn);
                        borrower.updateBorrower(oldID, a2);
                        new Message().update_confirmation();
                        break;

                    case 3:
                        System.out.print("\nDelete Borrower info ...!\nEnter Borrower ID : ");
                        id = input.nextInt();
                        borrower.deleteBorrower(id);
                        new Message().delete_confirmation();
                        break;

                    case 4:
                        borrower.displayAllBorrower();
                        break;
                    case 5:
                        System.out.print("\nSearch for Borrower ...!\nEnter Borrower ID : ");
                        id = input.nextInt();
                        borrower.searchBorrower(id);
                        break;
                    case 6:
                        System.out.println("Enter Book Info ... ");
                        System.out.print("Title : ");
                        title = spaces.nextLine().toString();
                        System.out.print("Edition : ");
                        edition = input.nextInt();
                        System.out.print("Cost: ");
                        cost = input.nextFloat();
                        System.out.print("Copies : ");
                        copies = input.nextInt();
                        System.out.print("Used: ");
                        used = input.nextInt();
                        System.out.print("Publisher : ");
                        publisher = spaces.nextLine().toString();
                        System.out.print("Author : ");
                        author = spaces.nextLine().toString();
                        Book b1 = new Book (title,publisher,author,edition,copies,used,cost);
                        book.addBook(b1);
                        new Message().add_confirmation();
                        break;

                    case 7:
                        System.out.print("\nUpdate Book info ...!\nEnter Book Title : ");
                        title = spaces.nextLine().toString();
                        book.searchBook(title);

                        System.out.print("\nUpdate Book info ...!\nEnter Book Id : ");
                        oldID = input.nextInt();

                        System.out.println("Enter Book Info ... ");                   
                        System.out.print("Title : ");
                        title = spaces.nextLine().toString();
                        System.out.print("Edition : ");
                        edition = input.nextInt();
                        System.out.print("Cost: ");
                        cost = input.nextFloat();
                        System.out.print("Copies : ");
                        copies = input.nextInt();
                        System.out.print("Used: ");
                        used = input.nextInt();
                        System.out.print("Publisher : ");
                        publisher = spaces.nextLine().toString();
                        System.out.print("Author : ");
                        author = spaces.nextLine().toString();

                        Book b2 = new Book(title,publisher,author,edition,copies,used,cost);
                        book.updateBook(oldID, b2);
                        new Message().update_confirmation();
                        break;

                    case 8:
                        System.out.print("\nDelete Book info ...!\nEnter Book ID : ");
                        id = input.nextInt();
                        book.deleteBook(id);
                        new Message().delete_confirmation();

                        break;

                    case 9:
                        book.displayAllBook();
                        break;
                    case 10:
                        System.out.print("\nSearch for Book ...!\nEnter Book Title : ");
                        title = spaces.nextLine().toString();
                        book.searchBook(title);
                        break;
                    case 11:
                        System.out.println("Enter Borrowing Process Info ... ");
                        System.out.print("Book ID : ");
                        book_id = input.nextInt();
                        System.out.print("Borrower ID : ");
                        borrower_id = input.nextInt();
                        System.out.print("Recieved Date : ");
                        recieved_date = input.next();
                        System.out.print("Due Date : ");
                        due_date = input.next();
                      
                        Borrowing c = new Borrowing( book_id, borrower_id, recieved_date, due_date, null);
                        borrowing.addBorrowing(c);
                        new Message().add_confirmation();

                        break;

                    case 12:
                        System.out.print("\nUpdate Borrowing Process info ...!\nEnter Borrowing Process ID : ");
                        oldID = input.nextInt();

                        borrowing.searchBorrowing(oldID);

                        System.out.println("Enter Borrowing Process Info ... ");
                        System.out.print("Book ID : ");
                        book_id = input.nextInt();
                        System.out.print("Borrower ID : ");
                        borrower_id = input.nextInt();
                        System.out.print("Recieved Date : ");
                        recieved_date = input.next();
                        System.out.print("Due Date : ");
                        due_date = input.next();
                        System.out.print("Return Date : ");
                        return_date = input.next();

                        Borrowing c1 = new Borrowing( book_id, borrower_id, recieved_date, due_date, return_date);
                        borrowing.updateBorrowing(oldID, c1);
                        new Message().update_confirmation();
                        break;

                    case 13:
                        System.out.print("\nDelete Borrowing Process info ...!\nEnter Borrowing Process ID : ");
                        id = input.nextInt();
                        borrowing.deleteBorrowing(id);
                        new Message().delete_confirmation();
                        break;

                    case 14:
                        borrowing.displayAllBorrowing();
                        break;
                    case 15:
                        System.out.print("\nSearch for Borrowing Process ...!\nEnter Borrowing Borrowing process ID : ");
                        id = input.nextInt();
                        borrowing.searchBorrowing(id);
                        break;
                    case 16:
                        System.exit(0);
                        
                    default:
                        System.out.println("Enter vaild Option :(");
                }
            } 
                 
        }else {
                System.out.println("Enter a Valid username or password ");
                CaseLiberarian();
            }
    }
}
