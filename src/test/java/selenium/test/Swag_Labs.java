package selenium.test;

import common.BaseClass;
import common.Validation;
import common.loginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/*@Listeners(common.Validation.class)*/
public class Swag_Labs extends BaseClass {

    @Test
    public void openSwagLabs() {

        //Instantiating Login page using initElements()
        loginPageObjects profilePg = PageFactory.initElements(BaseClass.getEventDriver(), loginPageObjects.class);

        profilePg.getUserName().sendKeys("standard_user");
        profilePg.getPassword().sendKeys("secret_sauce");
        profilePg.getLoginButton().click();

        Validation.assertEquals("Validating user lands on Home Page","Swag Labs", getEventDriver().getTitle());

    }
}
