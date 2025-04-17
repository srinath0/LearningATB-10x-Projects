package com.srinath.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_008_RestfulBooker_CreateToken {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the POST Request")
    @Test
    public void POST_request_CreateToken(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r= RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                        r.basePath("/auth");
                        r.contentType(ContentType.JSON);
                        r.body(payload);
                        response = r.when().log().all().post();
                        vr = response.then().log().all().statusCode(200);

    }

}
