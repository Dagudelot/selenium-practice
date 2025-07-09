package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demoqa.AlertsPage;
import pages.demoqa.ButtonsPage;
import pages.demoqa.DemoQABasePage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;


public class UserInteractionsStepDefinitions {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected DemoQABasePage demoQABasePage;
    protected AlertsPage alertsPage;
    protected ButtonsPage buttonsPage;

    @Before
    public void setUp(Scenario scenario) {
        // This method would contain logic to set up the test environment
        // For example, initializing WebDriver, opening the browser, etc.
        System.out.println("Escenario en ejecución → Thread Name: " + Thread.currentThread().getId());
        String browser = scenario.getSourceTagNames().contains("@firefox") ? "firefox" : "chrome";
        DriverFactory.initializeWebDriver(browser);
        webDriver = DriverFactory.getWebDriver();
        wait = DriverFactory.getWebDriverWait();
        demoQABasePage = new DemoQABasePage(webDriver);
        alertsPage = new AlertsPage(webDriver);
        buttonsPage = new ButtonsPage(webDriver);
    }

    @Given("el usuario navega a la web")
    public void el_usuario_navega_a_la_web() {
        demoQABasePage.open();
    }
    @Given("se dirige a la pestaña de alertas")
    public void se_dirige_a_la_pestaña_de_alertas() {
        demoQABasePage.clickAlertsFrameWindowsOption();
        demoQABasePage.clickAlertsOption();
    }
    @When("acepta una alerta emergente")
    public void acepta_una_alerta_emergente() {
        alertsPage.clickAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
    }
    @Then("la alerta se cierra")
    public void la_alerta_se_cierra() {
        // wait until alert is NOT present
        assertFalse(alertsPage.isAlertPresent(), "La alerta no se ha cerrado correctamente");
    }
    @Given("se dirige a la pestaña de botones")
    public void se_dirige_a_la_pestaña_de_botones() {
        demoQABasePage.clickElementsOption();
        demoQABasePage.clickButtonsOption();
    }
    @When("da doble clic sobre un boton")
    public void da_doble_clic_sobre_un_boton() {
        buttonsPage.clickDoubleClickButton();

    }
    @Then("una mensaje se muestra con el texto {string}")
    public void un_mensaje_se_muestra(String expectedMessage) {
        String doubleClickMessage = buttonsPage.getDoubleClickMessage();
        assertEquals(expectedMessage, doubleClickMessage, "El mensaje del doble clic no es el esperado");
    }

    @After
    public void tearDown() {
        // This method will be executed after each scenario
        // You can add code here to clean up resources, like closing the WebDriver
        System.out.println("Tearing down after scenario");
        DriverFactory.quitDriver(); // Ensure the WebDriver is closed after each scenario
    }
}
