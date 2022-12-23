package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://shopee.vn/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
           // Ignore system exception
        }

        driver.quit();
    }
}
