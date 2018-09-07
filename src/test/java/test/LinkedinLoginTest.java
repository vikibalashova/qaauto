package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinLoginSubmitPage;

public class LinkedinLoginTest extends BaseTest {

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
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPass);

        /*String pageTitle = browser.getTitle();
        String pageUrl = browser.getCurrentUrl();
        Assert.assertEquals(pageTitle, "LinkedIn", "Home page Title is wrong.");
        Assert.assertEquals(pageUrl, "https://www.linkedin.com/feed/", "Home page Url is wrong.");*/

        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "Home page is not loaded.");
    }

    /*@Test
    public void negativeLoginTest() {
        page.LinkedinLoginPage linkedinLoginPage = new page.LinkedinLoginPage(browser);
        linkedinLoginPage.login("a@b.c", "password");

        page.LinkedinLoginSubmitPage linkedinLoginSubmitPage = new page.LinkedinLoginSubmitPage(browser);
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
        linkedinLoginPage.login(userEmail, userPass);
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
                linkedinLoginPage.login(userEmail, userPass);
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
        linkedinLoginPage.login("vikiqa8@gmail.com", " ");
    }
    @Test
    public void negativePassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login(" ", "password");
    }
    @Test
    public void negativeEmailAndWrongPassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("vikiqa8@gmail.com", "pass");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }
    @Test
    public void negativeWrongEmailAndRightPassLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("viki@gmail.com", "password");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }
    @Test
    public void negativeNotAllEmailLoginTest(){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
        linkedinLoginPage.login("vikiqa8gmail.com", "password");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. " +
                "Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");
    }


}

