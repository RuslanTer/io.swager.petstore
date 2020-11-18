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

public class PetUpdateTest {
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
    public void TestUpdatePet(){
        RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200);

        this.cat = new PetFactory().createRandomPet();
        Pet cat_result = RestAssured.given()
                .header("api_key", String.valueOf(new Auth().api_key))
                .contentType("application/json")
                .body(this.cat)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        assertThat(cat_result, Matchers.equalTo(this.cat));



    }
}
