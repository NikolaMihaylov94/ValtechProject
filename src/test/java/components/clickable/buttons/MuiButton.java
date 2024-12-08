package components.clickable.buttons;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import utility.DriverSetup;

public class MuiButton extends DriverSetup {

    private static final String BUTTON_ROOT = "//button[contains(@class,'MuiButton')]";
    private static final String MUI_BUTTON  = BUTTON_ROOT + "[contains(.,'{LABEL}')]";

    @And("I click {string} mui-button")
    public void iClickMuiButton(String label) {
        try{
            driver.findElement(By.xpath(MUI_BUTTON.replace("{LABEL}", label))).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            driver.findElement(By.xpath(MUI_BUTTON.replace("{LABEL}", label))).click();
        }

    }
}
