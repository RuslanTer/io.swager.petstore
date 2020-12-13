package UserTest;

import factoryes.UserFactory;
import io.restassured.RestAssured;
import models.Auth;
import models.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class UserDeleteTest {
    public User ivan;

    @Before
    public void Init() {
        this.ivan = new UserFactory().createRandomUser();
    }


    @Test
    public void TestDeleteUser() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.ivan)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo(String.valueOf(this.ivan.id)));

        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .delete("https://petstore.swagger.io/v2/user/{pet1.id}", this.ivan.username)
                .then()
                .assertThat()
                .statusCode(200);

    }
}
