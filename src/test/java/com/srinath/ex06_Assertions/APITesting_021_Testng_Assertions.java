package com.srinath.ex06_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_021_Testng_Assertions {
    //Testng Assertions
    //Hard Assertion
    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the Program");
        Boolean is_srinath_female=false;
        Assert.assertEquals("srinath","srinath");
        System.out.println("End of the Program");
    }
    //Soft Assertion
    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("start of the check");
        softAssert.assertTrue(true);
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
