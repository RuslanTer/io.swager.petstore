package UserTest;

import factoryes.UserFactory;
import io.restassured.RestAssured;
import models.Auth;
import models.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class UserCreateTest {
    public User ivan;

    @Before
    public void Init() {
        this.ivan = new UserFactory().createRandomUser();
    }


    @Test
    public void TestCreateUser() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.ivan)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo(String.valueOf(this.ivan.id)));

    }
    @Test
    public void TestCreateNotValidUser() {


        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body("{" +
                        "\"id\": 'asd', " +
                        "\"name\": \"doggie\"," +
                        "\"photoUrls\": []," +
                        "\"tags\": []," +
                        "\"status\": \"available\"}")
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .assertThat()
                .statusCode(400);
    }
}
