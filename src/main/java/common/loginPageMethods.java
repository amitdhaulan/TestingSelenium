package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class loginPageMethods {
    public void login() throws InterruptedException {

        loginPageObjects profilePg = PageFactory.initElements(BaseClass.getEventDriver(), loginPageObjects.class);

        Select drpdwn = new Select(profilePg.selectValue());
        drpdwn.selectByVisibleText("301Squad");
        profilePg.getUserName().sendKeys("sonuk11@chetu.com");
        profilePg.getPassword().sendKeys("Sonukr@183");
        profilePg.getLoginButton().click();
        profilePg.getLead().click();


        List<WebElement> webElements = profilePg.getBootStrap_menu();
        Thread.sleep(5000);
        for (WebElement ele : webElements)

        {

            // for every elements it will print the name using innerHTML

            System.out.println("Values " + ele.getAttribute("innerHTML"));

            // Here we will verify if link (item) is equal to Java Script

            if (ele.getAttribute("innerHTML").contains("Baltimore")) {
                // if yes then click on link (iteam)
                ele.click();
                // break the loop or come out of loop
                break;
            }
        }
    }
}
