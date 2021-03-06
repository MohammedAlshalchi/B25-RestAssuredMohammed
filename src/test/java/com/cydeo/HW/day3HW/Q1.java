package com.cydeo.HW.day3HW;

import com.cydeo.utilities.HrTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class Q1 extends HrTestBase {
    /*
    Q1:
- Given accept type is Json
- Path param value- US
- When users sends request to /countries
- Then status code is 200
- And Content - Type is Json
- And country_id is US
- And Country_name is United States of America
- And Region_id is 2
     */


  @Test
  public void test1() {

      Response response = given()
              .accept(ContentType.JSON)
              .and()
              .pathParam("id","US")
              .when()
              .get("/countries/{id}");

      assertEquals(200, response.statusCode());
      assertEquals("application/json", response.header("Content-Type"));


      JsonPath jsonPath = response.jsonPath();
      String country_id = jsonPath.getString("country_id");
      String country_name = jsonPath.getString("country_name");
      int region_id = jsonPath.getInt("region_id");

      assertEquals("US",country_id);
      assertEquals("United States of America", country_name);
      assertEquals(2,region_id);

  }

  @Test
    public void testTESTpractice(){
     Response response = given()
              .accept(ContentType.JSON)
              .and()
              .pathParam("id","US")
              .when()
              .get("/countries/{id}");

        System.out.println(response.statusCode());
      System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(response.header("Content-Type"));
      System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(response.contentType());
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(response.prettyPrint());

      assertEquals(200,response.statusCode());
assertEquals("application/json",response.contentType());


JsonPath jsonPath = response.jsonPath();
String country_id = jsonPath.getString("country_id");
String Country_name = jsonPath.getString("country_name");
int Region_id = jsonPath.getInt("region_id");




assertEquals("US",country_id);
assertEquals("United States of America",Country_name);
assertEquals(2,Region_id);

  }


    /*Given accept type is Json
   - Path param value- US
   - When users sends request to /countries
   - Then status code is 200
   - And Content - Type is Json
   - And country_id is US
   - And Country_name is United States of America
   - And Region_id is 2
        */
    @Test
    public void test1NEW(){
        RestAssured.given().accept(ContentType.JSON).
                pathParam("country_id","US").
                when().get("/countries/{country_id}").then().contentType("application/json").and().statusCode(200).and()
                .body("country_id",is("US"),"country_name",is("United States of America"),
                        "region_id",is(2));

    }


}
