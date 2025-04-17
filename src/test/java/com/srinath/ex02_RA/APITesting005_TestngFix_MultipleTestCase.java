package com.srinath.ex02_RA;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting005_TestngFix_MultipleTestCase {
    @Test
    @Description("Verify that the post code gives 200 OK")
    public void test_GET_Positive_TC1() {
        RestAssured
                .given()
                .baseUri("https://api.zippoptam.us")
                .basePath("/IN/110001")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    @Description("Verify that Invalid Pincode given by you")
    public void test_GET_Negative_TC2() {
        RestAssured
                .given()
                .baseUri("https://api.zippoptam.us")
                .basePath("/IN/"+"-010048")
                .when()
                .get()
                .then()
                .log().all().statusCode(404);
    }

    @Test
    @Description("Verify that Invalid code of Pincode")
    public void test_GET_Negative_TC3() {
        RestAssured
                .given()
                .baseUri("https://api.zippoptam.us")
                .basePath("/IN/"+"$")
                .when()
                .get()
                .then()
                .log().all().statusCode(404);
    }
}

