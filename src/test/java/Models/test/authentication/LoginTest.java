package Models.test.authentication;

import Models.pages.authentication.LoginPage;
import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest implements IUrls {

    @Test
    public void loginWithCorrectCreds(){
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver ();

        String loginUrl = baseUrl.concat (loginSlug);
        driver.get (loginUrl);

        try{
            // Create new Page Model Object
            LoginPage loginPage = new LoginPage (driver);
            loginPage.inputUsername (usernameStr);
            loginPage.inputPassword (passwordStr);
            loginPage.clickOnLoginButton ();

            Thread.sleep (2000);
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            driver.quit ();
        }
    }

    @Test
    public void loginWithInCorrectCreds(){
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPass";
        WebDriver driver = DriverFactory.getChromeDriver ();

        String loginUrl = baseUrl.concat (loginSlug);
        driver.get (loginUrl);

        try{
            // Create new Page Model Object
            LoginPage loginPage = new LoginPage (driver);
            loginPage.inputUsername (usernameStr);
            loginPage.inputPassword (passwordStr);
            loginPage.clickOnLoginButton ();

            Thread.sleep (2000);
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            driver.quit ();
        }
    }

}
