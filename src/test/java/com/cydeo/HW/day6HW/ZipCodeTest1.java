package com.cydeo.HW.day6HW;

import com.cydeo.utilities.ZippoTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class ZipCodeTest1 extends ZippoTestBase {
    /*
  Given Accept application/json
And path zipcode is 22031
When I send a GET request to /us endpoint
Then status code must be 200
And content type must be application/json
And Server header is cloudflare
And Report-To header exists
And body should contains following information
    post code is 22031
    country  is United States
    country abbreviation is US
    place name is Fairfax
    state is Virginia
    latitude is 38.8604
     */








    @DisplayName("solution hamcrest chaining")
@Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("zipCode", 22031)
                .when().get("/us/{zipCode}")
                .then().statusCode(200).contentType("application/json")
                .header("Server", "cloudflare")
                .header("Report-To", notNullValue())
                .and().body("'post code'", is(22031+"" ),
                        "country", equalTo("United States"),
                        "'country abbreviation'", is("US"),
                        "places[0].'place name'", is("Fairfax"),
                        "places[0].state", is("Virginia"),
                        "places[0].latitude", is(38.8604 + ""))
                .extract().response();

        response.prettyPrint();

}

@DisplayName("solution with pojo")
    @Test
    public void test2(){




    }






}
