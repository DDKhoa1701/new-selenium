package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver () {

        String currentProjectDirectoryLocation = System.getProperty ("user.dir");

        String chromeDriverLocation = null;
        if (OS.isFamilyWindows ())
            chromeDriverLocation = currentProjectDirectoryLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        if (OS.isFamilyMac ())
            chromeDriverLocation = currentProjectDirectoryLocation + "/src/test/resources/drivers/chromedriver";
        if (chromeDriverLocation == null)
            throw new IllegalArgumentException ("Can't detect current OS");
        System.setProperty ("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions ();
        chromeOptions.addArguments ("--incognito");

        WebDriver driver = new ChromeDriver (chromeOptions);
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (100));
        return driver;
    }
}


