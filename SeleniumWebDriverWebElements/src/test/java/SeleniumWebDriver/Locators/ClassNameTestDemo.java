package SeleniumWebDriver.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ClassNameTestDemo {
	
	WebDriver driver;
	@Test
	public void TestDemo() throws Exception {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/");

	    Thread.sleep(1000);
	    try {
	        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    } catch (Exception e) {
	        System.out.println("Cookie popup not displayed.");
	    }

	    driver.findElement(By.xpath("//a[@aria-label='Link to Vitamin Drinks category']")).click();
	    driver.findElement(By.className("ProductCardImage-module_innerImage__o8dqW")).click();

	    String BrowserTitle = driver.getCurrentUrl();
	    System.out.println("Browser title:"+BrowserTitle);

	    driver.navigate().back();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println("after clicking back:"+BrowserTitle);

	    driver.navigate().refresh();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println("after refreshing :"+BrowserTitle);

	    driver.navigate().forward();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println("after clicking forward:"+BrowserTitle);
	}



}
