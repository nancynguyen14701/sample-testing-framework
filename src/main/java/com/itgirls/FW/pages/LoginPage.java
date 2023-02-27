package com.itgirls.FW.pages;

import com.itgirls.FW.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final String username = "id:user-name";
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void inputUsername(String usernameValue) {
        inputText(usernameValue, getElement(username));
        logger.info("Username inputted");
    }

    public void inputPassword(String passwordValue) {
        inputText(passwordValue, password);
        logger.info("Password inputted");
    }

    public void clickLoginButton() {
        clickElement(loginBtn);
        logger.info("Clicked login");
    }
}
