package io.swagger.petstore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestPet {
    @org.junit.Test
    public void petTest(){
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key","asdasd1asgvvc")
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
}
