package selenium.test;

import com.google.common.collect.ImmutableMap;
import common.BaseClass;
import common.leadPageMethods;
import common.loginPageMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Swag_Labs extends BaseClass {

    public Swag_Labs() throws FileNotFoundException {
    }

    @Test(enabled = false)
    public void openSwagLabs() throws FileNotFoundException, InterruptedException {

        loginPageMethods loginPageMethods = new loginPageMethods();
        leadPageMethods leadPageMethods = new leadPageMethods();

        //Login to the application
        loginPageMethods.login();

        //Navigate to Lead > Baltimore
        leadPageMethods.clickLead();
        leadPageMethods.clickBootStrap();

        //Get follow id
        implicitWait("1000");
        String follow_id_actual = leadPageMethods.getFollowId();
        System.out.println("follow_id_actual" + follow_id_actual);

        //Click open button of first row
        implicitWait("1000");
        leadPageMethods.clickOpenButton();

        implicitWait("1000");
        String follow_id_name = leadPageMethods.getFollowId_name(follow_id_actual);
        System.out.println("follow_id_name" + follow_id_name);


        String expected = follow_id_name.substring(0, follow_id_actual.length() + 1);

        //Validating opened lead is the same as the clicked one
        Assert.assertEquals(follow_id_actual.trim(), expected.trim());
    }

    @Test(priority = 2)
    public void SkippedTest() {
        throw new SkipException("Skipping this test");
    }

    @Test(priority = 3)
    public void FailedTest() {
        Assert.assertEquals(true, false);
    }

    @Test(priority = 1, dataProvider = "", dependsOnGroups = "UnknownTest", description = "Testing for allure report customization", groups = {"Group1", "group2"}, suiteName = "Test Suite for allure report", testName = "Test Name set by the allocation")
    public void PassedTest() {
        Assert.assertEquals(true, true);
    }

    @Test(priority = 4)
    public void UnknownTest() {

    }
}