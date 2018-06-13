package com.etsy.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".dropdown-group")
    WebElement sortByGroup;

    @FindBy(css = "div#sortby .btn-secondary")
    WebElement relavancyButton;

    String searchResultItem = ".block-grid-item";
    String itemDesc = "p.text-body";
    String itemCost = "span.currency-value";

    public SearchResultsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getSortByGroupDesc() {
        return waitForElementToBeClickable(sortByGroup).getText();
    }

    public void sortResultsBy(String sortingType) {
        waitForElementToBeClickable(relavancyButton).click();
        waitForElementToBeClickable(By.linkText(sortingType)).click();
    }

    public void getTopFewSortedItems(int count) throws InterruptedException {
        System.out.println("<=======================================================================>\n\n\n");
        int temp = 0;
        List<WebElement> results = driver.findElements(By.cssSelector(searchResultItem));
        for(WebElement element: results) {
            if( element.isDisplayed() == true) {
                if(!element.getText().contains("Ad")) {
                    System.out.println("Item Desc: "+element.findElement(By.cssSelector(itemDesc)).getText().substring(0, 25)+
                    " <=> Item Cost: "+element.findElement(By.cssSelector(itemCost)).getText());
                    temp++;
                }
            }
            if(temp >= count) {
                break;
            }
        }
        System.out.println("\n\n<=======================================================================>\n\n");
    }
}
