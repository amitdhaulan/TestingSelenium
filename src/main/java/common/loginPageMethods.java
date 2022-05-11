package common;

import org.openqa.selenium.support.PageFactory;

public class loginPageMethods {
    public void login(){

        loginPageObjects profilePg = PageFactory.initElements(BaseClass.getEventDriver(), loginPageObjects.class);

        profilePg.getUserName().sendKeys("standard_user");
        profilePg.getPassword().sendKeys("secret_sauce");
        profilePg.getLoginButton().click();
    }
}
