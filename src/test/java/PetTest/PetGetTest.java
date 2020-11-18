package PetTest;

import factoryes.PetExtendFactory;
import factoryes.PetFactory;
import io.restassured.RestAssured;
import models.Auth;
import models.Pet;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetGetTest {
    public Pet cat;
    public Pet dog;
    public Pet cat_extended;

    @Before
    public void Init() {
        this.cat = new PetFactory().createRandomPet();
        this.dog = new PetFactory().createRandomPet();
        this.cat_extended = new PetExtendFactory().createRandomPet();
    }

    @Test
    public void TestGetPet(){
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200);


        Pet cat_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet1.id}", this.cat.id)
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(cat_result, Matchers.equalTo(cat));
    }

    @Test
    public void TestGetExtendedPet(){
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat_extended)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200);


        Pet cat_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet1.id}", this.cat_extended.id)
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(cat_result, Matchers.equalTo(cat_extended));
    }

}
