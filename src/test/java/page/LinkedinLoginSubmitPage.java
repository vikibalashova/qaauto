package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends BasePage{
    @FindBy(xpath = "//div[@ role='alert']")
    private WebElement alertBox;

    @FindBy(xpath = "//*[@id='session_key-login-error']")
    private WebElement userEmailValidationText;

    @FindBy(xpath = "//*[@id='session_password-login-error']")
    private WebElement userPasswordValidationText;


     /**
     * constructor of LinkedinLoginSubmitPage class.
     */

    public LinkedinLoginSubmitPage(WebDriver browser){
        this.browser=browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(alertBox, 10);
    }

    public String getAlertBoxText(){
        return alertBox.getText();
    }

   // public String getCurrentPageTitle() {return browser.getTitle();}

   // public String getCurrentPageUrl() {return browser.getCurrentUrl();}

    public boolean isLoaded(){
        return alertBox.isDisplayed()
                && getCurrentPageTitle().contains("Sign In to LinkedIn")
                && getCurrentPageUrl().contains("/uas/login-submit");
    }
    public String getUserEmailValidationText(){
        return userEmailValidationText.getText();
    }
    public String getUserPasswordValidationText(){
        return userPasswordValidationText.getText();
    }

}
