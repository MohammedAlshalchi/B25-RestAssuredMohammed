package com.cydeo.HW.day3HW;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"region_id\":3}")
                .when().get("/countries");

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

        //Country_name are;
        //Australia,China,India,Japan,Malaysia,Singapore
        List<String> country_names = jsonPath.getList("items.country_name");
        System.out.println("country_names = " + country_names);

        List<String> expectedCountryNames = new ArrayList<>(Arrays.asList( "Australia", "China", "India", "Japan", "Malaysia", "Singapore"));
        System.out.println("expectedCountryNames = " + expectedCountryNames);

        assertEquals(expectedCountryNames,country_names);


    }


}
