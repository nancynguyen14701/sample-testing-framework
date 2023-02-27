package com.itgirls.testsuite.base;

import com.itgirls.FW.common.AbstractLog;
import com.itgirls.FW.common.DriverFactory;
import com.itgirls.FW.common.utilities.ConfigUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.itgirls.FW.common.Constants.Browser;

public class BaseTest extends AbstractLog {
    String sBrowser;

    @BeforeTest
    public void initializeDriver() {
        ConfigUtil.loadPropertiesFile();
        // valueOf() parses string CHROME to enum CHROME
        DriverFactory.createNewBrowserSession((Browser.valueOf(ConfigUtil.BROWSER_NAME)));
    }

    @AfterTest
    public void cleanTest() {
        DriverFactory.getDriver().quit();
    }

}