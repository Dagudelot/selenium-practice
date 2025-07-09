package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AbstractWebPage;

public class ButtonsPage extends AbstractWebPage {

    // Locators
    protected final String DOUBLE_CLICK_BUTTON = "//button[@id='doubleClickBtn']";
    protected final String RIGHT_CLICK_BUTTON = "//button[@id='rightClickBtn']";
    protected final String CLICK_ME_BUTTON = "//button[text()='Click Me']";
    protected final String DOUBLE_CLICK_MESSAGE = "//p[@id='doubleClickMessage']";

    public ButtonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickDoubleClickButton() {
        System.out.println("Clicking on double click button: " + DOUBLE_CLICK_BUTTON);
        doubleClickOnElement(By.xpath(DOUBLE_CLICK_BUTTON));
    }

    public void clickRightClickButton() {
        System.out.println("Clicking on right click button: " + RIGHT_CLICK_BUTTON);
        rightClickOnElement(By.xpath(RIGHT_CLICK_BUTTON));
    }

    public void clickClickMeButton() {
        System.out.println("Clicking on Click Me button: " + CLICK_ME_BUTTON);
        clickOnElement(By.xpath(CLICK_ME_BUTTON));
    }

    public String getDoubleClickMessage() {
        System.out.println("Getting double click message from: " + DOUBLE_CLICK_MESSAGE);
        return getTextFromElement(By.xpath(DOUBLE_CLICK_MESSAGE));
    }
}
