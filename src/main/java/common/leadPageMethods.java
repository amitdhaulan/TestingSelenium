package common;

import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;

import static common.BaseClass.loadProperty;
import static common.BaseClass.properties;


public class leadPageMethods {

    leadPageObjects leadPageObjects = PageFactory.initElements(BaseClass.getDriver(), leadPageObjects.class);

    public void clickLead() {
        leadPageObjects.getLead().click();
    }

    public void clickBootStrap() throws FileNotFoundException, InterruptedException {
        loadProperty();
        leadPageObjects.clickLead_bootStrapMenu(properties.getProperty("leadbootstrapmenu1"));
    }

    public void clickOpenButton() {
        leadPageObjects.getTableRowOpenButton().click();
    }
}
