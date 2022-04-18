package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {


  String url = "http://18.205.117.23:8000/api/spartans" ;

   @Test
public void test1 (){

      Response response = RestAssured.get(url);
      System.out.println("response.statusCode() = " + response.statusCode());

response.prettyPrint();
       Assertions.assertEquals(200,response.statusCode());






   }




}
