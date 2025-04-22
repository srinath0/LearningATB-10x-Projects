package com.srinath.ex05_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_011_Annoations {
    //PUT Request-
    //1. getToken
    //2. getBookingId
    //3. test_PUT
    //4. closeAllThings
    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingId(){ // Alphabetical preference
        System.out.println("2");
    }

    @Test
    public void PUT(){
        System.out.println("3");
    }
    @AfterTest
    public void closeAllThings(){
        System.out.println("4");
    }
}
