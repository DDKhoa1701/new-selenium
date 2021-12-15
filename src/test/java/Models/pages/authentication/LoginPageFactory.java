package Models.pages.authentication;

import Models.components.global.FooterComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    private final WebDriver driver;
    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtnElement;


    private final FooterComponent footerComp;

    public LoginPageFactory (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (driver, this);
        footerComp = new FooterComponent (driver);
    }

    private WebElement usernameElement () {
        return usernameElement;
    }

    public LoginPageFactory inputUsername (String usernameStr) {
        usernameElement.sendKeys (usernameStr);
        return this;
    }

    private WebElement passwordElement () {
        return passwordElement;
    }

    public LoginPageFactory inputPassword (String passwordStr) {
        passwordElement.sendKeys (passwordStr);
        return this;
    }


    private WebElement loginButtonElement () {
        return loginBtnElement;
    }

    public LoginPageFactory clickOnLoginButton () {
        loginBtnElement.click ();
        return this;
    }

    public FooterComponent footerComp () {
        return this.footerComp;
    }
}

