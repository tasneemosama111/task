package com.swaglabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class BrowserFactory {
    // elclass ely hkhtar anhe browser hashtghal 3aleh w h3mel fl function switch cases
    public static WebDriver getBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case "edge":
                EdgeOptions Edgeoptions = getEdgeOptions();
                return new EdgeDriver(Edgeoptions);

            case "firefox" :
                FirefoxOptions FireFoxOptions = getFirefoxOptions();
                return new FirefoxDriver(FireFoxOptions);

            default:
                ChromeOptions options = getChromeOptions();
                return new ChromeDriver(options);
        }
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions FireFoxOptions = new FirefoxOptions();

        FireFoxOptions.addArguments("--start-maximized");         // Start browser maximized
        FireFoxOptions.addArguments("--incognito");              // Private mode
        FireFoxOptions.addArguments("--disable-notifications");  // Disable notifications
        FireFoxOptions.addArguments("--disable-popup-blocking"); // Disable popup blocking
        FireFoxOptions.addArguments("--disable-extensions");     // Disable extensions
        FireFoxOptions.addArguments("--disable-infobars");       // Removes “Chrome is being controlled” msg
        FireFoxOptions.addArguments("--remote-allow-origins=*"); // Allow remote origins (common fix)
        FireFoxOptions.addArguments("--headless=new");            // Run headless
        FireFoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        FireFoxOptions.setAcceptInsecureCerts(true);
        return FireFoxOptions;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");         // Start browser maximized
        options.addArguments("--incognito");              // Private mode
        options.addArguments("--disable-notifications");  // Disable notifications
        options.addArguments("--disable-popup-blocking"); // Disable popup blocking
        options.addArguments("--disable-extensions");     // Disable extensions
        options.addArguments("--disable-infobars");       // Removes “Chrome is being controlled” msg
        options.addArguments("--remote-allow-origins=*"); // Allow remote origins (common fix)
        options.addArguments("--headless=new");           // Run headless

        // b3mel map Using Chrome preferences in Selenium w de bhelp disable browser popups, password save prompts, and autofill to keep tests stable and distraction-free.
        Map<String , Object> prefs = Map.of("profile.default_content_setting_values.notifications", 2 ,
                "credentials_enable_service", false ,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false);
        options.setExperimentalOption("prefs" , prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions Edgeoptions = new EdgeOptions();
        Edgeoptions.addArguments("--start-maximized");         // Start browser maximized
        Edgeoptions.addArguments("--incognito");              // Private mode
        Edgeoptions.addArguments("--disable-notifications");  // Disable notifications
        Edgeoptions.addArguments("--disable-popup-blocking"); // Disable popup blocking
        Edgeoptions.addArguments("--disable-extensions");     // Disable extensions
        Edgeoptions.addArguments("--disable-infobars");       // Removes “Chrome is being controlled” msg
        Edgeoptions.addArguments("--remote-allow-origins=*"); // Allow remote origins (common fix)
        Edgeoptions.addArguments("--headless=new");           // Run headless

        Map<String , Object> edgePref = Map.of("profile.default_content_setting_values.notifications", 2 ,
                "credentials_enable_service", false ,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false);
        Edgeoptions.setExperimentalOption("prefs" ,edgePref);
        Edgeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return Edgeoptions;
    }
}
