package pageobjectmodel.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;

public class TestCases {
	@Test
	public void TestValidLogin() {
		WebDriver driver=BrowserFactory.startBrowser("Chrome",
				"https://www.demoblaze.com/index.html");
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.login_demoblaze("hannsika123", "Hanns@#14");
		//Thread.sleep(9000);
		driver.quit();
	}

}
