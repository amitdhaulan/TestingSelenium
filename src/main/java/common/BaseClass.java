package common;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    Logger log;
    public static WebDriver driver = null;
    static Properties properties;
    static BufferedReader reader;
    static String propertyFilePath="";

    public BaseClass() throws FileNotFoundException {
        BasicConfigurator.configure();
        log = LogManager.getLogger(BaseClass.class);
        loadProperty();
        driver = new ChromeDriver(setChromeOptions());
        driver.get(getApplicationUrl());
        log.info(driver.getTitle() + " Launched");
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

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public ChromeOptions setChromeOptions(){
        System.setProperty(
                properties.getProperty("driverInformartion"),
                getDriverPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        //        options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("networkConnectionEnabled");

        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
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
}
