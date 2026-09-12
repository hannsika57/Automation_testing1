package pageobjectmodel.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;

public class TestCases {
		
		@Test
		public void TestValidLogin() {
			WebDriver driver=BrowserFactory.startBrowser("Chrome",
					"https://www.saucedemo.com/");
			LoginPage loginJotForm = PageFactory.initElements(driver,LoginPage.class);
			loginJotForm.login_Jotform("standard_user", "secret_sauce");
			
			driver.quit();
		}
	


}
