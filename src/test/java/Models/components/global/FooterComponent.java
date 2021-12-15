package Models.components.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FooterComponent {

    private final WebDriver driver;
    private static final By footerTextSelector = By.id ("page-footer");
    private static final By footerLinkTextSelector = By.cssSelector ("page-footer a");

    public FooterComponent (WebDriver driver) {
        this.driver = driver;
    }

    public String footerTexts(){
        return driver.findElement (footerTextSelector).getText ();

    }

    public String footerLink(){
        return driver.findElement (footerLinkTextSelector).getAttribute ("href");
    }
}
