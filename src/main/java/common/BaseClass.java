package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Optional;

public class BaseClass {
    public BaseClass(){
        homePageObjects hmo = new homePageObjects();
        hmo.print();
        openBrowser();
    }

    public static void openBrowser(){
        System.setProperty(
                "webdriver.chrome.driver",
                "E:\\amit\\Java_programs\\TestingSelenium\\src\\main\\resources\\chromedriver.exe");

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