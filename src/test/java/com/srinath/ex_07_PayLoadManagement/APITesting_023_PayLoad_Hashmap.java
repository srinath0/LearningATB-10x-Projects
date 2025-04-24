package com.srinath.ex_07_PayLoadManagement;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_023_PayLoad_Hashmap {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;

//    String PayLoad = "{\n" +
//            "    \"firstname\": \"srinath\",\n" +
//            "    \"lastname\": \"keshetti\",\n" +
//            "    \"totalprice\": 980,\n" +
//            "    \"depositpaid\": true,\n" +
//            "    \"bookingdates\": {\n" +
//            "        \"checkin\": \"2018-01-01\",\n" +
//            "        \"checkout\": \"2019-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\": \"Breakfast\"\n" +
//            "}";
@Test
    public void test_PUT(){
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "srinath");
        jsonBodyUsingMap.put("lastname", "keshetti");
        jsonBodyUsingMap.put("totalprice","900");
        jsonBodyUsingMap.put("depositpaid","false");

        Map<String,Object> bookingDatesMap= new LinkedHashMap();
        bookingDatesMap.put("check-in","2018-01-01");
        bookingDatesMap.put("check-out","2018-02-01");

        jsonBodyUsingMap.put("bookingDates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");
        System.out.println(jsonBodyUsingMap);
    }
}
