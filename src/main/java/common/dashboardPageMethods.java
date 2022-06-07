package common;

import org.openqa.selenium.support.PageFactory;

public class dashboardPageMethods {
    public void allowGeoLocation() {
        dashboardPageObjects dashboardPageObjects = PageFactory.initElements(BaseClass.getDriver(), dashboardPageObjects.class);
        dashboardPageObjects.allow_geoLocation().click();
    }
}
