package com.cydeo.HW.day6HW;

import com.cydeo.pojo.StateCityPojo;
import com.cydeo.utilities.ZippoTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static io.restassured.RestAssured.given;

public class ZipCodeTest3 extends ZippoTestBase {
    /*
   Given Accept application/json
And path state is va
And path city is farifax
When I send a GET request to /us endpoint
Then status code must be 200
And content type must be application/json
And payload should contains following information
    country abbreviation is US
    country  United States
    place name  Fairfax
    each places must contains fairfax as a value
    each post code must start with 22
     */

    @DisplayName("solution hamcrest chaining")
    @Test
    public void test3A(){
      given()
              .accept(ContentType.JSON)
              .pathParam("state","va")
              .pathParam("city","fairfax")
              .when()
              .get("/us/{state}/{city}")
              .then()
              .statusCode(200)
              //.header("Content-Type","application/json")
              .contentType("application/json")

              .body("'country abbreviation'", is("US"),
                      "country", is("United States"),
                      "'place name'", is("Fairfax"),
                      "places.'place name'", everyItem(startsWith("Fairfax")),
                      "places.'post code'", everyItem(startsWith(22 + "")));

    }



    @DisplayName("solution with pojo")
    @Test
    public void tst3B(){

   Response response =  given()
              .accept(ContentType.JSON)
              .get("us/va/fairfax")
              .then()
              .statusCode(200)
              .and()
              .contentType("application/json")

              .extract().response();


        StateCityPojo stateCity = response.as(StateCityPojo.class);

        assertThat(stateCity.getCountryAbbreviation(),is("US"));
        assertThat(stateCity.getCountry(),is("United States"));
        assertThat(stateCity.getPlaceName(),is("Fairfax"));


        stateCity.getPlaces().forEach(p-> assertThat(p.getPlaceName(),containsString("Fairfax")));
        stateCity.getPlaces().forEach(p->assertThat(p.getPostCode(),startsWith("22")));





    }



}
