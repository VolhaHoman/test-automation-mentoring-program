package com.epam.goman.model;

import com.epam.goman.service.CustomLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomListener implements WebDriverListener {

    private static final Logger log = CustomLogger.LOG;

    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info("Driver get url: {}", url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        log.info("Driver got url: {}", url);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        log.info("Driver find element: {}", locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.info("Driver found element: {}, {}", locator, result);
    }

    @Override
    public void beforeClick(WebElement element) {
        log.info("Driver click element: {}", element);
    }

    @Override
    public void afterClick(WebElement element) {
        log.info("Driver clicked element: {}", element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Driver send keys: {}", String.join("", keysToSend));
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Driver sent keys: {}", String.join("", keysToSend));
    }

    @Override
    public void beforeGetText(WebElement element) {
        log.info("Driver find text: {}", element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        log.info("Driver found text: {}", result);
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        log.info("Driver will quit");
    }

    @Override
    public void afterQuit(WebDriver driver) {
        log.info("Driver quited");
    }
}
