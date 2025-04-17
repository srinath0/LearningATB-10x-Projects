package com.srinath.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class APITesting_010_RestfulBooker_POST_Request {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("Verfiy the Booking details and Update")
    @Test
    public void POST_Request(){
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/1708");
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(200);
    }
}
