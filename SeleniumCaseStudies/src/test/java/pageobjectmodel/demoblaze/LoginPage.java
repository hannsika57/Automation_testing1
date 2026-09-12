package pageobjectmodel.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginbtn;

    public void login_demoblaze(String uname, String pass) {
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginbtn.click();
    }
}