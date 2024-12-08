package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.nio.file.Paths;

public abstract class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String chromeDriverPath = getChromeDriverPath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static String getChromeDriverPath() {
        try {
            // Locate ChromeDriver dynamically using the ClassLoader
            URL resource = Driver.class.getClassLoader().getResource("chromedriver.exe");
            if (resource == null) {
                throw new IllegalStateException("ChromeDriver not found in resources folder");
            }
            return Paths.get(resource.toURI()).toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to locate ChromeDriver", e);
        }
    }
}
