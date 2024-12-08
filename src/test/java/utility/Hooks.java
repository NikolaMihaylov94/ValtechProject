package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverSetup{

    @Before
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();// Initialize the driver
    }

    @After
    public void teardown() {
        Driver.closeDriver(); // Quit the driver
    }
}
