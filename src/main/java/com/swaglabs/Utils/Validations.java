package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    @Step("assert equal")
    //assert equal
    public static void assertEqual( String actual , String expected , String message){
        Assert.assertEquals(actual, expected , message );
    }
    @Step("assert not equal")
    public static void assertNotEqual( String actual , String expected , String message){
        Assert.assertEquals(actual, expected , message );
    }
    @Step("assert true")
    public static void assertTrue(boolean condition , String message){
        Assert.assertTrue(condition, message);
    }
    @Step("assert not true ")
    public static void assertNotTrue(boolean condition , String message){
        Assert.assertTrue(condition, message);
    }
    @Step("assert the pageURL : {expected}")
    public static void assertPageUrl(WebDriver driver , String expected){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), expected);
    }
    @Step("assert the title: {expected")
    public static void assertTitle(WebDriver driver , String expected){
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }




}
