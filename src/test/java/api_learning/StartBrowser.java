package api_learning;

import Url.IUrls;
import driver.DriverFactory;

import org.openqa.selenium.WebDriver;


public class StartBrowser implements IUrls {


    public static void main (String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        //Launch target
        driver.get (baseUrl);

        //Quit the session
         driver.quit ();
    }
}
