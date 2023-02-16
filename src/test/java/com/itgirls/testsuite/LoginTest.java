package com.itgirls.testsuite;

import com.itgirls.testsuite.base.BaseTest;
import com.itgirls.FW.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test01() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }
}
