package common;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.FileNotFoundException;
import static common.BaseClass.loadProperty;
import static common.BaseClass.properties;

public class loginPageMethods {
    public void login() throws FileNotFoundException {

        loginPageObjects loginPageObjects = PageFactory.initElements(BaseClass.getDriver(), loginPageObjects.class);

        Select dropDown = new Select(loginPageObjects.selectValue());
        dropDown.selectByVisibleText("301Squad");

        loadProperty();

        loginPageObjects.getUserName().sendKeys(properties.getProperty("username"));
        loginPageObjects.getPassword().sendKeys(properties.getProperty("password"));
        loginPageObjects.getLoginButton().click();
    }
}
