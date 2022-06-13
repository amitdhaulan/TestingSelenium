package common;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


public class BaseClass {

    public static WebDriver driver = null;
    static Properties properties;
    static BufferedReader reader;
    static String propertyFilePath = "";

    public BaseClass() throws FileNotFoundException {

        loadProperty();
        driver = new ChromeDriver(setChromeOptions());

        driver.get(getApplicationUrl());
        applyLog(getClass().toString(), "Application Launched");
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

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

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

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public ChromeOptions setChromeOptions() {
        System.setProperty(
                properties.getProperty("driverInformartion"),
                getDriverPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("networkConnectionEnabled");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("test-type");
        options.addArguments("enable-strict-powerful-feature-restrictions");
        options.addArguments("disable-geolocation");

        return options;
    }

    @AfterTest
    public void shutDown() {
        driver.close();
        applyLog(getClass().toString(), "Closing the Browser");
    }

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

    public static void applyLog(String className, String message) {
        Date date = new Date();
        System.out.println("");
        Logger log = Logger.getLogger(className);
        log.info(date + ": " + message);

    }
}