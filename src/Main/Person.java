package Main;

public abstract class Person {

    protected int id,age;
    protected String Name,Address,email;
    protected long SSN,phone;

    public Person(){
    
    }

    public Person( int age, String Name, String Address, String email, long SSN, long phone) {
        this.age = age;
        this.Name = Name;
        this.Address = Address;
        this.email = email;
        this.SSN = SSN;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getSSN() {
        return SSN;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }
   
}
