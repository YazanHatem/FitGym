package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver ;
    private By Search = By.xpath("//input[@placeholder='Search...']");

    public HomePage(WebDriver driver){
        this.driver = driver ;
    }

    public SearchResultPage SearchExistingAccount(String Name){
        driver.findElement(this.Search).sendKeys(Name);
        driver.findElement(this.Search).sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
