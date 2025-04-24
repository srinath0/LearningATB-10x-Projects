package com.srinath.ex_07_PayLoadManagement.gson;


import com.google.gson.Gson;
import com.srinath.ex_07_PayLoadManagement.ManualPayLoad.BookingDates_0;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class APITesting_026_RestAssured_GSON {
    //GSON - is google Lib -- which will convert your class to JSON
    // JSON to class
    // JSON - is a plain text in key and value pair to transfer from client to server.
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_Create_Booking_Positive(){
        Booking booking = new Booking();
        booking.setFirstname("srinath");
        booking.setLastname("keshetti");
        booking.setTotalprice(980);
        booking.setDepositpaid(true);
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/").basePath("/booking").contentType(ContentType.JSON).body(jsonStringBooking).log().all();
        response= r.when().post();
        String jsonResponseString = response.asString();
        vr=response.then().log().all();
        vr.statusCode(200);


        //Case1-Direct extraction
        String firstname1=response.then().extract().path("booking.firstname");
        System.out.println(firstname1);
        Assert.assertEquals(firstname1,"srinath");

        assertThat(firstname1).isNotNull().isNotEmpty().isEqualTo("srinath");


        /// Case2--jsonPath.getString("")

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);

        String jsonResponseString1 = response.asString();

        //Case3-DeSerialization
        //Response - De Ser another Response Class
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString1,BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("srinath").isNotNull().isNotEmpty();
    }
}
