package com.itgirls.testsuite;

import com.itgirls.FW.common.Constants;
import com.itgirls.FW.common.utilities.ConfigUtil;
import com.itgirls.FW.common.utilities.JsonUtil;
import com.itgirls.FW.pages.LoginPage;
import com.itgirls.testsuite.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.itgirls.FW.common.PageManager.getLoginPage;
import static com.itgirls.FW.common.PageManager.getProductsPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginValidData")
    public Object[][] loginValidData() {
        return JsonUtil.getJSONTestData("loginWithValidInfo", this.getClass());
    }

    @Test(dataProvider = "loginValidData")
    public void loginWithValidInfo(String username, String password) {
        LoginPage loginPage = getLoginPage();
        loginPage.navigateTo(ConfigUtil.getPropertiesValue(Constants.URL));
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(getProductsPage().isProductsTitleDisplayed());
    }
}
