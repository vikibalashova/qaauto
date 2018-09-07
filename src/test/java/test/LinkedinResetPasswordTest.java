package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinRequestPasswordResetPage;
import page.LinkedinSetNewPasswordPage;

import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest extends BaseTest{


    @Test
    public void successfulResetPasswordTest() throws InterruptedException {
        Assert.assertTrue(linkedinLoginPage.isLoaded(), "LoginPage is not loaded.");
        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isLoaded(), "RequestPasswordResetPage is not loaded.");
        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.findAccount("vikiqa8@gmail.com");

        sleep(180000);

        Assert.assertTrue(linkedinPasswordResetSubmitPage.isLoaded(), "PasswordResetSubmitPage is not loaded.");
        //Navigate to URL from email manually
        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isLoaded(), "SetNewPasswordPage is not loaded.");
    }
}
