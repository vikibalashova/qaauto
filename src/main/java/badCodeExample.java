import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class badCodeExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello World!!");
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.com");
        //browser.findElement(By.id("lst-ib")).sendKeys("Selenium");
        WebElement queryField = browser.findElement(By.name("q"));
        queryField.sendKeys("Selenium");
        queryField.sendKeys(Keys.ENTER);
        sleep(3000);

        //verify that results list contains 10 elements
         List<WebElement> serchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
         System.out.println("Results count:" +serchResults.size());

        //verify that each result item contains searchterm

         for(WebElement serchResult: serchResults){
            String serchResultText = serchResult.getText();
            System.out.println(serchResultText);

         }

      browser.close();

    }
}