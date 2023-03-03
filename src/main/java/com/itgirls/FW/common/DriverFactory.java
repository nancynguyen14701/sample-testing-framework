package com.itgirls.FW.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverFactory extends AbstractLog {
    private static List<RemoteWebDriver> driverList = new ArrayList<>();
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void createNewBrowserSession(Constants.Browser browser) {
        switch (browser) {
            case CHROME:
                initChromeDriver();
                break;
            case FIREFOX:
                initFirefoxDriver();
                break;
        }
        logger.info("Driver with sessionID:" + driver.get().getSessionId().toString() + " has been created");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private static void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = setOptionsForChrome();
        driver.set(new ChromeDriver(options));
        driverList.add(driver.get());
    }

    private static void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = setOptionsForFirefox();
        driver.set(new FirefoxDriver(options));
        driverList.add(driver.get());
    }

    private static ChromeOptions setOptionsForChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    private static FirefoxOptions setOptionsForFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
    }

    public static void closeAllDrivers() {
        logger.info("Total of web drivers: " + driverList.size());
        logger.info("Release all web drivers");
        for (RemoteWebDriver dv : driverList) {
            try {
                dv.close();
                dv.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driverList.clear();
    }
}
