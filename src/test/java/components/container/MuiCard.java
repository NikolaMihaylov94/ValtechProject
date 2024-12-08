package components.container;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverSetup;

import java.time.Duration;
import java.util.List;


public class MuiCard extends DriverSetup {

    private static final String ROOT              = "//div[contains(@class,'MuiCard')]";
    private static final String CARD_CONTENT      = ROOT + "//div[contains(@class,'MuiCardContent')]";
    private static final String BLANK_SLATE       = "//h6[contains(@class,'MuiTypography')]";
    private static final String CARD_TITLE        = CARD_CONTENT + BLANK_SLATE;
    private static final String CARD_TITLE_1      = CARD_CONTENT + BLANK_SLATE + "[contains(.,'{TITLE}')]";
    private static final String CARD_CONTENT_TEXT = CARD_CONTENT + "[." + BLANK_SLATE + "[contains(.,'{TITLE}')]]//span[contains(.,'{SUBTEXT}')]";
    //div[contains(@class,'MuiCard')]//div[contains(@class,'MuiCardContent')][.//h6[contains(@class,'MuiTypography')][contains(.,'Aleksandar Petkov')]]//span[contains(.,' Sofia / Office Center')]


    @And("I see {string} mui-card")
    public void iSeeMuiCard(String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CARD_TITLE_1.replace("{TITLE}", title))));

        driver.findElement(By.xpath(card.toString()));
    }


    @And("I see only {string} mui-card on the page")
    public void iSeeOnlyMuiCardOnThePage(String title) {
        List<WebElement> cards = driver.findElements(By.xpath(CARD_TITLE));

        for (WebElement card : cards) {
            try {
                String cardText = card.getText();
                System.out.println("Found card with text: " + cardText);

                Assert.assertEquals("Expected: " + title + " but was: " + cardText, title, cardText);
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Stale element reference, re-locating elements...");
                driver.findElements(By.xpath("//div[contains(@class,'MuiCard')]//div[contains(@class,'MuiCardContent')]"));
            }
        }
    }

    @And("I see {string} mui-card contains {string} subtext")
    public void iSeeMuiCardContainsSubtext(String title, String subtext) {
        try{
            driver.findElement(By.xpath(CARD_CONTENT_TEXT.replace("{TITLE}", title).replace("{SUBTEXT}", subtext)));
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            driver.findElement(By.xpath(CARD_CONTENT_TEXT.replace("{TITLE}", title).replace("{SUBTEXT}", subtext)));
        }
    }
}
