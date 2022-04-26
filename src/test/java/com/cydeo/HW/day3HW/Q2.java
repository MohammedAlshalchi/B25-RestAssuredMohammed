package com.cydeo.HW.day3HW;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q2 extends HrTestBase {
    /*
    Q2:
- Given accept type is Json
- Query param value - q={"department_id":80}
- When users sends request to /employees
- Then status code is 200
- And Content - Type is Json
- And all job_ids start with 'SA'
- And all department_ids are 80
- Count is 25
     */

    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"department_id\":80}")
                .when().get("/employees");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));

        JsonPath jsonPath = response.jsonPath();
        //all job_ids start with 'SA'
        List<String> jobIDStartWithSA = jsonPath.getList("items.findAll {it.job_id.startsWith(\"SA\")}.job_id");
        System.out.println("jobIDStartWithSA = " + jobIDStartWithSA);

        for (String s : jobIDStartWithSA) {
            assertEquals(true,s.startsWith("SA"));
        }

        //all department_ids are 80
        List<Integer> department_ids = jsonPath.getList("items.findAll {it.department_id == 80}.department_id");
        System.out.println("department_ids = " + department_ids);
        for (Integer each : department_ids) {
            assertEquals(80,each);
        }

        //Count is 25
        int count = response.path("count");
        System.out.println("count: "+count);
        assertEquals(25,count);

    }



}
