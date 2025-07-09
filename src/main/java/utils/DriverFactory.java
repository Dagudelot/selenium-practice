package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeWebDriver(String browser) {
        try {
            boolean isRemote = ConfigReader.getBoolean("remote.grid.enabled", false);
            String gridUrl = ConfigReader.get("remote.grid.url", "http://localhost:4444/wd/hub");
            boolean headless = ConfigReader.getBoolean("headless", false);

            if (isRemote) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                System.out.println("Usando gridULR: " + gridUrl);
                driver.set(new RemoteWebDriver(new URL(gridUrl), capabilities));
            } else {
                if (browser.equalsIgnoreCase("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    if (headless) {
                        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
                        System.out.println("Opciones de Chrome: " + options.asMap());
                    }
                    driver.set(new ChromeDriver(options));
                } else if (browser.equalsIgnoreCase("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    if (headless) {
                        options.addArguments("--headless");
                    }
                    driver.set(new FirefoxDriver(options));
                } else {
                    throw new RuntimeException("Browser not supported: " + browser);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
        }
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), Duration.ofSeconds(ConfigReader.getLong("wait.timeout", "30")));
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver.get())) {
            driver.get().quit();
            driver.remove(); // crucial para evitar memory leaks en ejecución paralela
        }
    }
}
