package components.clickable.buttons;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import utility.DriverSetup;


public class MuiLink extends DriverSetup {

    public static final String LINK_ROOT  = "//a[contains(@class,'MuiLink')]";
    public static final String MUI_LINK   = LINK_ROOT + "[contains(@href,'{LINK}') or contains(.,'{LINK}')]";

    @And("I see {string} mui-link")
    public void iSeeMuiLink(String linkText) {
        try{
            driver.findElement(By.xpath(MUI_LINK.replace("{LINK}", linkText)));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            driver.findElement(By.xpath(MUI_LINK.replace("{LINK}", linkText)));
        }

    }
}
