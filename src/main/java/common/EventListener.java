package common;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.sql.Date;
import java.sql.Timestamp;

public class EventListener implements WebDriverEventListener {
//    private Date date = new Date();
    private Timestamp date = new Timestamp(System.currentTimeMillis());

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
      /*  date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println("after change value "+webElement.toString());*/
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after click on"+arg0.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }


    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        customAfterFindBy(arg0, arg1, arg2);
    }

    public void customAfterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after FindBy "+arg0.toString());
    }
    @Override
    public void afterNavigateBack(WebDriver arg0) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after Navigate back "+arg0.toString());
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after Navigate forward "+arg0.toString());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after Navigate to "+arg0);
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" after script "+arg0); }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" Before click ");

    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" Before find by ");

    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);

    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);

    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" Before navigate to ");

    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);

    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        date = new Timestamp(System.currentTimeMillis());
        System.out.print(date);
        System.out.println(" On exception.."+arg0.toString());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
