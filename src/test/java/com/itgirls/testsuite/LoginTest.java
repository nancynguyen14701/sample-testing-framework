package com.itgirls.testsuite;

import com.itgirls.FW.pages.LoginPage;
import com.itgirls.FW.pages.base.PageManager;
import com.itgirls.testsuite.base.BaseTest;
import com.itgirls.FW.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.itgirls.FW.pages.base.PageManager.getLoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void test01() {
        getLoginPage().navigateTo("https://www.saucedemo.com/");
    }
}
