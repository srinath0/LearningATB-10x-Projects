package com.srinath.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_009_RestfulBooker_GetBookingId {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the Booking id's")
@Test
    public void GET_Booking(){
        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking");
        response = r.when().log().all().get();
        vr = response.then().log().all();
    }
}
