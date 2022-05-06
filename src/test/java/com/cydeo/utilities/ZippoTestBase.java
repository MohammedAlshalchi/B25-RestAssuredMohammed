package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ZippoTestBase {



    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI ="https://api.zippopotam.us/";
    }





    @AfterAll
    public static void close() {
        DBUtils.destroy();


    }
}
