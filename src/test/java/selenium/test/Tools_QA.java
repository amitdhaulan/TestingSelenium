package selenium.test;

import common.BaseClass;
import common.CustomAssertion;
import common.homePageMethods;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

@Listeners(common.ListenerTest.class)
public class Tools_QA extends BaseClass {
    private final CustomAssertion custom_assertion = new CustomAssertion();

    public Tools_QA() throws FileNotFoundException {
    }

    @Test(priority = 1)
    public void PassedTestCase() {
        homePageMethods homePageMethods = new homePageMethods();
        applyLog(getClass().toString(), "Verifying Application Logo");
        Assert.assertEquals(homePageMethods.getApplicationLogo(), true);
        custom_assertion.assertSame(homePageMethods.getApplicationLogo(), true,"Application Logo verified successfully");

    }

    @Test(priority = 2)
    public void FailedTestCase() {
        custom_assertion.assertTrue(false, "Failing Assertion");
    }
}