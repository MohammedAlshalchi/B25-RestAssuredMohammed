package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanNecativeGetRequest {





    @BeforeAll
    public static void init (){
        RestAssured.baseURI = "http://18.205.117.23:8000";


    }




    @DisplayName("GET all spartans/negative")
    @Test
    public void test1 (){
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when().get("/api/spartans");

       //print the status code
        System.out.println("response.statusCode() = " + response.statusCode());


        //print the content type
        System.out.println("response.contentType() = " + response.contentType());

         //how to test API ?
        //verify status code is 200
        Assertions.assertEquals(200,response.statusCode());



        //verify content type is application json
        Assertions.assertEquals("application/json",response.contentType());

    }




 /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8;
    */



    @DisplayName("Get request with Accept XML individual Spartan")
@Test
    public void test2 (){

    Response response = RestAssured.given()
            .accept(ContentType.XML)
            .when().get("/api/spartans/10");


    System.out.println("response.statusCode() = " + response.statusCode());

    System.out.println("response.contentType() = " + response.contentType());


// verify status code
    Assertions.assertEquals(406,response.statusCode());


    // verify content type
Assertions.assertEquals("application/xml;charset=UTF-8",response.contentType());


}
























}
