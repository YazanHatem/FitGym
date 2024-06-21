package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private WebDriver driver ;
    private By SearchResult = By.xpath("(//div[@class='member-name mt-2'])[1]");

    public SearchResultPage(WebDriver driver){
        this.driver = driver ;
    }

    public String SearchResult(){
        return driver.findElement(this.SearchResult).getText();
    }
}
