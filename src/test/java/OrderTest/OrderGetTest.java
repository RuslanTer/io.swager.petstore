package OrderTest;

import factoryes.OrderFactory;
import factoryes.PetFactory;
import io.restassured.RestAssured;
import models.Auth;
import models.Order;
import models.Pet;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class OrderGetTest {
    public Pet cat;
    public Order cat_order;

    @Before
    public void Init() {
        this.cat = new PetFactory().createRandomPet();
        this.cat_order = new OrderFactory().createRandomOrder(cat.id);
    }


    @Test
    public void TestGetOrder() {
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
        Order cat_order_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/store/order/{pet1.id}", this.cat_order.id)
                .then()
                .assertThat()
                .extract()
                .as(Order.class);
        assertThat(cat_order_result, Matchers.equalTo(cat_order));

    }
}
