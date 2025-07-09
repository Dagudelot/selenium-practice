package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.DriverFactory;

public class AbstractWebPage {

    protected WebDriver webDriver;

    public AbstractWebPage(WebDriver webDriver) {
        // Constructor to initialize the WebDriver if needed
        // This can be used to set up any page-specific configurations
        this.webDriver = webDriver;
    }

    public void clickOnElement(By elementLocator) {
        // This method would contain logic to click on an element
        // For example, using a WebDriver instance to find the element and click it
        System.out.println("Clicking on an element");
        webDriver.findElement(elementLocator).click(); // Uncomment this line when using a WebDriver instance
    }

    public void rightClickOnElement(By elementLocator) {
        // This method would contain logic to right-click on an element
        // For example, using a WebDriver instance to find the element and right-click it
        System.out.println("Right-clicking on an element");
        new Actions(webDriver).contextClick(webDriver.findElement(elementLocator)).perform();
    }

    public void doubleClickOnElement(By elementLocator) {
        // This method would contain logic to double-click on an element
        // For example, using a WebDriver instance to find the element and double-click it
        System.out.println("Double-clicking on an element");
        new Actions(webDriver).doubleClick(webDriver.findElement(elementLocator)).perform();
    }

    public String getTextFromElement(By elementLocator) {
        // This method would contain logic to get text from an element
        // For example, using a WebDriver instance to find the element and retrieve its text
        System.out.println("Getting text from an element");
        String text = webDriver.findElement(elementLocator).getText(); // Uncomment this line when using a WebDriver instance
        System.out.println("Text retrieved: " + text);
        return text;
    }
}
