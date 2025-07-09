package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractWebPage;

public class AlertsPage extends AbstractWebPage {

    // Locators

    protected final String ALERT_BUTTON = "//button[@id='alertButton']";

    public AlertsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAlertButton() {
        // This method would contain logic to click on the alert button
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on alert button: " + ALERT_BUTTON);
        clickOnElement(By.xpath(ALERT_BUTTON));
    }

    public Boolean isAlertPresent() {
        // This method would contain logic to check if an alert is present
        // For example, using a WebDriver instance to check for the presence of an alert
        try {
            webDriver.switchTo().alert();
            System.out.println("Alert is present.");
            return true;
        } catch (Exception e) {
            System.out.println("No alert present.");
            return false;
        }
    }
}
