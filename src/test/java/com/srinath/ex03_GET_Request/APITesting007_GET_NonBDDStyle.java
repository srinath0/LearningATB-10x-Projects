package com.srinath.ex03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting007_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the TC1 GET request")
    @Test
     public void test_NonBDD_GET(){
         //Request Specification
         String pincode = "560048";

         r = RestAssured.given();
         r.baseUri("https://api.zippopotam.us");
         r.basePath("/IN/"+pincode);

         response = r.when().log().all().get();
         vr = response.then().log().all().statusCode(200);


     }
     @Description("Verify the TC2 get Negative")
     @Test
public void test_NonBDDStyleGET_negative(){
    String pincode = "-1";
         r = RestAssured.given();
         r.baseUri("https://api.zippopotam.us");
         r.basePath("/IN/"+pincode);

         response = r.when().log().all().get();
         vr = response.then().log().all().statusCode(404);
     }
}
