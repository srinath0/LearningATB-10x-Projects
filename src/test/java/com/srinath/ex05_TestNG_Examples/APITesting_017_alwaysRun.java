package com.srinath.ex05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_017_alwaysRun {
    @Test(enabled = false)
    public void test01(){
        Assert.assertTrue(true);
    }
    @Test(alwaysRun = true,enabled = false)
    public void test02(){
        Assert.assertTrue(true);
    }
    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
