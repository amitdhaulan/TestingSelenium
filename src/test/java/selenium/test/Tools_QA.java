package selenium.test;

import common.BaseClass;
import common.homePageMethods;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

@Listeners(common.ListenerTest.class)
public class Tools_QA extends BaseClass {


    public Tools_QA() throws FileNotFoundException {
    }

    @Test
    public void toolsQA()  {
        homePageMethods homePageMethods = new homePageMethods();
        Assert.assertEquals(homePageMethods.getApplicationLogo(),false);
        applyLog(getClass().toString(),"Application Logo was not verified");
    }
}