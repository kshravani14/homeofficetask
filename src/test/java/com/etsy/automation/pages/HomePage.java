package com.etsy.automation.pages;


import com.etsy.automation.session.DataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "search-query")
    WebElement searchBox;

    @FindBy(css = ".alert")
    WebElement gdprAlert;

    @FindBy(css = ".alert .btn-outline-black")
    WebElement accept;

    @FindBy(css = "div#search-suggestions ul")
    WebElement searchSuggestionList;

    String SEARCH_SUGGESTION_LIST = "ul li.as-rich";

    @FindBy(css = "li.as-rich:nth-of-type(2)")
    WebElement secondResult;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void getHomePage(){
        driver.get(DataStore.getDataKey("baseURL"));
    }

    public void enterSearchTerm(String searchTerm) {
        waitForElementToBeClickable(searchBox).click();
        waitForElementToBeClickable(searchBox).sendKeys(searchTerm);
    }

    public void clickOnGDPRAlert() {
        try{
            waitForElementToBeVisible(gdprAlert, 5);
            waitForElementToBeClickable(accept).click();
        } catch (Exception e) {
            System.out.println("GDPR conscent is not visible at this time "+e);
        }
    }

    public int getSearchSuggesstionsList() {
        waitForElementToBeVisible(searchSuggestionList);
        return driver.findElements(By.cssSelector(SEARCH_SUGGESTION_LIST)).size();
    }

    public SearchResultsPage clickOnSecondItemFromList() {
        waitForElementToBeVisible(secondResult).click();
        return new SearchResultsPage(driver);
    }

}
