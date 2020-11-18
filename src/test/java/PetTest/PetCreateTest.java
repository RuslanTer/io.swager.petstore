package PetTest;

import factoryes.PetExtendFactory;
import factoryes.PetFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import models.Auth;
import models.Category;
import models.Pet;
import models.Tag;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetCreateTest {
    public Pet cat;
    public Pet dog;
    public Pet cat_extendent;

    @Before
    public void Init() {
        this.cat = new PetFactory().createRandomPet();
        this.dog = new PetFactory().createRandomPet();
        this.cat_extendent = new PetExtendFactory().createRandomPet();
    }


    @Test
    public void TestCreatePet() {

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
                .body(this.dog)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(this.dog.id))
                .body("name", Matchers.equalTo(this.dog.name));
    }

    @Test
    public void TestCreateExtendPet() {
        Pet cat_extended_response = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat_extendent)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(cat_extended_response, Matchers.equalTo(cat_extendent));
    }
}
