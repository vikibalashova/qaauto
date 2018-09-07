package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Oject  LinkedinLoginPage
 */
public class LinkedinLoginPage extends BasePage {
    @FindBy (xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;


    /**
     * Summery: constructor of LinkedinLoginPage class(for userEmail and  userPass)
     * @param browser - WebDriver instance from test.(FireFox)
     */
    public LinkedinLoginPage(WebDriver browser) {    //дефолтный конструктор класса
        this.browser= browser;
        PageFactory.initElements(browser, this);//создает таблица со занчениеми(тип локатора, локатор, by) для поиска этого елемента когда к нему обращаються;
    }

    /**
     * Summery: that enters userEmail/String userPass and click on signIn button
     * @param userEmail - String with user email
     * @param userPass - String with user password
     * @param <T> - Generic type to return corresponding pageOject
     * @return  - either LinkedinHomePage or LinkedinLoginSubmitPage or LinkedinLoginPage pageOject
     */

    public <T> T login(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        if (getCurrentPageUrl().contains("/feed")){
            return(T) new LinkedinHomePage(browser);
        }
        if(getCurrentPageUrl().contains("/uas/login-submit")){
            return(T) new LinkedinLoginSubmitPage(browser);
        } else{
            return(T) new LinkedinLoginPage(browser);
        }}

    public boolean isLoaded(){
        return userEmailField.isDisplayed()
                    && getCurrentPageTitle().contains("LinkedIn: Log In or Sign Up"); //getCurrentPageTitle().contains("LinkedIn: Log In or Sign Up");
                   // && getCurrentPageUrl().equals("https://www.linkedin.com/");
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {

        //sleep

        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(browser);
    }
    }


