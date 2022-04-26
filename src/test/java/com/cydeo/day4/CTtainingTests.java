package com.cydeo.day4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class CTtainingTests {


    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="http://api.cybertektraining.com";
    }
//send a get request to student id 24103 as a path parameter and accept header application/json
    //verify status code=200
    // /content type=application/json;charset=UTF-8
    // /Content-Encoding = gzip
    //verify Date header exists
    //assert that
            /*
                firstName Karole
                batch 7
                major Master of Creative Arts
                emailAddress hassan.lebsack@hotmail.com
                companyName Legacy Integration Analyst
                street 6253 Willard Place
                zipCode 28524

                using JsonPath
             */

@Test
    public void test1 (){

    Response response = given()
            .accept(ContentType.JSON)
            .and()
            .pathParam("id",24103)
            .when()
            .get("/student/{id}");

//    System.out.println(response.statusCode());
//    System.out.println(response.contentType());
//    System.out.println(response.prettyPrint());


    assertEquals(200,response.statusCode());



    assertEquals("application/json;charset=UTF-8",response.contentType());


    assertEquals("gzip",response.header("Content-Encoding"));


   assertTrue(response.headers().hasHeaderWithName("Date"));


    JsonPath jsonPath = response.jsonPath();




}

}
