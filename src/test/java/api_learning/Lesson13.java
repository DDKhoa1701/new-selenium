package api_learning;

import Url.IUrls;
import driver.DriverFactory;
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lesson13 implements IUrls {
    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.getChromeDriver ();
        driver.get (baseUrl.concat (dynamicControlSlug));

        try{
            //LinkText selector
            By powerByLinkSelect = By.linkText ("Elemental Selenium");
            WebElement powerByLinkElement = driver.findElement (powerByLinkSelect);

            System.out.println ("Link text: " + powerByLinkElement.getText ());
            System.out.println ("Power by Href: " + powerByLinkElement.getAttribute ("href"));
            System.out.println ("Link text target: " + powerByLinkElement.getAttribute ("target"));

            //Get current URL and Page Title
            System.out.println ("Current URL: "+ driver.getCurrentUrl ());
            System.out.println ("Current Title: "+ driver.getTitle ());

            // Wait Strategies
            By checkBoxExampleBtnSelect = By.cssSelector ("#checkbox-example button");

            // Click on Remove button
            driver.findElement (checkBoxExampleBtnSelect).click ();

            // Progress bar
            WebElement progressBar = driver.findElement (By.cssSelector ("#loading"));
            WebDriverWait wait =  new WebDriverWait (driver, Duration.ofSeconds (10));
            wait.until (ExpectedConditions.invisibilityOf (progressBar));

            // Click on Add button
            driver.findElement (checkBoxExampleBtnSelect).click ();
            Thread.sleep (3000);

        }finally {
            driver.quit ();
        }
    }
}
