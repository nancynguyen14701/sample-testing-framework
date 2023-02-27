package com.itgirls.FW.pages.base;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends AbstractPage implements ICommonPage {
    private final RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @Override
    public void initElement() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public RemoteWebDriver getDriver() {
        return driver;
    }

}
