package com.srinath.ex05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_018_InvocationCount {
    @Test(invocationCount = 75)
    public void test00(){
        Assert.assertTrue(true);
        System.out.println("srinath");
    }
}
