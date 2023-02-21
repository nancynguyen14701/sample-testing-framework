package com.itgirls.FW.pages.base;

import com.itgirls.FW.driver.DriverFactory;
import com.itgirls.FW.pages.LoginPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageManager {
    private static LoginPage loginPage;

    public static ICommonPage getInstance(ICommonPage iPage, String className){
        try{
            if (iPage == null || !iPage.getDriver().equals(DriverFactory.getDriver())){
                iPage = (ICommonPage) Class.forName(className).getConstructor(RemoteWebDriver.class).newInstance(DriverFactory.getDriver());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return iPage;
    }

    public static LoginPage getLoginPage(){
        loginPage = (LoginPage) getInstance(loginPage, LoginPage.class.getName());
        return loginPage;
    }


}
