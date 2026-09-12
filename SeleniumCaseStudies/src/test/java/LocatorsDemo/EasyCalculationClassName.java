package LocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class EasyCalculationClassName {

	public class ClassNameTestDemo {
		
		WebDriver driver;
		@Test
		public void TestDemo() throws Exception {
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.navigate().to("https://www.easycalculation.com/");

		    Thread.sleep(1000);

		    driver.findElement(By.partialLinkText("Cha")).click();

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

}
