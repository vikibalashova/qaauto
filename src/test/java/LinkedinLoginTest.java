import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver browser;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("vikiqa8@gmail.com", "viktori11");

        sleep(3000);

        String pageTitle = browser.getTitle();
        String pageUrl = browser.getCurrentUrl();
        Assert.assertEquals(pageTitle, "LinkedIn", "Home page Title is wrong.");
        Assert.assertEquals(pageUrl, "https://www.linkedin.com/feed/", "Home page Url is wrong.");
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(browser);
        Assert.assertTrue(linkedinHomePage.isProfileNavigationItemDisplayed(), " 'profileNavigationItem' is not displayed on Home page.");
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("a@b.c", "password");

        sleep(3000);

        WebElement alertBox = browser.findElement(By.xpath("//div[@ role='alert']"));
        Assert.assertEquals(alertBox.getText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }
}
