package api_learning;

import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Lesson13_1 implements IUrls {

    private static final By inputFieldSelect = By.cssSelector ("input");
    private static final By btnSelect = By.cssSelector ("button");

    public static void main (String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver ();
        driver.get (baseUrl.concat (dynamicControlSlug));
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (30));

        try {


            // 1st FORM | Check example form
            By checkboxExampleFormSelect = By.cssSelector ("#checkbox-example");
            WebElement checkboxExampleFormElement = driver.findElement (checkboxExampleFormSelect);
            WebElement checkboxOption = checkboxExampleFormElement.findElement (inputFieldSelect);
            WebElement removeButtonElement = checkboxExampleFormElement.findElement (btnSelect);

            if (!checkboxOption.isSelected ())
                checkboxOption.click ();
            removeButtonElement.click ();
            WebElement progressBarExampleForm = driver.findElement (By.cssSelector ("#loading"));
            wait.until (ExpectedConditions.invisibilityOf (progressBarExampleForm));

            if (removeButtonElement.isSelected ())
                removeButtonElement.click ();
            removeButtonElement.click ();

            Thread.sleep (4000);
            System.out.println (checkboxExampleFormElement.getText ());


            // 2nd FORM | Input example form
            By inputExampleCheckbox = By.cssSelector ("#input-example");
            WebElement inputExampleFormElement = driver.findElement (inputExampleCheckbox);
            WebElement inputExampleInputFieldElement = inputExampleFormElement.findElement (inputFieldSelect);
            WebElement inputExampleButtonElement = inputExampleFormElement.findElement (btnSelect);

            if (!inputExampleInputFieldElement.isEnabled ())
                inputExampleButtonElement.click ();

            WebElement messageEnabled = driver.findElement (By.cssSelector ("#message"));
            wait.until(ExpectedConditions.visibilityOf (messageEnabled));

            if (messageEnabled.isDisplayed ())
                inputExampleInputFieldElement.sendKeys ("Tks,Mr Tu <3");
            inputExampleButtonElement.click ();


        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            driver.quit ();
        }
    }
}
