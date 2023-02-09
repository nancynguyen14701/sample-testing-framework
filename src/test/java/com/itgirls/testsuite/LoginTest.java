package com.itgirls.testsuite;

import com.itgirls.testsuite.base.BaseTest;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test01() {
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://www.saucedemo.com/");
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e){
//            // Ignore system exception
//        }
//        WebElement closeButton = driver.findElement(By.className("home-popup__close-button"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".home-popup__close-button"))));


        driver.quit();
    }
}
