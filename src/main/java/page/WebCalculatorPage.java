package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebCalculatorPage {

    public static final Duration TIMEOUT = Duration.ofSeconds(10);
    private final WebDriver driver;

    public WebCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CLEAR_BTN = By.xpath("//a[text()='clear']");
    private static final By CLEAR_DIALOG_CLEAN_BTN = By.xpath("//button[text()='Clear']");
    private static final By FIRST_FIELD_INPUT = By.xpath("//*[text()='R1']/following-sibling::span[@class='c1']/input[@value='']");
    private static final By FIRST_RESULT = By.xpath("(//*[@class='c2']/result)[1]");
    private static final String PAGE_URL = "https://instacalc.com";

    public void openCalculatorPage() {
        this.driver.get(PAGE_URL);
    }

    public void clickClearButton() {
        getElementWithWait(CLEAR_BTN).click();
    }

    public void clickInnerClearButton() {
        getElementWithWait(CLEAR_DIALOG_CLEAN_BTN).click();
    }

    public void fillInFirstField(String text) {
        WebElement firstFieldInput = getElementWithWait(FIRST_FIELD_INPUT);
        firstFieldInput.click();
        firstFieldInput.sendKeys(text);
    }

    public Double findResult () {
        WebElement result = getElementWithVisibility(FIRST_RESULT);
        String resultText = result.getText();
        return Double.parseDouble(resultText);
    }

    private WebElement getElementWithWait(By by) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement getElementWithVisibility(By by) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
