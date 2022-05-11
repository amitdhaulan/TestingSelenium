package selenium.test;

import common.BaseClass;
import common.loginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Swag_Labs extends BaseClass {

    @Test
    public void openSwagLabs() {

        //Instantiating Login page using initElements()
        loginPageObjects profilePg = PageFactory.initElements(BaseClass.getDriver(), loginPageObjects.class);

        loginPageObjects.getUserName().sendKeys("standard_user");
        loginPageObjects.getPassword().sendKeys("secret_sauce");
        loginPageObjects.getLoginButton().click();
    }
}
