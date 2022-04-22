package com.cydeo.day4;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

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



}
