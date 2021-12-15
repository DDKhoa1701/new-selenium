package Models.components.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterComponentFactory {

    private final WebDriver driver;
    @FindBy(id = "page-footer")
    private WebElement footerTextElement;

    @FindBy(css = "#page-footer a")
    private WebElement footerLinkTextElement;

    public FooterComponentFactory (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (driver, this);
    }

    public String footerTexts () {
        return footerTextElement.getText ();
    }

    public String footerLink () {
        return footerLinkTextElement.getAttribute ("href");
    }
}
