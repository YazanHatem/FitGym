package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private  WebDriver driver;
    private final By Email = By.xpath("//input[@id='email']");
    private final By Password = By.xpath("//input[@id='password']");
    private final By LoginBtn = By.xpath("//button[normalize-space()='Login']");
    private final By ErrorMessage = By.xpath("//div[@role='alert']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public  LoginPage NavigateToUrl(){
        driver.get("https://fitnet-org-devtest-01.fit-network.com/login");
        driver.manage().window().maximize();
        return this ;
    }
    public LoginPage LoginWithValidCredentials(String Email , String Password){
        driver.findElement(this.Email).sendKeys(Email);
        driver.findElement(this.Password).sendKeys(Password);
        return this;
    }

    public LoginPage LoginWithInValidCredentials(String Email , String Password){
        driver.findElement(this.Email).sendKeys(Email);
        driver.findElement(this.Password).sendKeys(Password);
        return this;
    }
    public String ErrorMessage(){
        return driver.findElement(this.ErrorMessage).getText();
    }

    public HomePage ClickOnLogInBtn() {
        driver.findElement(this.LoginBtn).click();
        return new HomePage(driver);
    }

}
