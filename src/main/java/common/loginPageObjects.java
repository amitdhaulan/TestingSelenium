package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObjects {

    @FindBy(xpath="//div[@class='login_logo']")
    private static WebElement logo;

    @FindBy(id="user-name")
    private static WebElement userName;

    @FindBy(id="password")
    private static WebElement password;

    @FindBy(id="login-button")
    private static WebElement loginButton;

    public WebElement getLogo(){
        return logo;
    }

    public WebElement getUserName(){
        return userName;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }
}
