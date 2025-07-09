package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractWebPage;
import utils.ConfigReader;

public class DemoQABasePage extends AbstractWebPage {

    protected final String BASE_URL = ConfigReader.get("demoqa.base.url", "https://demoqa.com");
    protected final String ALERTS_URL = BASE_URL + "/alerts";

    // Locators
    protected final String ALERT_FRAME_WINDOWS_LIST_OPTION = "//div[@class='category-cards']//*[text()='Alerts, Frame & Windows']";
    protected final String ALERTS_OPTION = "//ul//li//span[text()='Alerts']";
    protected final String ELEMENTS_LIST_OPTION = "//div[@class='category-cards']//*[text()='Elements']";
    protected final String BUTTONS_OPTION = "//ul//li//span[text()='Buttons']";

    public DemoQABasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        // This method would contain logic to open the base page
        // For example, using a WebDriver instance to open the URL
        System.out.println("Opening base page: " + BASE_URL);
        webDriver.get(BASE_URL);
    }

    public void navigateToAlertsPage() {
        // This method would contain logic to navigate to the Alerts page
        // For example, using a WebDriver instance to open the URL
        System.out.println("Navigating to: " + ALERTS_URL);
        webDriver.get(ALERTS_URL); // Uncomment this line when using a WebDriver instance
    }

    public void clickAlertsFrameWindowsOption() {
        // This method would contain logic to click on the Alerts list option
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on Alerts list option: " + ALERT_FRAME_WINDOWS_LIST_OPTION);
        clickOnElement(By.xpath(ALERT_FRAME_WINDOWS_LIST_OPTION));
    }

    public void clickElementsOption() {
        // This method would contain logic to click on the Elements option
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on Elements option: " + ELEMENTS_LIST_OPTION);
        clickOnElement(By.xpath(ELEMENTS_LIST_OPTION));
    }

    public void clickAlertsOption() {
        // This method would contain logic to click on the Alerts option
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on Alerts option: " + ALERTS_OPTION);
        clickOnElement(By.xpath(ALERTS_OPTION));
    }

    public void clickButtonsOption() {
        // This method would contain logic to click on the Buttons option
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on Buttons option: " + BUTTONS_OPTION);
        clickOnElement(By.xpath(BUTTONS_OPTION));
    }
}
