package SeleniumWebDriver.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PartialLinkText {
	WebDriver driver;
	int Total=0;
	@BeforeTest
	public void setUp() throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/");
		Thread.sleep(5000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookie pop up not displayed");
		}	
	}
	
	@Test
	public void findElementByLinkText() throws Exception {
		
		driver.findElement(By.partialLinkText("Vitamins")).click();
		java.util.List<WebElement> links=driver.findElements(By.xpath("//a"));
		
		int linksCount =links.size();
		System.out.println("Number of links :"+ linksCount);
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			String str=links.get(i).getText();
			String str1="Vitamins";
			if(str==str1) {
				driver.findElement(By.linkText("Vitamins")).click();
				driver.findElement(By.xpath("(//a[contains(@type,'button')])[4]")).click();
			}
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
