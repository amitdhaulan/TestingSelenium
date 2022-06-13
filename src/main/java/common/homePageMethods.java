package common;

import org.openqa.selenium.support.PageFactory;

public class homePageMethods {
    public boolean getApplicationLogo() {
        homePageObjects homePageObjects = PageFactory.initElements(BaseClass.getDriver(), homePageObjects.class);
        BaseClass.applyLog(getClass().toString(),"Returning Application Logo");
        return homePageObjects.get_applicationLogo().isDisplayed();
    }
}
