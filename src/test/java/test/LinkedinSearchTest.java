package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LlinkedinSearchPage;

import java.util.List;

public class LinkedinSearchTest extends BaseTest {

    @Test
    public void basicSearchTest(){
        String searchTerm = "HR";

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login( "vikiqa8@gmail.com", "viktori11");
        Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded.");
        LlinkedinSearchPage linkedinSearchPage = linkedinHomePage.search(searchTerm); // хотим попасть на ст. поиска
        Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page is not loaded.");
        Assert.assertEquals(linkedinSearchPage.getSearchResultsCount(), 10, "Search results count is wrong.");

        List<String> searchResults = linkedinSearchPage.getSearchResultsList();

        for (String searchResult : searchResults){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "searchTerm" + searchTerm +"not found in: \n" +searchResults);
        }









    }
}
