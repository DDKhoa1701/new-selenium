package api_learning;

import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown implements IUrls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to Hovers page
            driver.get(baseUrl.concat(dropdownOptionPage));

            // Target Dropdown
            Select select = new Select(driver.findElement(By.id("dropdown")));

            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            select.selectByIndex(2);
            Thread.sleep(1000);

            select.selectByValue("1");
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
