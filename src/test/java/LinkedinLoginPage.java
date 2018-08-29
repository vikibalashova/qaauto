import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends BasePage {
    @FindBy (xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver browser) {    //дефолтный конструктор класса
        this.browser= browser;
        PageFactory.initElements(browser, this);//создает таблица со занчениеми(тип локатора, локатор, by) для поиска этого елемента когда к нему обращаються;
    }

    public LinkedinLoginSubmitPage loginReturnLoginSubmitPage(String userEmail, String userPass){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return new LinkedinLoginSubmitPage(browser);
    }

    public LinkedinHomePage loginReturnHomePage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinHomePage(browser);
    }

    public LinkedinLoginPage loginReturnLoginPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginPage(browser);
    }

    public boolean isLoaded(){
        return userEmailField.isDisplayed()
                    && getCurrentPageTitle().contains("LinkedIn: Log In or Sign Up") //getCurrentPageTitle().contains("LinkedIn: Log In or Sign Up");
                    && getCurrentPageUrl().contains("/feed/");
    }


}
