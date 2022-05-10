package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;


public class BaseClass {
    public BaseClass() {
        openBrowser();
    }

    public void openBrowser() {
        System.setProperty(
                "webdriver.chrome.driver",
                ".\\src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--auto-open-devtools-for-tabs");
        WebDriver driver = new ChromeDriver(options);

        // Launch Website
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());
    }
}