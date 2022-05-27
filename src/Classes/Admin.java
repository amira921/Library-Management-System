package Classes;

import Main.Person;

public class Admin extends Person{

    protected String username,pass;
    Liberarian liberarian=new Liberarian();
    
    public Admin(){
    
    }
    
    public Admin(String Name, int age, String username, String pass, String Address,String email,long phone, long SSN) {
        super(age, Name, Address,email,SSN,phone);
        this.username=username;
        this.pass=pass;
    }
 
    public boolean login(String userName, String Pass) {
        if (userName.equals("admin") && Pass.equals("admin")) {
            return true;
        }
        return false;
    }
}
