package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dashboardPageObjects {

    @FindBy(xpath="//button[@class='btn location-box mask-button']")
    private static WebElement location_Popup;

    public WebElement allow_geoLocation(){
        return location_Popup;
    }

}
