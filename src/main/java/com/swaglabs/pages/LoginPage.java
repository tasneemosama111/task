package com.swaglabs.pages;

import com.swaglabs.Utils.BrowserActions;
import com.swaglabs.Utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private  WebDriver driver;
    //locators

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By LoginBtn = By.id("login-button");
    private final By errorMssg = By.cssSelector("[data-test=\"error\"]");



    //constructor
     public LoginPage(WebDriver driver){
         this.driver = driver;
     }


     @Step("navigating to login page")
    //kol page el ahsan tebda2 b navigation and ends with assertion
    public void navigateToLoginPage(){
         BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }

    //Actions

    @Step("entering usename")
    // kol line gwah wait - scroll- find -send/click f satr wahed using elementactions class
    public LoginPage enterUserName(String Username){
        ElementActions.sendData(driver,username ,Username );
        return this;
    }
    @Step("entering password")

    public LoginPage enterPassword(String Password){
        ElementActions.sendData(driver,password , Password);
        return this;

    }
    @Step("clicking on login button")
    public LoginPage click(){
        ElementActions.clickOnElement(driver , LoginBtn);
        return this;
    }
//getter
    @Step("get error message")
    //get error message law mawgoda
    public String getErroMssg(){
         return ElementActions.getText(driver,errorMssg);
    }

}
