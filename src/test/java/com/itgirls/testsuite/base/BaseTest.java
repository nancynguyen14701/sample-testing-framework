package com.itgirls.testsuite.base;

import com.itgirls.FW.driver.DriverFactory;
import com.itgirls.FW.utilities.AbstractLog;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends AbstractLog {
    String sBrowser;
    @BeforeTest
    public void initializeDriver(){
        DriverFactory.createNewBrowserSession(System.getProperty("browser"));
        logger.info("This is before test log");
        logger.fatal("This is before test log");
        logger.error("This is before test log");
    }

    @AfterTest
    public void cleanTest(){
        DriverFactory.getDriver().quit();
    }

}
