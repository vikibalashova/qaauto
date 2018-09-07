package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;



public class LlinkedinSearchPage extends BasePage {
    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultTotal;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]" )
    private List<WebElement> searchResult;
    private Iterable<? extends WebElement> searchResults;


    /**
     * constructor of LlinkedinSearchPage class.
     */

    public LlinkedinSearchPage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchResultTotal, 10);
    }

    public boolean isLoaded() {
            return searchResultTotal.isDisplayed()
                    && getCurrentPageTitle().contains("| Поиск | LinkedIn")
                    && getCurrentPageUrl().contains("search/results/index/");
    }

    public int getSearchResultsCount() {
        return searchResult.size();
    }

    public List<String> getSearchResultsList(){
        List<String> searchResultsList = new ArrayList<String>();
        for(WebElement searchResult : searchResults){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;

    }
}
