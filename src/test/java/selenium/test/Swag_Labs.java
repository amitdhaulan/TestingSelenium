package selenium.test;

import common.BaseClass;
import common.Validation;
import common.loginPageMethods;
import common.loginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/*@Listeners(common.Validation.class)*/
public class Swag_Labs extends BaseClass {

    @Test
    public void openSwagLabs() {

        loginPageMethods loginPageMethods = new loginPageMethods();
        loginPageMethods.login();

        Validation.assertEquals("Validating user lands on Home Page","Swag Labs", getEventDriver().getTitle());

    }
}
