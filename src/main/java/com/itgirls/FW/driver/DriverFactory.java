package com.itgirls.FW.driver;

import com.itgirls.FW.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverFactory {
    private static RemoteWebDriver driver;
    public static void createNewBrowserSession(String browser){
        switch(browser){
            case Constants.CHROME_BROWSER:
                driver = initChromeDriver();
                break;
            case Constants.FIREFOX_BROWSER:
                driver = initFirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private static RemoteWebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = setOptionsForChrome();
        return new ChromeDriver(options);
    }

    private static RemoteWebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = setOptionsForFirefox();
        return new FirefoxDriver(options);
    }

    private static ChromeOptions setOptionsForChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
    private static FirefoxOptions setOptionsForFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        return options;
    }
    public static RemoteWebDriver getDriver(){
        return driver;
    }
}
