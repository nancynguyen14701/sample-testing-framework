package com.itgirls.FW.pages;

import com.itgirls.FW.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(className = "title")
    private WebElement title;

    public ProductsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isProductsTitleDisplayed() {
        return isElementPresent(title);
    }

}
