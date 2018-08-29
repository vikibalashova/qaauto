import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LlinkedinSearchPage extends BasePage {
    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultTotal;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]" )
    private List<WebElement> searchResult;

    public LlinkedinSearchPage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);}

    public boolean isLoaded() {
            return searchResultTotal.isDisplayed()
                    && getCurrentPageTitle().contains("| Поиск | LinkedIn")
                    && getCurrentPageUrl().contains("search/results/index/");
    }

    public int getSearchResultsCount() {
        return searchResult.size();
    }
}
