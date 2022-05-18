package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class leadPageObjects {

    @FindBy(id="side-menu-calls")
    private static WebElement leads;

    @FindBy(xpath="//label[@class='btn btn-primary radiobuttongroup']")
    private static List<WebElement> lead_bootstrapmenu;

    public WebElement getLead(){ return leads;}

    public List<WebElement> getBootStrap_menu(){
        return lead_bootstrapmenu;
    }

    public void clickLead_bootStrapMenu(String menuItem) throws InterruptedException {
        List<WebElement> webElements =  getBootStrap_menu();
        Thread.sleep(5000);
        for (WebElement element : webElements){
            if (element.getAttribute("innerHTML").contains(menuItem)) {
                element.click();
                break;
            }
        }
    }
}