package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import models.Pet;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestPet {

    @Test
    public void petTest() {
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key", "asdasd1asgvvc")
                .body("{" +
                        "\"id\": 12305, " +
                        "\"name\": \"doggie\"," +
                        "\"photoUrls\": []," +
                        "\"tags\": []," +
                        "\"status\": \"available\"}")
                .when().post()
                .then()
                .body("id", Matchers.equalTo(12305));
    }

    @Test
    public void petModelTest() {
        Pet pet1 = new Pet(1, "dog");
        pet1.photoUrls = new String[] {"asdasdasd"};
        pet1.pet_status = Pet.status.available;
        RestAssured.given()
                .header("api_key", "asdasd1asgvvc")
                .contentType("application/json")
                .body(pet1)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .extract()
                .response()
                .prettyPrint();


        Pet pet2 = new Pet(2, "cat");
        RestAssured.given()
                .header("api_key", "asdasd1asgvvc")
                .contentType("application/json")
                .body(pet2)
                .when()
                .post("https://petstore.swagger.io/v2/pet");


        Pet pet_result = RestAssured.given()
                .header("api_key", "asdasd1asgvvc")
                .when()
                .get("https://petstore.swagger.io/v2/pet/{pet1.id}", pet1.id)
                .then()
                .assertThat()
                .extract()
                .as(Pet.class);
        pet_result.equals(pet1);

    }
}
