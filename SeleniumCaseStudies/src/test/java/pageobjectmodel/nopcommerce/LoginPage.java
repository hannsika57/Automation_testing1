package pageobjectmodel.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

		WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    @FindBy(id ="Email")
	    WebElement username;

	    @FindBy(id ="Password")
	    WebElement password;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginButton;

	    public void login_Jotform(String uname, String pass) {
	    	
	    	username.clear();
	        username.sendKeys(uname);
	        password.clear();
	        password.sendKeys(pass);
	        loginButton.click();
	        
	    }

	


}
