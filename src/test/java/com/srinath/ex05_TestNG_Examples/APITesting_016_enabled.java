package com.srinath.ex05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_016_enabled {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }
    @Test
    public void test02(){
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void test03(){
        Assert.assertTrue(true);
    }
}
