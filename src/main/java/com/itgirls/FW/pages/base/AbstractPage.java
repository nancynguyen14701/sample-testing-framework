package com.itgirls.FW.pages.base;

import com.itgirls.FW.common.AbstractLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AbstractPage extends AbstractLog {

    public RemoteWebDriver getDriver() {
        return null;
    }

    /**
     * Refresh the current browser session
     */
    public void refresh() {
        getDriver().navigate().refresh();
        logger.info("The Current Browser location was Refreshed");
    }

    public void navigateTo(String url) {
        getDriver().get(url);
        logger.info("Navigated to " + url);
    }

    /**
     * @return Returns the Current Page Title
     */
    public String getTitle() {
        String title = getDriver().getTitle();
        logger.info("Title of the page is: " + title);
        return title;
    }

    /**
     * @return Current Browser URL
     */
    public String getURL() {
        String url = getDriver().getCurrentUrl();
        logger.info("Current URL is: " + url);
        return url;
    }

    /**
     * input text into text box, wrapper of sendKeys() function
     */
    public void inputText(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * Navigate browser back
     */
    public void navigateBrowserBack() {
        getDriver().navigate().back();
    }

    /**
     * Navigate browser forward
     */
    public void navigateBrowserForward() {
        getDriver().navigate().back();
    }

    /***
     * Builds the By type with given locator strategy
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return Returns By Type
     */
    public By getByType(String locator) {
        By by = null;
        String locatorType = locator.split(":")[0];
        locator = locator.split(":")[1];
        try {
            switch (locatorType) {
                case "id":
                    by = By.id(locator);
                    break;
                case "name":
                    by = By.name(locator);
                    break;
                case "xpath":
                    by = By.xpath(locator);
                    break;
                case "css":
                    by = By.cssSelector(locator);
                    break;
                case "class":
                    by = By.className(locator);
                    break;
                case "tag":
                    by = By.tagName(locator);
                    break;
                case "link":
                    by = By.linkText(locator);
                    break;
                case "partiallink":
                    by = By.partialLinkText(locator);
                    break;
                default:
                    logger.info("Locator type not supported");
            }
        } catch (Exception e) {
            logger.info("By type not found with: " + locatorType);
        }
        return by;
    }

    /**
     * Builds The WebElement By given locator strategy
     *
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *                tag=>example, xpath=>//example, link=>example
     * @return WebElement
     */
    public WebElement getElement(String locator) {
        WebElement element = null;
        By byType = getByType(locator);
        try {
            element = getDriver().findElement(byType);
        } catch (Exception e) {
            logger.info("Element not found with: " + locator);
            e.printStackTrace();
        }
        return element;
    }

    /***
     *
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return
     */
    public List<WebElement> getElementList(String locator) {
        List<WebElement> elementList = new ArrayList<WebElement>();
        By byType = getByType(locator);
        try {
            elementList = getDriver().findElements(byType);
            if (elementList.size() > 0) {
                System.out.println("Element List found with: " + locator);
            } else {
                System.out.println("Element List not found with: " + locator);
            }
        } catch (Exception e) {
            System.out.println("Element List not found with: " + locator);
            e.printStackTrace();
        }
        return elementList;
    }

    /***
     * Check if element is present
     * @param locator locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return boolean if element is present or not
     */
    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForVisibleElement(WebElement element, int waitTimeOut) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTimeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
