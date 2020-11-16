package io.swagger.petstore;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class TestPet {
    @org.junit.Test
    public void petTest(){
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key","asdasd1asgvvc")
                .body("{\n" +
                        "\"id\": "+0+",\n" +
                        "\"name\": \"kotik\",\n" +
                        "\"photoUrls\": [\"string\"],\n" +
                        "\"tags\": [],\n" +
                        "\"status\": \"pending\",\n" +
                        "}")
                .when().post()
                .then()
                .extract().response()
                .prettyPrint();
    }
}
