package Models.pages.api_learning;

import Models.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class FloatingMenuPage extends BasePage {

    private final JavascriptExecutor javascriptExecutor;
    private static final By headingSelector = By.tagName ("h3");
    private static final By menuSelector = By.id("menu");

    public FloatingMenuPage (WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }
}

