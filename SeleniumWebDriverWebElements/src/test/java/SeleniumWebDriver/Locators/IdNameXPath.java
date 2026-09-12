package SeleniumWebDriver.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IdNameXPath {
	WebDriver driver;
	String baseURL ="https://practicetestautomation.com/practice-test-login/";
	@Test
	public void ChromeBrowser() {
		driver =new ChromeDriver();
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		
		//Locators  Id Name Xpath
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		//how to copy XPath from developer tool
		//*[@id="submit"]
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	}
	
	
}