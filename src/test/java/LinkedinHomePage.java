import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {
    private WebDriver browser;
    private WebElement profileNavigationItem;

    public LinkedinHomePage(WebDriver browser) {
        this.browser = browser;
        this.initElements();
    }

    private void initElements() {
        this.profileNavigationItem = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));
    }

    public boolean isProfileNavigationItemDisplayed() {
        return this.profileNavigationItem.isDisplayed();
    }
}

