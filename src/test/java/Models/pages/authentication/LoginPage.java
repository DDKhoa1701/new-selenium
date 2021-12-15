package Models.pages.authentication;

import Models.components.global.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private static final By usernameSelector = By.id("username");
    private static final By passwordSelector = By.id("password");
    private static final By loginBtnSelector = By.cssSelector ("button[type='submit']");

    private final FooterComponent footerComp;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        footerComp = new FooterComponent (driver);
    }

    private WebElement usernameElement(){
       return driver.findElement(usernameSelector);
   }

   public LoginPage inputUsername(String usernameStr){
        usernameElement ().sendKeys (usernameStr);
        return this;
   }

    private WebElement passwordElement(){
        return driver.findElement(passwordSelector);
    }

    public LoginPage inputPassword(String passwordStr){
        passwordElement ().sendKeys (passwordStr);
        return this;
    }


    private WebElement loginButtonElement (){
        return driver.findElement(loginBtnSelector);
    }

    public LoginPage clickOnLoginButton(){
        loginButtonElement ().click ();
        return this;
    }
    public FooterComponent footerComp(){
        return this.footerComp;
    }
}

