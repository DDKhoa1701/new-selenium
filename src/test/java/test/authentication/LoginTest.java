package test.authentication;

import Models.pages.authentication.LoginPage;
import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LoginTest implements IUrls {

    public static void main (String[] args) {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver ();

        String loginUrl = baseUrl.concat (loginSlug);
        driver.get (loginUrl);

        try {
            //Create new Page Model Object
            LoginPage loginPage = new LoginPage (driver);
            loginPage
                    .inputUsername (usernameStr)
                    .inputPassword (passwordStr)
                    .clickOnLoginButton ();

            System.out.println (loginPage.footerComp ().footerTexts ());
            System.out.println (loginPage.footerComp ().footerLink ());

            Thread.sleep (2000);

        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            driver.quit ();
        }
    }
}
