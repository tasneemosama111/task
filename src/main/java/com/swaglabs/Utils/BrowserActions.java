package com.swaglabs.Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {

    }


    @Step("navigate to url : {URL}")
    public static void navigateToURL(WebDriver driver, String URL) {
        driver.get(URL);
        LogsUtil.info("navigated to URL : " , URL);
    }
    @Step("getting current url")
    // this method will be string msh void l2nha hatgeb el url w mfrod terg3ha w lazem tb2a string to be able to use it in assertion so :
    public static String getCurrentURL(WebDriver driver) {
        LogsUtil.info(" current  URL : " , driver.getCurrentUrl());
       return driver.getCurrentUrl();

    }
    @Step("getting page title")
    //get page title
    public static String getPageTitle(WebDriver driver){
        LogsUtil.info("page title is  : " , driver.getTitle());
        return driver.getTitle();
    }

    @Step("refreshing the page")
    public static void rerfeshPage(WebDriver driver){
        driver.navigate().refresh();
        LogsUtil.info("refreshing the page");
    }
    @Step("closing the browser")
    public static void closeBrowser(WebDriver driver){
        LogsUtil.info("closing the browser");
        driver.quit();
    }
}
