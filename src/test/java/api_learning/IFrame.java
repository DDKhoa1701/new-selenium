package api_learning;

import Url.IUrls;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame implements IUrls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to Hovers page
            driver.get(baseUrl.concat(iFramePage));

            // Switch to iFarme
            driver.switchTo().frame(driver.findElement(By.cssSelector("[id$='ifr']")));

            // Clear default text then input the new ones
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            editorInputElem.sendKeys("This is test ......");

            Thread.sleep(2000);

            // Switch back to default frame
            driver.switchTo().defaultContent();

            // Logic continue here....

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
