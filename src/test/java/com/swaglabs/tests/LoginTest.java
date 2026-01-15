package com.swaglabs.tests;
import com.swaglabs.pages.*;
import com.swaglabs.drivers.*;
import com.swaglabs.Utils.*;
import com.swaglabs.Utils.BrowserActions;
import com.swaglabs.Utils.FilesUtils;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {
    //Variables
   //private WebDriver driver;
   //مبقاش ليه لزمة تحتفظي بـ driver variable في كل class
    //الـ driver خلاص بقى centralized in ThreadLocal وبتجيبيه في أي مكان بنفس الطريقة
    File allure_results =new File("test-outputs");

    //TESTS
    @Test
    public void SuccessfulLogin(){
        // hena 3amlt el fluent pattern that let me do "method chaining" ely bykhlenee acall aktr mn function mn el page class in the same line by putting the returntype of the function the classname that i want to return to it to take the next method w lazem akteb gwa el function de return this; if its in the same class as below:

        new LoginPage(DriverManagerUtils.getDriver()).enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .click()
                .assertSuccessfulLogin();

    }

    //configuration
    @BeforeSuite
   public void beforeSuite(){
        //code
        FilesUtils.deleteFiles(allure_results);
    }
    @BeforeMethod
    public void setUp(){
//        //akhod object mn chrome options 3shan akhod kam command meno
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        // de bhotha 3shan astna el website ykmel loading kolo instead of implicit wait
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        //a3mel intialize lldriver b no3 chromeDriver
//        driver = new ChromeDriver(options);
        DriverManagerUtils.createInstance("chrome");
        // 3amlt anonmynous object yndhly 3la el ogin page el class w ygeb el function bta3et navigate
        new LoginPage(DriverManagerUtils.getDriver()).navigateToLoginPage();
    }


    @AfterMethod
    public void tearDown(){
//        WebdriverFactory.quitDriver();
        BrowserActions.closeBrowser(DriverManagerUtils.getDriver());
    }

    @AfterClass
    public void afterClass(){
        AllureUtils.attachLogsToAllureReport();
    }
}

