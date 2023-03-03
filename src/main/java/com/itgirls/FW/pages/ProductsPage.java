package com.itgirls.FW.pages;

import com.itgirls.FW.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(className = "title")
    private WebElement title;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductsPage(RemoteWebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickOnMenuButton() {
        clickElement(menuButton);
    }

    public void clickOnLogoutLink() {
        clickElement(logoutLink);
        logger.info("User logged out");
    }


    // Validations
    public boolean isProductsTitleDisplayed() {
        return isElementPresent(title);
    }

}
