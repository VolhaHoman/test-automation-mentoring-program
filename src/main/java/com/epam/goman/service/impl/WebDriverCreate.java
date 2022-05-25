package com.epam.goman.service.impl;

import com.epam.goman.model.BrowserEnum;
import com.epam.goman.model.CustomListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.InputStream;

public class WebDriverCreate {


    public static WebDriver getDriver() throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        InputStream inputStream = WebDriverCreate.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        config.load(inputStream);
        String browserName = config.getString("driver.for.use");
        return chooseBrowser(BrowserEnum.valueOf(browserName));
    }

    public static WebDriver chooseBrowser(BrowserEnum browser) {
        switch (browser) {
            case CHROME: {
                return getDecorated(getChrome());
            }
            case FIREFOX: {
                return getDecorated(getFireFox());
            }
            default:
                return null;
        }
    }

    private static WebDriver getDecorated(WebDriver driver) {
        return new EventFiringDecorator(new CustomListener())
                .decorate(driver);
    }

    private static WebDriver getChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        return new ChromeDriver((chromeOptions));
    }

    private static WebDriver getFireFox() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        return new FirefoxDriver(firefoxOptions);
    }
}

