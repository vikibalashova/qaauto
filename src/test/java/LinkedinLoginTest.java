import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
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

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                { "vikiqa8@gmail.com", "viktori11"},
                { "VIKIQA8@gmail.com", "viktori11"},
                { "someone@domain.com", "P@ssword123" }
        };
    }

    @Test(dataProvider = "validFieldsCombination" )
    public void successfulLoginTest(String userEmail, String userPass) {
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.loginReturnHomePage(userEmail, userPass);

        /*String pageTitle = browser.getTitle();
        String pageUrl = browser.getCurrentUrl();
        Assert.assertEquals(pageTitle, "LinkedIn", "Home page Title is wrong.");
        Assert.assertEquals(pageUrl, "https://www.linkedin.com/feed/", "Home page Url is wrong.");*/

        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "Home page is not loaded.");
    }

    /*@Test
    public void negativeLoginTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("a@b.c", "password");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }*/

    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                { "", ""},
                { "", "P@ssword123" },
                { "someone@domain.com", "" }
        };
    }

    @Test(dataProvider = "emptyFieldsCombination")
    public void validateEmptyUserEmailAndUserPassword(String userEmail, String userPass){
        linkedinLoginPage.loginReturnLoginPage(userEmail, userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded(),
                "User is not on login page.");
    }
    @DataProvider
    public Object[][] invalidDataFieldsCombination() {
        return new Object[][]{
                { "a",
                        "a",
                        "The text you provided is too short (the minimum length is 3 characters, your text contains 1 character).",
                        "The password you provided must have at least 6 characters."}
        };
    }
    @Test(dataProvider = "invalidDataFieldsCombination")
    public void validateUserEmailAndPassword(String userEmail,
                                             String userPass,
                                             String userEmailValidationText,
                                             String userPassValidationText) {
        LinkedinLoginSubmitPage linkedinLoginSubmitPage =
                linkedinLoginPage.loginReturnLoginSubmitPage(userEmail, userPass);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(),
                "User is not on LoginSubmit page.");

        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(),
                "User is not on login page.");
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(), userEmailValidationText,
                "userEmail field gas wrong validate message text");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserPasswordValidationText(), userPassValidationText,
                "userEmail field gas wrong validate message text");
    }


    @Test
    public void negativeEmailLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.loginReturnLoginSubmitPage("vikiqa8@gmail.com", " ");
    }
    @Test
    public void negativePassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.loginReturnLoginPage(" ", "password");
    }
    @Test
    public void negativeEmailAndWrongPassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.loginReturnLoginPage("vikiqa8@gmail.com", "pass");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }
    @Test
    public void negativeWrongEmailAndRightPassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.loginReturnLoginPage("viki@gmail.com", "password");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }
    @Test
    public void negativeNotAllEmailLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.loginReturnLoginPage("vikiqa8gmail.com", "password");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }


}

