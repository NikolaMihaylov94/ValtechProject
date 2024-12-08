package components.browserAndConsole;

import io.cucumber.java.en.Given;
import utility.DriverSetup;

public class BrowserActions extends DriverSetup {

    @Given("I open {string} url")
    public void iNavigateToURL(String url) {
        driver.get(url);
    }
}