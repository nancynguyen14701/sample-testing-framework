package com.itgirls.FW.common;

import com.itgirls.FW.pages.LoginPage;
import com.itgirls.FW.pages.ProductsPage;
import com.itgirls.FW.pages.base.ICommonPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageManager {
    private static LoginPage loginPage;
    private static ProductsPage productsPage;

    public static ICommonPage getInstance(ICommonPage iPage, String className) {
        try {
            if (iPage == null || !iPage.getDriver().equals(DriverFactory.getDriver())) {
                iPage = (ICommonPage) Class.forName(className).getConstructor(RemoteWebDriver.class).newInstance(DriverFactory.getDriver());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iPage;
    }

    /**
     * Assign singleton object to loginPage variables
     *
     * @return
     */
    public static LoginPage getLoginPage() {
        loginPage = (LoginPage) getInstance(loginPage, LoginPage.class.getName());
        return loginPage;
    }

    public static ProductsPage getProductsPage() {
        productsPage = (ProductsPage) getInstance(productsPage, ProductsPage.class.getName());
        return productsPage;
    }


}
