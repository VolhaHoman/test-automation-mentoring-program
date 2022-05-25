package com.epam.goman.service.impl;

import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.model.exception.RemoteOperatorException;
import com.epam.goman.service.WebCalculatorService;
import org.openqa.selenium.WebDriver;
import page.WebCalculatorPage;

import java.util.Objects;

public class WebCalculatorServiceImpl implements WebCalculatorService {

    @Override
    public Double webOperation(Number x, Number y, String operator) {
        Objects.requireNonNull(x, "x can't be null");
        Objects.requireNonNull(y, "y can't be null");
        if (Objects.isNull(operator) || operator.isBlank())
            throw new ParameterIsNullException("Operator can't be null or blank");
        if (y.equals(0) && operator.equals("/")) throw new ArithmeticException("Division by zero");

        WebDriver driver = null;
        try {
            driver = WebDriverCreate.getDriver();

            WebCalculatorPage calculatorPage = new WebCalculatorPage(driver);

            calculatorPage.openCalculatorPage();

            calculatorPage.clickClearButton();

            calculatorPage.clickInnerClearButton();

            calculatorPage.fillInFirstField(x + operator + y);

            return calculatorPage.findResult();
        } catch (Exception e) {
            throw new RemoteOperatorException("Can't operate: " + x + operator + y);
        } finally {
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
        }
    }
}
