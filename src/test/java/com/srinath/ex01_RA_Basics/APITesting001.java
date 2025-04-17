package com.srinath.ex01_RA_Basics;

import io.restassured.RestAssured;

public class APITesting001 {
    public static void main(String[] args){
    //Gherkins Syntax
    // Given() -> Pre requisite
    // When() -> HTTP Methods
    //Then() -> Validate All Methods
    RestAssured.
            given()
            .baseUri("https://api.zippopotam.us")
    .basePath("/IN/600097")
    .when()
    .get()
    .then().log().all().statusCode(201);
}
}
