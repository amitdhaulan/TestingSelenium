package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObjects {

    public loginPageObjects() {
        WebDriver driver = BaseClass.getDriver();
    }


    @FindBy(xpath="//div[@class='login_logo']")
    private static WebElement logo;

    @FindBy(id="user-name")
    private static WebElement userName;

    @FindBy(id="password")
    private static WebElement password;

    @FindBy(id="login-button")
    private static WebElement loginButton;



    public static WebElement getLogo(){
        return logo;
    }

    public static WebElement getUserName(){
        return userName;
    }

    public static WebElement getPassword(){
        return password;
    }

    public static WebElement getLoginButton(){
        return loginButton;
    }
}
