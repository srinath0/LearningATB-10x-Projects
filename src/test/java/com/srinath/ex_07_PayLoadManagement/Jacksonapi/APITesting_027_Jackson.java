package com.srinath.ex_07_PayLoadManagement.Jacksonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.srinath.ex_07_PayLoadManagement.ToolPayLoad.Bookingdates;
import com.srinath.ex_07_PayLoadManagement.gson.BookingResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class APITesting_027_Jackson {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Create_Booking_Positive() {
        Booking booking = new Booking();
        booking.setFirstname("srinath");
        booking.setLastname("keshetti");
        booking.setTotalprice(980);
        booking.setDepositpaid(true);
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(Bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);

        String jsonStringBooking;
        ObjectMapper Mapper = new ObjectMapper();
        try{
           jsonStringBooking = Mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
        System.out.println(jsonStringBooking);

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/").basePath("/booking").contentType(ContentType.JSON).body(jsonStringBooking).log().all();
        response= r.when().post();
        String jsonResponseString = response.asString();
        vr=response.then().log().all();
        vr.statusCode(200);

        String firstname1=response.then().extract().path("booking.firstname");
        System.out.println(firstname1);


        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);
        BookingResponse bookingResponse = null;
        try{
            bookingResponse = Mapper.readValue(response.asString(),BookingResponse.class);
        }
        catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking()).getFirstname().isEqualto("srinath");

    }
}
