package pageobjectmodel.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;

public class TestCases {
	
	@Test
	public void TestValidLogin() {
		WebDriver driver=BrowserFactory.startBrowser("Chrome",
				"https://admin-demo.nopcommerce.com/login");
		LoginPage loginJotForm = PageFactory.initElements(driver,LoginPage.class);
		loginJotForm.login_Jotform("admin@yourstore.com", "admin");
		
		driver.quit();
	}
}
