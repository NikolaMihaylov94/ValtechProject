package utility;

import org.openqa.selenium.WebDriver;
import utility.Driver;

public class DriverSetup extends Driver{
    protected WebDriver driver;

    public DriverSetup() {
        this.driver = getDriver();
    }
}