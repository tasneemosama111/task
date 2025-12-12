package com.swaglabs.Utils;


import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {

public static CustomSoftAssertion  softAssertion = new CustomSoftAssertion();
public static void customAssertAll(){
    try {
        softAssertion.assertAll("custom soft assertion");
    }
    catch (Exception e){
        System.out.println("custom soft assertion failed");
    }
}

}
