package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    // private cons 3shan mahdesh yakhod object ml class
    private ElementActions(){
    }


    @Step("sending data : {data} to the element :{locator} ")
    //sendkeys function + gwaha el andah 3la function el wait w el scrolling
   public static void sendData(WebDriver driver , By locator , String data){

        //andah 3al fun wait element lma tb2a visible
       Waits.waitForElementVisible(driver ,locator);
       //a3mel scroll leha bandah el class and then el function ely 3ayzaha menha
       Scrolling.scrollRoElement(driver, locator);
       //then send keys
       findElement(driver,locator).sendKeys(data);

       LogsUtil.info("data entered :" ,data , "in the field: " , locator.toString());

   }
//el step de 3shan yezhar fl report bshakl awda7
@Step("clicking on element :{locator}")
   //click
    public static void clickOnElement(WebDriver driver , By locator ){
        Waits.waitForElementVisible(driver , locator);
        Scrolling.scrollRoElement(driver,locator);
        findElement(driver,locator).click();
        LogsUtil.info("clicked on the element : " , locator.toString());

    }

    @Step("get text from element : {locator}")
    //getText
    public static String getText(WebDriver driver , By locator){

     Waits.waitForElementVisible(driver,locator);
     Scrolling.scrollRoElement(driver,locator);
        LogsUtil.info("getting text from :" , locator.toString(),"text : ",findElement(driver,locator).getText());
        return findElement(driver,locator).getText();


    }


    //find element
    public static WebElement findElement(WebDriver driver , By locator){

        LogsUtil.info("finding element :" ,locator.toString());
        return driver.findElement(locator);

    }


}
