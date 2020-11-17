package PetTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import models.Auth;
import models.Pet;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasePetTest {
    Pet cat = new Pet(1, "cat");
    Pet dog = new Pet(2, "dog");


    @Test
    public void TestCreatePet() {
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .body("id", Matchers.equalTo(this.cat.id))
                .body("name", Matchers.equalTo(this.cat.name));;

        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.dog)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .body("id", Matchers.equalTo(this.dog.id))
                .body("name", Matchers.equalTo(this.dog.name));
    }

    @Test
    public void TestGetPet() {
        Pet cat_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet1.id}", this.cat.id)
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(cat_result.id, Matchers.equalTo(this.cat.id));
        assertThat(cat_result.name, Matchers.equalTo(this.cat.name));

        Pet dog_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet2.id}", this.dog.id)
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(dog_result.id, Matchers.equalTo(this.dog.id));
        assertThat(dog_result.name, Matchers.equalTo(this.dog.name));
    }
}
