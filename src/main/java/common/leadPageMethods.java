package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;
import java.util.List;

import static common.BaseClass.loadProperty;
import static common.BaseClass.properties;


public class leadPageMethods {

    leadPageObjects pageObjects = PageFactory.initElements(BaseClass.getDriver(), leadPageObjects.class);

    public void clickLead() {
        pageObjects.getLead().click();
    }

    public void clickBootStrap() throws FileNotFoundException, InterruptedException {
        loadProperty();
        clickLead_bootStrapMenu(properties.getProperty("leadbootstrapmenu1"));
    }

    public void clickOpenButton() {
        leadPageObjects.getTableRowOpenButton().click();
    }

    public String getFollowId() {
        return leadPageObjects.getTableRowFollowid().getText();
    }

    public String getFollowId_name(String followid) {
        String text = "";
        List<WebElement> elements = leadPageObjects.getFollowid_name();
        for(WebElement e: elements){
            if (e.getText().contains(followid)){
                text = e.getText();
                break;
            }
        }
        return text;
    }

    public void clickLead_bootStrapMenu(String menuItem) throws InterruptedException {
        List<WebElement> webElements =  pageObjects.getBootStrap_menu();
        Thread.sleep(5000);
        for (WebElement element : webElements){
            if (element.getAttribute("innerHTML").contains(menuItem)) {
                element.click();
                break;
            }
        }
    }
}
