package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class loginPageObjects {

    @FindBy(xpath="//div[@class='login_logo']")
    private static WebElement logo;

    @FindBy(id="DBStoreId")
    private static WebElement dropDown;

    @FindBy(id="Email")
    private static WebElement userName;

    @FindBy(id="Password")
    private static WebElement password;

    @FindBy(id="btnsubmit")
    private static WebElement loginButton;


    @FindBy(xpath="//label[@class='btn btn-primary radiobuttongroup']")
    private static List<WebElement> bootstrap_menu;

    @FindBy(id="side-menu-calls")
    private static WebElement leads;


    public WebElement getLogo(){
        return logo;
    }

    public WebElement selectValue(){
        return dropDown;
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

    public List<WebElement> getBootStrap_menu(){
        return bootstrap_menu;
    }

    public WebElement getLead(){
        return leads;
    }
}
