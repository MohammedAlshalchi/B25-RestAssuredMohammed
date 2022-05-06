package com.cydeo.HW.day11HW;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class Parameterized {
    // Write a parameterized test for this request
    // GET https://api.zippopotam.us/us/{state}/{city}
    /*
        "NY, New York",
        "CO, Denver",
        "VA, Fairfax",
        "VA, Arlington",
        "MA, Boston",
        "NY, New York",
        "MD, Annapolis"
     */
    //verify place name contains your city name
    //print number of places for each request

    @ParameterizedTest
    @CsvSource({"NY, New York City", "CO, Denver", "VA, Fairfax", "MA, Boston", "MD, Annapolis"})
    public void testLocations(String state, String city) {

        JsonPath jsonPath = given()
                .baseUri("https://api.zippopotam.us")
                .pathParam("state", state)
                .pathParam("city", city)
                .when()
                .get("/us/{state}/{city}")
                .then()
                .statusCode(200)
                .body("places.'place name'", everyItem(containsString(city)))
                .extract().response().jsonPath();

        List<String> placeNames = jsonPath.getList("places.'place name'");

        System.out.println("placeNames: " + placeNames.get(0));
        System.out.println("place size: " + placeNames.size());
    }



    @ParameterizedTest
    @CsvSource({"NY, New York",
            "CO, Denver",
            "VA, Fairfax",
            "VA, Arlington",
            "MA, Boston",
            "NY, New York",
            "MD, Annapolis"})

    public void cityName(String stateCode, String cityName) {
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://api.zippopotam.us/us/" + stateCode + "/" + cityName);


        Assertions.assertTrue(response.body().asString().contains(cityName));
        Assertions.assertEquals(response.statusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        List<String> map = jsonPath.getList("places.'place name'");
        System.out.println(map.size());
        String city = response.path("places[0].'place name'");
        System.out.println("city = " + city);
        Assertions.assertTrue(city.contains(cityName));
    }


}
