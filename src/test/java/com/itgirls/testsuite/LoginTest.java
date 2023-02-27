package com.itgirls.testsuite;

import com.itgirls.FW.common.Constants;
import com.itgirls.FW.common.utilities.ConfigUtil;
import com.itgirls.FW.pages.LoginPage;
import com.itgirls.testsuite.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.itgirls.FW.common.PageManager.getLoginPage;
import static com.itgirls.FW.common.PageManager.getProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidInfo() {
        LoginPage loginPage = getLoginPage();
        loginPage.navigateTo(ConfigUtil.getPropertiesValue(Constants.URL));
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(getProductsPage().isProductsTitleDisplayed());
    }
}
