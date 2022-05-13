package selenium.test;

import common.BaseClass;
import common.Validation;
import common.loginPageMethods;
import org.testng.annotations.Test;

public class Swag_Labs extends BaseClass {

    @Test
    public void openSwagLabs() {

        loginPageMethods loginPageMethods = new loginPageMethods();
        loginPageMethods.login();

        Validation.assertEquals("Validating user lands on Home Page","Swag Labs", getEventDriver().getTitle());
    }
}
