package com.itgirls.testsuite.base;

import com.itgirls.FW.driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    String sBrowser;
    @BeforeTest
    public void initializeDriver(){
        DriverFactory.createNewBrowserSession(System.getProperty("browser"));
    }

    @AfterTest
    public void cleanTest(){
        DriverFactory.getDriver().quit();
    }

}
