import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.*;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;

    //public static void main(String[] args) {
    @BeforeMethod
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(description = "Verify Log-in with valid credentials")
    public void LoginWithValidCredentials() {
             new LoginPage(driver)
                .NavigateToUrl()
                .LoginWithValidCredentials("emranalheeh@gmail.com", "123456")
                .ClickOnLogInBtn();
        Assert.assertEquals(driver.getTitle(),"FitGym Testing 01");
    }
    @Test(description = "Verify Log-in with Invalid credentials")
    public void LoginWithInValidCredentials() {
             new LoginPage(driver)
                .NavigateToUrl()
                .LoginWithInValidCredentials("emranalheeh2@gmail.com", "123456")
                .ClickOnLogInBtn();
        Assert.assertTrue(new LoginPage(driver).ErrorMessage().contains("Login failed"));
    }

    @AfterMethod
    public void Teardown() {
        driver.quit();
    }

}