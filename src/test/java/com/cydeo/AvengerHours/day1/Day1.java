package com.cydeo.AvengerHours.day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Day1 {
    /*
     1. Send request to get all Spartans  and get me the status code
    2. get me headers for above request
    3. get me header value for Content-Type and Date
    4. get me all Spartans printed
    5. get me 7th spartan (2 different ways)
    6. get me Spartans name Allen
    7. get me all male Spartans
    8. get me the spartan that female and name has z
    9. get name, gender, phone separately of No.15 Spartans
    10. get me all Spartans and get 10st Spartan's name, 20st Spartans gender, 30st Spartans id.
     */







    String url= "http://18.205.117.23:8000/api/spartans";


    @Test
    public void test1(){

Response response = RestAssured
        .given()
        .accept(ContentType.JSON)
        .when()
        .get(url);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.headers() = " + response.headers());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
response.prettyPrint();
        System.out.println("response.body().prettyPrint() SECOND WAY = " + response.body().prettyPrint());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


    }



        @Test
        public void test2(){

                Response response = RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .when()
                        .get(url+"/7");


                response.prettyPrint();
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                Response response1 = RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .when()
                        .pathParam("id",7)
                        .get(url+"/{id}");
                response1.prettyPrint();

        }



@Test
        public void test3(){

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .queryParam("nameContains","Allen")
                .when()
                .get(url+"/search");
        response.prettyPrint();

}

@Test
        public void test4(){

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .queryParam("gender","Male")
                .when()
                .get(url+"/search");
        response.prettyPrint();
}



        @Test
        public void test5(){

                Response response = RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .when()
                        .queryParam("gender","Female")
                        .when()
                        .queryParam("nameContains","z")
                        .when()
                        .get(url+"/search");
                response.prettyPrint();
        }


        @Test
        public void test6(){

                Response response = RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .when()
                        .pathParams("id",15)
                        .when()
                        .get(url+"/{id}");

               // No.1 ===> path
                System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
                System.out.println("response.path(\"name\").toString() = " + response.path("gender").toString());
                System.out.println("response.path(\"name\").toString() = " + response.path("phone").toString());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                // second way ==> jsonpath
                JsonPath jsonPath = response.jsonPath();

                byte id = jsonPath.getByte("id");
                String name = jsonPath.getString("name");
                String gender = jsonPath.getString("gender");
                Long phone = jsonPath.getLong("phone");


                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("gender = " + gender);
                System.out.println("phone = " + phone);


        }

@Test
        public void test7 (){
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(url);

        System.out.println("response.path(\"name[9]\") = " + response.path("name[9]"));
        System.out.println("response.path(\"name[9]\") = " + response.path("gender[19]"));
        System.out.println("response.path(\"name[9]\") = " + response.path("id[29]"));


}



}
