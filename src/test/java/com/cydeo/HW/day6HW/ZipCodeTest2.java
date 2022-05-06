package com.cydeo.HW.day6HW;

import com.cydeo.utilities.ZippoTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ZipCodeTest2 extends ZippoTestBase {
    /*
   Given Accept application/json
And path zipcode is 50000
When I send a GET request to /us endpoint
Then status code must be 404
And content type must be application/json
     */


    @DisplayName("solution hamcrest chaining")
    @Test
    public void test2(){

        given()
                .accept(ContentType.JSON)
                .pathParam("zipCode", 50000)
                .when()
                .get("/us/{zipCode}")
                .then()
                .statusCode(404)
                .contentType("application/json");





    }



}
