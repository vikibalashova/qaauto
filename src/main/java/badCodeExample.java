import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class badCodeExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello World!!"); //out not using
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.com");

        //browser.findElement(By.id("lst-ib")).sendKeys("Selenium");
        WebElement queryField = browser.findElement(By.name("q"));
        queryField.sendKeys("Selenium");
        queryField.sendKeys(Keys.ENTER);
        sleep(3000);

        //verify that results list contains 10 elements
        List<WebElement> serchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Results count:" + serchResults.size());

        if (serchResults.size() ==10){
            System.out.println("Results count is correct."); }
            else{
            System.out.println("Results count is incorrect."); }

       /* int ok = serchResults.size();
        if (ok == 10) {
            System.out.println("Results count is correct.");
        } else {
            System.out.println("Results count is incorrect."); }*/

        //verify that each result item contains searchterm
        // for each serchResults in serchResult List

        for (WebElement serchResult : serchResults) {
            String serchResultText = serchResult.getText();
            System.out.println(serchResultText);

            /*List<WebElement> element = browser.findElements(By.name("Selenium"));
            System.out.println("Find a result" + element);*/

            if (serchResultText.toLowerCase().contains("Selenium")){
                System.out.println("Searchterm found");}
               else {
                   System.out.println("Searchterm not found"); }
            }
        }
       // browser.close();

    }
