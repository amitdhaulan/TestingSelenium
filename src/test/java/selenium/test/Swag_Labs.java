package selenium.test;

import common.BaseClass;
import common.leadPageMethods;
import common.loginPageMethods;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Swag_Labs extends BaseClass {

    public Swag_Labs() throws FileNotFoundException {
        System.out.println("Swag_Labs.Swag_Labs");
    }

    @Test
    public void openSwagLabs() throws FileNotFoundException, InterruptedException {

        loginPageMethods loginPageMethods = new loginPageMethods();
        leadPageMethods leadPageMethods = new leadPageMethods();

        //Login to the application
        loginPageMethods.login();

        //Navigate to Lead>Baltimore
        leadPageMethods.clickLead();
        leadPageMethods.clickBootStrap();

    }
}