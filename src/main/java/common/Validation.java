package common;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.logging.Logger;

public class Validation implements ITestListener {

    static Logger log = Logger.getLogger(String.valueOf(BaseClass.class));

    public static void assertEquals(String description, String actual, String expected){
        Assert.assertEquals(actual,expected);
    }

    public static void assertTrue(Boolean condition){
        Assert.assertTrue(condition);
    }

    public static void assertFalse(Boolean condition){
        Assert.assertTrue(condition);
    }

    @Override
    public void onFinish(ITestContext arg0) {
        log.config("On Finish ----------> "+arg0.toString());

    }

    @Override
    public void onStart(ITestContext arg0) {
        log.config("On Start ----------> "+arg0.toString());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        log.config("onTestFailedButWithinSuccessPercentage ----------> "+arg0.toString());

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        log.config("onTestFailure ----------> "+arg0.getTestName());
        System.out.println("The name of the testcase failed is :"+arg0.getTestName());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        log.config("onTestSkipped ----------> "+arg0.toString());

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        log.config("onTestStart ----------> "+arg0.toString());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        log.config("onTestSuccess ----------> "+arg0.getName());

    }
}
