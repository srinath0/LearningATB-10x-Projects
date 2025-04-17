package com.srinath.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011RestfulBookerPUTRequest {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the PUT Request details Updated")
    @Test
    public void PUT_Request() {
        String Token = "df8a2193ca39b89";
        String bookingid = "2391";
        String payload = "{\n" +
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

        r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking/" + bookingid)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Cookie", "token=" + Token)
                .body(payload)
                .log().all();
        //.auth().preemptive().basic("admin", "password123");


        response = r.when().put();
        vr = response.then().log().all().statusCode(200);
    }
}
