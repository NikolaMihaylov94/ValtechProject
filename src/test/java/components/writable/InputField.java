package components.writable;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import utility.DriverSetup;

public class InputField extends DriverSetup {

    private static final String ROOT        = "//div[contains(@class,'MuiInputBase')]";
    private static final String INPUT_FIELD = ROOT + "//input[contains(@placeholder,'{LABEL}')]";

    @And("I fill {string} input field with {string}")
    public void iNavigateToURL(String label, String text){
        try{
            driver.findElement(By.xpath(INPUT_FIELD.replace("{LABEL}", label))).click();
            driver.findElement(By.xpath(INPUT_FIELD.replace("{LABEL}", label))).sendKeys(text);
        } catch(org.openqa.selenium.StaleElementReferenceException e){
            driver.findElement(By.xpath(INPUT_FIELD.replace("{LABEL}", label))).click();
            driver.findElement(By.xpath(INPUT_FIELD.replace("{LABEL}", label))).sendKeys(text);
        }

    }
}
