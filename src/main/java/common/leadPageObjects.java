package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class leadPageObjects {

    //---------------------------Lead page objects---------------------------
    @FindBy(id="side-menu-calls")
    private static WebElement leads;

    @FindBy(xpath="//label[@class='btn btn-primary radiobuttongroup']")
    private static List<WebElement> lead_bootstrapmenu;

    @FindBy(xpath="//div[@id='FollowUpTodatLeadsGrid']")
    private static WebElement tablepane_leadstable;

    @FindBy(xpath="//div[@id='FollowUpTodatLeadsGrid']//descendant::table/tbody/tr[1]/td[4]")
    private static WebElement tablepane_followid;

    @FindBy(xpath="//div[@id='FollowUpTodatLeadsGrid']//descendant::table/tbody/tr[1]/td[11]/input")
    private static WebElement tablepane_rowsbutton;

    //---------------------------Lead detail page objects---------------------------
    @FindBy(xpath="//li[@class='pagetab active']")
    private static List<WebElement> followid_name;

    @FindBy(xpath="//button[@id='btnHideMenu']")
    private static WebElement cross_button;

    public WebElement getLead(){ return leads;}

    public List<WebElement> getBootStrap_menu(){
        return lead_bootstrapmenu;
    }

    public static WebElement getLeadsTable(){ return tablepane_leadstable;}

    public static WebElement getTableRowFollowid(){ return tablepane_followid;}

    public static WebElement getTableRowOpenButton(){ return tablepane_rowsbutton;}

    public static List<WebElement> getFollowid_name(){ return followid_name;}

    public static WebElement getCrossButton(){ return cross_button;}
}
