package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends BasePage {
    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//input[@placeholder and @role]")
    private WebElement searchField;

    /**
     * constructor of LinkedinHomePage class.
     */

    public LinkedinHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);// this это вызов текущего класса
        waitUntilElementIsVisible(profileNavigationItem, 10);
    }

    public boolean isLoaded(){
        return profileNavigationItem.isDisplayed()
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentPageUrl().contains("https://www.linkedin.com/feed/");

    }

    public LlinkedinSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        return new LlinkedinSearchPage(browser);
    }
}

