package com.srinath.ex06_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.testng.asserts.SoftAssert;

public class APITesting_020_RA_DefaultAssertions {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;

    String Token;
    Integer BookingId;
    @Test
    public void test_POST(){
        String PayLoad = "{\n" +
                "    \"firstname\": \"srinath\",\n" +
                "    \"lastname\": \"keshetti\",\n" +
                "    \"totalprice\": 980,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/booking").contentType(ContentType.JSON).body(PayLoad).log().all();
        response = r.when().post();
        //Default Assertion
        vr = response.then().log().all().statusCode(200);
        //Rest Assured -> import org.hamcrest.Matchers; Special Library for Assertions
        vr.body("booking.firstname",Matchers.equalTo("srinath"));
        vr.body("booking.lastname",Matchers.equalTo("keshetti"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid",Matchers.notNullValue());
        BookingId = response.then().extract().path("bookingid");

//
//        /// T
//        String firstname = response.then().extract().path("booking.firstname",srinath);
//        String lastname = response.then().extract().path("booking.lastname",keshetti);
//        Assert.assertNotNull(bookingid);
//        Assert.assertEquals(firstname,"srinath");
//        Assert.assertEquals((lastname,"keshetti"));
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(firstname,"srinath");
//        softAssert.assertAll();
    }
}
