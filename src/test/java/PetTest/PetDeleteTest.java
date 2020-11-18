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

public class PetDeleteTest {
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
    public void TestDeletePet(){
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200);


        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .delete("https://petstore.swagger.io/v2/pet/{pet1.id}", this.cat.id)
                .then()
                .assertThat()
                .statusCode(200);

        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet1.id}", this.cat.id)
                .then()
                .assertThat()
                .statusCode(404);
    }
}
