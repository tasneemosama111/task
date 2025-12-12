package com.swaglabs.drivers;
import com.swaglabs.Utils.LogsUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
public class DriverManagerUtils {

    // ely h3mel intialize ll drive fl class da bdal ma ykon mawgod fl before method
    //hn3mel thread local 3shan n3mel parlell execution 3shan admn eny a3mel only one instance intialized
    //so ThreadLocal is used to store a separate WebDriver instance for each test thread to enable safe parallel execution
    //code
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManagerUtils(){

    }
    @Step("Create driver instance on : {browserName}")
    //createInstance creates a WebDriver, stores it in ThreadLocal using setDriver, and then returns the same instance using getDriver so each thread has its own driver.
    // create instance method
    public static WebDriver createInstance(String browserName){
        //بينادي الـ factory اللي بتختار نوع  browser وترجع driver عادي
        WebDriver driver = BrowserFactory.getBrowser(browserName);
   //     LogsUtil.info("driver created on ", browserName);
        //بياخد الـ driver ويحطه في الـ ThreadLocal (عشان parallel execution)
        setDriver(driver);
       return getDriver();

    }

    //ThreadLocal uses set() to assign a driver to a specific thread
    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }
    //and get() to retrieve the same driver during test execution without interacting with other threads
    public static WebDriver getDriver(){
        if (driverThreadLocal.get() == null){
            //LogsUtil.error("driver is null");
            throw new RuntimeException("Driver is null");
        }
        return driverThreadLocal.get();
    }
}
