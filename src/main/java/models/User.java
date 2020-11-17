package models;

public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;

    public void User(){

    }

    public void User(int id, String email){
        this.id = id;
        this.email = email;
    }
}
