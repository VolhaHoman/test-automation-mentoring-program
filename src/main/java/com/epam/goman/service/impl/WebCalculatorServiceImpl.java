package com.epam.goman.service.impl;

import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.model.exception.RemoteOperatorException;
import com.epam.goman.service.WebCalculatorService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class WebCalculatorServiceImpl implements WebCalculatorService {

    private static final By CLEAR_BTN = By.xpath("//a[text()='clear']");
    private static final By CLEAR_DIALOG_CLEAN_BTN = By.xpath("//button[text()='Clear']");
    private static final By FIRST_FIELD_INPUT = By.xpath("//*[text()='R1']/following-sibling::span[@class='c1']/input[@value='']");
    private static final By FIRST_RESULT = By.xpath("(//*[@class='c2']/result)[1]");
    private static final String BASE_URL = "https://instacalc.com";
    public WebCalculatorServiceImpl() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public Double webOperation(Number x, Number y, String operator) {
        Objects.requireNonNull(x, "x can't be null");
        Objects.requireNonNull(y, "y can't be null");
        if (Objects.isNull(operator) && operator.isBlank())
            throw new ParameterIsNullException("Operator can't be null or blank");
        if (y.equals(0) && operator.equals("/")) throw new ArithmeticException("Division by zero");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get(BASE_URL);

            WebElement clearBtn = driver.findElement(CLEAR_BTN);
            clearBtn.click();

            WebElement clearInnerBtn = driver.findElement(CLEAR_DIALOG_CLEAN_BTN);
            clearInnerBtn.click();

            WebElement firstField = driver.findElement(FIRST_FIELD_INPUT);
            firstField.click();
            firstField.sendKeys(x + operator + y);

            WebElement result = driver.findElement(FIRST_RESULT);
            String resultText = result.getText();
            return Double.parseDouble(resultText);
        } catch (Exception e) {
            throw new RemoteOperatorException("Can't operate: " + x + operator + y);
        } finally {
            driver.quit();
        }
    }
}
