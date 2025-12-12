package com.swaglabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    // bn3mel constructor private 3shan nmna3 ay had y3mel instantiation ll class da
    private Waits(){

    }

    //present - visible - clickable
    // b3mel anomynous object ya tasneem w nhot fl parameter el driver + el locator ely 3amel el function de leh ely hwa mn no3 By :
    //b3mel el functions static 3shan lma andaha m7tgsh akhod object akhodha nafsha
    public static WebElement waitForElementPresent(WebDriver driver , By locator){

        LogsUtil.info(" waiting for element ro be present : " , locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver , By locator){

        LogsUtil.info(" waiting for element ro be visible : " , locator.toString());

        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {

                    WebElement element = waitForElementPresent(driver,locator);
                    // hena b3mel check law displayed w law la2 return null
                    return  element.isDisplayed() ? element : null;
                }
                );
    }

    public static WebElement waitForElementClickable(WebDriver driver , By locator){

        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->

                {
                    //condition
                    WebElement element2 = waitForElementVisible(driver,locator);
                    LogsUtil.info(" waiting for element ro be clickable : " , locator.toString());

                    //check law enabled 22dar akhod action 3aleh w law la2 arg3 b null
                    return element2.isEnabled() ? element2 : null;
                }
                );
    }



}
