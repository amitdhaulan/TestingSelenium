package selenium.test;

import common.BaseClass;
import common.leadPageMethods;
import common.loginPageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class Swag_Labs extends BaseClass {

    public Swag_Labs() throws FileNotFoundException {
    }

    @Test
    public void openSwagLabs() throws IOException, InterruptedException {

        loginPageMethods loginPageMethods = new loginPageMethods();
        leadPageMethods leadPageMethods = new leadPageMethods();

        //Login to the application
        loginPageMethods.login();

        //Navigate to Lead > Baltimore
        leadPageMethods.clickLead();
        leadPageMethods.clickBootStrap();

        //Get follow id
        explicitWait(common.leadPageObjects.getLeadsTable());
        String follow_id_actual = leadPageMethods.getFollowId();

        //Click open button of first row
        explicitWait(common.leadPageObjects.getLeadsTable());
        leadPageMethods.clickOpenButton();

        explicitWait(common.leadPageObjects.getCrossButton());
        Thread.sleep(1000);

        String follow_id_name = leadPageMethods.getFollowId_name(follow_id_actual);

        System.out.println("follow_id_name --------> "+follow_id_name);

        String expected = follow_id_name.substring(0,follow_id_actual.length()+1);

        //Validating opened lead is the same as the clicked one
        Assert.assertEquals(follow_id_actual.trim(),expected.trim());

   }
}