package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePageObjects {

    @FindBy(xpath="//a[@href='https://demoqa.com']")
    private static WebElement application_logo;

    public WebElement get_applicationLogo(){
        return application_logo;
    }
}
