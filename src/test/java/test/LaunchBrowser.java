package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver driver;
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverRelativePath = "/src/test/resources/chromedriver";
        String chromeDriverLocation = currentProjectLocation.concat(chromeDriverRelativePath);

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();

        driver.get("https://shopee.vn/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
           // Ignore system exception
        }

        driver.quit();
    }
}
