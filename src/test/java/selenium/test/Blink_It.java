package selenium.test;

import common.BaseClass;
import common.dashboardPageMethods;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Blink_It extends BaseClass {

    public Blink_It() throws FileNotFoundException {
    }

    @Test
    public void openSwagLabs() throws FileNotFoundException, InterruptedException {

        dashboardPageMethods dashboardPageMethods = new dashboardPageMethods();
        dashboardPageMethods.allowGeoLocation();

    }
}