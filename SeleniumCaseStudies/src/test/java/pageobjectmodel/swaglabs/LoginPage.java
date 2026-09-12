package pageobjectmodel.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

			WebDriver driver;

		    public LoginPage(WebDriver driver) {
		        this.driver = driver;
		    }

		    @FindBy(id ="user-name")
		    WebElement username;

		    @FindBy(id ="password")
		    WebElement password;

		    @FindBy(xpath = "//input[@id='login-button']")
		    WebElement loginButton;

		    public void login_Jotform(String uname, String pass) {

		        username.sendKeys(uname);
		        password.sendKeys(pass);
		        loginButton.click();
		        
		    }



}
