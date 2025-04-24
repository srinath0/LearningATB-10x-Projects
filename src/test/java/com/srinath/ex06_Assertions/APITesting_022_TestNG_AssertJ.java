package com.srinath.ex06_Assertions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;
public class APITesting_022_TestNG_AssertJ {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;
@Test
    public void test_POST() {
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
        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/booking").contentType(ContentType.JSON).body(PayLoad).log().all();
        response = r.when().post();
        //Default Assertion
        vr = response.then().log().all().statusCode(200);
        vr.body("booking.firstname", Matchers.equalTo("srinath"));
        vr.body("booking.lastname",Matchers.equalTo("keshetti"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid",Matchers.notNullValue());
        bookingId = response.then().extract().path("bookingid");


        /// Testng Assertions-Hard Assertion
        String firstname = response.then().extract().path("booking.firstname","srinath");
        String lastname = response.then().extract().path("booking.lastname","keshetti");
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"srinath");
        Assert.assertEquals(lastname,"keshetti");

        //Soft Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname,"srinath");
        softAssert.assertAll();

        //AssertJ(3rd Party Library for Assertions)
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("srinath").isNotEmpty().isNotBlank();

    }
}

