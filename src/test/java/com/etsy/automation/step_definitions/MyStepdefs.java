package com.etsy.automation.step_definitions;

import com.etsy.automation.config.ConfigLoader;
import com.etsy.automation.pages.HomePage;
import com.etsy.automation.pages.SearchResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {
    WebDriver driver;
    ConfigLoader configLoader = new ConfigLoader();
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @Before
    public void loadConfig() {
        configLoader.loadConfig();
        driver = configLoader.getDriver();
        homePage = new HomePage(driver);
    }

    @After
    public void cleanup() {
        configLoader.closeBrowser();
    }

    @Given("^As a user, I navigated to Etsy home page$")
    public void asAUserINavigatedToEtsyHomePage() throws Throwable {
        homePage.getHomePage();
    }

    @When("^I enter search term '(.*?)' in the search box$")
    public void iEnterSearchTermSportsShoesInTheSearchBox(String searchTerm) throws Throwable {
        homePage.enterSearchTerm(searchTerm);
    }

    @And("^I click on Accept for GDPR settings if presented$")
    public void iClickOnAcceptForGDPRSettings() throws Throwable {
        homePage.clickOnGDPRAlert();
    }

    @And("^I can see search suggestions listed$")
    public void iCanSeeSearchSuggestionsListed() throws Throwable {
        Assert.assertTrue(homePage.getSearchSuggesstionsList() > 0);
    }

    @And("^I select the second suggestion from the list$")
    public void iSelectTheFirstSuggestionFromTheList() throws Throwable {
        searchResultsPage = homePage.clickOnSecondItemFromList();
    }

    @Then("^I can see search results page to be loaded$")
    public void iWaitForSearchResultsPageToBeLoaded() throws Throwable {
        Assert.assertTrue(searchResultsPage.getSortByGroupDesc().contains("Sort by"));
        Assert.assertTrue(searchResultsPage.getPageURL().contains("search"));
    }

    @When("^I sort the search results by '(.*?)'$")
    public void iSortTheSearchResultsByHighestPrice(String sortingType) throws Throwable {
        searchResultsPage.sortResultsBy(sortingType);
    }

    @Then("^I can see search results are sorted by '(.*?)'$")
    public void iCanSeeSearchResultsAreSortedByHighestPrice(String buttonText) throws Throwable {
        Assert.assertTrue(searchResultsPage.getSortByGroupDesc().contains(buttonText));
    }

    @And("^I print the prices of top '(\\d+)' items$")
    public void iPrintThePricesOfTopItems(int arg0) throws Throwable {
        searchResultsPage.getTopFewSortedItems(arg0);
    }
}


