package LocatorsDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EasyCalculationTagName {
	
	public static void main(String[] args) throws Exception{
		
		WebDriver driver;
		String baseURl="https://www.easycalculation.com/date-day/age-calculator.php";
		driver=new ChromeDriver();
		driver.navigate().to(baseURl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No.of links :"+allLinks.size());
		
		for(WebElement ele: allLinks) {
			System.out.println(ele.isDisplayed());
			System.out.println(ele.isEnabled());
			System.out.println(ele.getAttribute("href"));	
		}
		
		
		driver.findElement(By.id("i21")).sendKeys("05");
		driver.findElement(By.id("i22")).sendKeys("07");
		driver.findElement(By.id("i23")).sendKeys("2006");
		driver.findElement(By.xpath("//input[@name='but']")).click();
		
		//To retrive values 
		String age = driver.findElement(By.id("r1")).getAttribute("value");
		System.out.println("\nYour age is :"+age);
		
		String ageInDays=driver.findElement(By.xpath("//input[@id='r4']")).getAttribute("value");
		System.out.println("Your Age in Days :"+ageInDays);
		
		String ageInHours=driver.findElement(By.name("val2")).getAttribute("value");
		System.out.println("Your Age in Hours :"+ageInHours);
		
		String ageInMin=driver.findElement(By.id("r2")).getAttribute("value");
		System.out.println("Your Age in Minutes :"+ageInMin);
		
		
		driver.quit();
		
	}


}
