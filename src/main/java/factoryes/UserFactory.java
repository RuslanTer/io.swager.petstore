package factoryes;
import models.*;
import org.apache.commons.lang3.RandomStringUtils;

public class UserFactory {
    public User createRandomUser(){
        int id = 1 + (int) (Math.random()*9999);
        String username = RandomStringUtils.randomAlphabetic(1,15);
        String email = RandomStringUtils.randomAlphabetic(1,15);
        String firstname = RandomStringUtils.randomAlphabetic(1,15);
        String lastname = RandomStringUtils.randomAlphabetic(1,15);
        String password = RandomStringUtils.randomAlphabetic(1,15);
        String phone = RandomStringUtils.randomAlphabetic(1,15);
        int status = 0;
        return new User(id, username, email ,firstname, lastname, password, phone, status);
    }
}
