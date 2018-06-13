package com.etsy.automation.pages;

import com.etsy.automation.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{

    WebDriver driver;

    public String  getPageURL() {
        return driver.getCurrentUrl();
    }

    private final long TIMEOUT_VALUE = 30;

    protected WebElement waitForElementToBeVisible(WebElement e) {
        return waitForElementToBeVisible(e, TIMEOUT_VALUE);
    }

    protected WebElement waitForElementToBeVisible(WebElement e, long timeOutPeriod) {
        return new WebDriverWait(ConfigLoader.driver, TIMEOUT_VALUE).until(ExpectedConditions.visibilityOf(e));
    }

    protected WebElement waitForElementToBeClickable(WebElement e) {
        return waitForElementToBeClickable(e, TIMEOUT_VALUE);
    }

    protected WebElement waitForElementToBeClickable(WebElement e, long timeOutPeriod) {
        return new WebDriverWait(ConfigLoader.driver, timeOutPeriod).until(ExpectedConditions.elementToBeClickable(e));
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return new WebDriverWait(ConfigLoader.driver, TIMEOUT_VALUE).until(ExpectedConditions.elementToBeClickable(by));
    }

}
