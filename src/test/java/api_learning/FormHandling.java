package api_learning;

import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling implements IUrls {

    private static final By usernameSelect = By.id ("username"); // Find Element by ID
    private static final By passwordSelect = By.cssSelector ("#password"); // Find Element by css ("#..")
    private static final By loginButtonSelect = By.cssSelector ("[type='submit']"); // Find Element by css ("#..")
    private static final By secureLoginSelect = By.cssSelector ("[href='/logout']"); // Find Element by css ("#..")

    public static void main (String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver ();
        //Open target Url
        String loginUrl = baseUrl.concat (loginSlug);
        driver.get (loginUrl);
        try {
            String usernameStr = "tomsmith";
            String passwordStr = "SuperSecretPassword!";
            login (driver, usernameStr, passwordStr);
        } catch (Exception ignore) {
        }
        String secureSlug = baseUrl.concat (secureLoginSlug);
        driver.get (secureSlug);
        try {
//            WebElement secureLogin = driver.findElement (secureLoginSelect);
//            secureLogin.click ();
             secure (driver);
        } catch (Exception ignore) {
        } finally {
            //Quit
            driver.quit ();
        }
    }
    private static void login (WebDriver driver, String username, String password) {
        WebElement usernameElement = driver.findElement (usernameSelect);
        WebElement passwordElement = driver.findElement (passwordSelect);
        WebElement loginButtonElement = driver.findElement (loginButtonSelect);
        //API : sendKeys(String str)
        usernameElement.sendKeys (username);
        passwordElement.sendKeys (password);
        loginButtonElement.click ();
    }
    private static void secure (WebDriver driver) {
        WebElement secureLogin = driver.findElement (secureLoginSelect);
        secureLogin.click ();
    }
}



