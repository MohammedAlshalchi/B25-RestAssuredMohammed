package com.cydeo.HW.day3HW;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q3 extends HrTestBase {
    /*
 Q3:
- Given accept type is Json
-Query param value q= region_id 3
- When users sends request to /countries
- Then status code is 200
- And all regions_id is 3
- And count is 6
- And hasMore is false
- And Country_name are;
Australia,China,India,Japan,Malaysia,Singapore
     */


    @Test
    public void test3(){
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":3}")
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));
        //count is 6
        int count = response.path("count");

        JsonPath jsonPath = response.jsonPath();
        //all regions_id is 3
        List<Integer> region_ids = jsonPath.getList("items.findAll {it.region_id ==3}.region_id");
        for (Integer each : region_ids) {
            assertEquals(3,each);
        }

        //And hasMore is false
        boolean hasMore = jsonPath.getBoolean("hasMore");
        System.out.println("hasMore = " + hasMore);
        assertEquals(false,hasMore);

        //Country_name are;
        //Australia,China,India,Japan,Malaysia,Singapore
        List<String> country_names = jsonPath.getList("items.country_name");
        System.out.println("country_names = " + country_names);

        List<String> expectedCountryNames = new ArrayList<>(Arrays.asList( "Australia", "China", "India", "Japan", "Malaysia", "Singapore"));
        System.out.println("expectedCountryNames = " + expectedCountryNames);

        assertEquals(expectedCountryNames,country_names);


    }

    @Test
    public void testTESTpractice(){
 /*
 Q3:
- Given accept type is Json
-Query param value q= region_id 3
- When users sends request to /countries
- Then status code is 200
- And all regions_id is 3
- And count is 6
- And hasMore is false
- And Country_name are;
Australia,China,India,Japan,Malaysia,Singapore
     */

        Response response=  given()
                .accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":3}")
                .when()
                .get("/countries");
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

assertEquals(200,response.statusCode());
JsonPath jsonPath = response.jsonPath();

List<Integer> regions_id = jsonPath.getList("items.findAll {it.regions_id ==3}.region_id");
for (Integer each : regions_id){
    assertEquals(3,each);

}

int count = response.path("count");
        System.out.println("count = " + count);

        boolean hasMore = jsonPath.getBoolean("hasMore");
        System.out.println("hasMore = " + hasMore);
        assertEquals(false,hasMore);


        List<String>country_name = jsonPath.getList("items.country_name");
        System.out.println("country_name = " + country_name);


        List<String> expected = new ArrayList<>(Arrays.asList("Australia", "China", "India", "Japan", "Malaysia", "Singapore"));
        System.out.println("expected = " + expected);


        assertEquals(expected,country_name);
    }






@Test
public void tets3(){
        /*

- Given accept type is Json
-Query param value q= region_id 3
- When users sends request to /countries
- Then status code is 200
- And all regions_id is 3
- And count is 6
- And hasMore is false
- And Country_name are;
Australia,China,India,Japan,Malaysia,Singapore
         */

    Response response=  RestAssured.given().accept(ContentType.JSON).queryParam("q","{\"region_id\":3}").
            when().get("/countries").then().statusCode(200).body("items.region_id",everyItem(is(3)),"count",is(6),
                    "hasMore",equalTo(false),"items.country_name", hasItems("Australia", "China", "India", "Japan", "Malaysia", "Singapore")).extract().response();

    JsonPath jsonPath = response.jsonPath();
    List<Object> list = jsonPath.getList("items.country_name");
    System.out.println("list = " + list);


}













}
