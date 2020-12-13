import factoryes.UserFactory;
import io.restassured.RestAssured;
import models.Auth;
import models.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {

    @Test
    public void TestConnection() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/")
                .then()
                .assertThat()
                .statusCode(200);

    }
}
