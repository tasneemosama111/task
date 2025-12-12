package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.swaglabs.Utils.ElementActions.findElement;

public class Scrolling {
private Scrolling(){

}
@Step("scrolling to element :{locator}")
//scroll to element
    public static void  scrollRoElement(WebDriver driver , By locator){
       //code
        LogsUtil.info("scrolling to element" , locator.toString());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" , findElement(driver,locator));
    }


}
