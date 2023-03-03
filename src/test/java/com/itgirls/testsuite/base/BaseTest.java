package com.itgirls.testsuite.base;

import com.itgirls.FW.common.AbstractLog;
import com.itgirls.FW.common.Constants;
import com.itgirls.FW.common.DriverFactory;
import com.itgirls.FW.common.utilities.ConfigUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.itgirls.FW.common.Constants.Browser;
import static com.itgirls.FW.common.PageManager.getLoginPage;

public class BaseTest extends AbstractLog {
    @BeforeTest
    public void initializeDriver() {
        ConfigUtil.loadPropertiesFile();
        // valueOf() parses string CHROME to enum CHROME
        DriverFactory.createNewBrowserSession((Browser.valueOf(ConfigUtil.BROWSER_NAME)));
    }

    @BeforeMethod
    public void loadDefaultPage() {
        getLoginPage().navigateTo(ConfigUtil.getPropertiesValue(Constants.URL));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.info("Test case " + result.getMethod().getMethodName() + " finished\n");
    }

    @AfterTest
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }

}