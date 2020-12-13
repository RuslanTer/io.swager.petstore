package models;

public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public String username;
    public int userStatus;

    public User(){

    }

    public User(int id, String email){
        this.id = id;
        this.email = email;
    }
    public User(int id, String username, String email, String firstName, String lastName, String password, String phone, int userStatus){
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        // 1
        if (this == o) {
            return true;
        }
        // 2
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        User order = (User) o;
        if (this.phone == null){
            return this.id == order.id &&
                    this.email == order.email;
        }

        return this.id == order.id &&
                this.userStatus == order.userStatus &&
                this.phone.equals(order.phone) &&
                this.email.equals(order.email) &&
                this.password.equals(order.password);
    }
}
