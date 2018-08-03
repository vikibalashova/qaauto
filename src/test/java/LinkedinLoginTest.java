import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    @Test
    public void successfulLoginTest(){


    }
    @Test
    public void negativelLoginTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        WebElement userEmailField = browser.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = browser.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = browser.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("password");
        signInButton.click();

        sleep(3000);

        WebElement alertBox = browser.findElement(By.xpath("//div[@ role='alert']"));
        Assert.assertEquals(alertBox.getText(),  "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert box has incorrect message");


    }
}
