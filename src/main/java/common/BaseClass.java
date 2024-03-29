package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    Logger log;
    public static WebDriver driver = null;
    static Properties properties;
    static BufferedReader reader;
    static String propertyFilePath = "";
    ChromeOptions options;

    public BaseClass() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("----------------------------------------> driver "+driver);
//        driver.get(getApplicationUrl());
        driver.get("https://www.stubhub.com/houston-astros-houston-tickets-7-1-2022/event/105054103/?sections=691849&ticketClasses=3361&listingId=&listingQty=");

        System.out.println("----------------------------------------> "+driver.getTitle());
//        log.info(driver.getTitle() + " Launched");
    }

    public static void loadProperty() throws FileNotFoundException {
        propertyFilePath = ".\\src\\main\\resources\\configs\\Configuration.properties";
        reader = new BufferedReader(new FileReader(propertyFilePath));
        properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }*/

    public void implicitWait(String time) {
        String implicitlyWait = properties.getProperty(time);
        if (implicitlyWait != null)
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitlyWait), TimeUnit.SECONDS);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public void explicitWait(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByFromElement(webelement)));
    }

    public void fluentWait(String time) {
        String implicitlyWait = properties.getProperty(time);
        if (implicitlyWait != null)
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitlyWait), TimeUnit.SECONDS);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() throws FileNotFoundException {
        loadProperty();
        String url = properties.getProperty("url");
        System.out.println("----------------------------------------> URL "+url);
        if (url != null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public ChromeOptions setChromeOptions() {
        options = new ChromeOptions();
        /*options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("networkConnectionEnabled");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");*/
        return options;
    }

//    @AfterTest
//    public void shutDown() {
//        driver.close();
//        log.info("Closing the Browser");
//    }

    public static WebDriver getDriver() {
        return driver;
    }

    private By getByFromElement(WebElement element) {
        By by;
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)]", "$1" + "")).split(":");
        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }
}
