package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordResetSubmitPage extends BasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    /**
     * constructor of LinkedinPasswordResetSubmitPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedinPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(resendLinkButton, 10);
    }
    public boolean isLoaded() {
        /*try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();}*/

        return resendLinkButton.isDisplayed()
                && getCurrentPageTitle().contains("Please check your mail for reset password link.")
                && getCurrentPageUrl().contains("request-password-reset-submit");
    }
    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "vikiqa8@gmail.com";

        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordLink =
                StringUtils.substringBetween(message,
                        "нажмите <a href=\"<a href=&quot;",
                        ">[text]</a>").replace("amp;","");



        browser.get(resetPasswordLink);

        //ToDo
        return new LinkedinSetNewPasswordPage(browser);
    }

}
