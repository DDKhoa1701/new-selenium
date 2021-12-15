package Models.test.api_learning;

import Models.pages.api_learning.FloatingMenuPage;
import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class FloatingMenuTest implements IUrls {

    public static void main (String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver ();
        driver.get (baseUrl.concat (floatingPageSlug));

        try {
            FloatingMenuPage floatingMenuPage = new FloatingMenuPage (driver);
            floatingMenuPage.scrollToBottom ();
            Thread.sleep (2000);
            floatingMenuPage.scrollToTop ();
            Thread.sleep (2000);
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            driver.quit ();
        }

    }

}


