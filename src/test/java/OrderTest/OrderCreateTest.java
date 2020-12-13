package OrderTest;
import factoryes.PetExtendFactory;
import factoryes.PetFactory;
import factoryes.OrderFactory;
import io.qameta.allure.AllureId;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import models.Auth;
import models.Category;
import models.Pet;
import models.Order;
import models.Tag;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderCreateTest {
    public Pet cat;
    public Order cat_order;

    @Before
    public void Init() {
        this.cat = new PetFactory().createRandomPet();
        this.cat_order = new OrderFactory().createRandomOrder(cat.id);
    }


    @Test
    public void TestCreateOrder() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(this.cat.id))
                .body("name", Matchers.equalTo(this.cat.name));

        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat_order)
                .when()
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(this.cat_order.id))
                .body("petId", Matchers.equalTo(this.cat.id));
    }
    @Test
    public void TestCreateNotValidOrder() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(this.cat.id))
                .body("name", Matchers.equalTo(this.cat.name));

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
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .assertThat()
                .statusCode(400);
    }

}
