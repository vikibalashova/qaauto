import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinSearchTest {
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    @Test
    public void basicSearchTest(){
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.loginReturnHomePage( "vikiqa8@gmail.com", "viktori11");
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
        LlinkedinSearchPage linkedinSearchPage = linkedinHomePage.search("HR"); // хотим попасть на ст. поиска
        Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page is not loaded.");
        Assert.assertEquals(linkedinSearchPage.getSearchResultsCount(), 10, "Search results count is wrong.");







    }
}
