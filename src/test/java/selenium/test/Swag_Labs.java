package selenium.test;

import common.BaseClass;
import common.leadPageMethods;
import common.loginPageMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Swag_Labs extends BaseClass {


    public Swag_Labs() throws FileNotFoundException {
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

        //Get follow id
        explicitWait(common.leadPageObjects.getLeadsTable());
        String follow_id = leadPageMethods.getFollowId();
        String actual = follow_id.trim();

        //Click open button of first row
        explicitWait(common.leadPageObjects.getLeadsTable());
        leadPageMethods.clickOpenButton();

        explicitWait(common.leadPageObjects.getCrossButton());
        String follow_id_name = leadPageMethods.getFollowId_name(follow_id);

        System.out.println("-----------------> follow_id "+follow_id.trim());
        System.out.println("-----------------> follow_id_name "+follow_id_name.trim());

        String expected1 = follow_id_name.substring(0,follow_id.length()+1);
        String expected  = expected1.trim();

        //Validating opened lead is the same as the clicked one
        Assert.assertEquals(actual,expected.trim());

   }
}