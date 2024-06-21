import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.*;


import java.time.Duration;

public class SearchResultPageTest {
    private WebDriver driver ;
    @BeforeMethod
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(description = "Verify searching for the exist account")
    public void SearchExistingAccount(){
        SearchResultPage ResultPage = new LoginPage(driver)
                .NavigateToUrl()
                .LoginWithValidCredentials("emranalheeh@gmail.com","123456")
                .ClickOnLogInBtn().
                SearchExistingAccount("Emran   Alheeh");

        Assert.assertEquals(ResultPage.SearchResult(),"Emran Alheeh");


    }
    @AfterMethod
    public void Teardown() {
        driver.quit();
    }

}
