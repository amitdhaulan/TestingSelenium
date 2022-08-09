package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObjects {

    @FindBy(id="DBStoreId")
    private static WebElement companyDropDown;

    @FindBy(id="Email")
    private static WebElement userName;

    @FindBy(id="Password")
    private static WebElement password;

    @FindBy(id="btnsubmit")
    private static WebElement loginButton;

    public WebElement selectValue(){
        return companyDropDown;
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
