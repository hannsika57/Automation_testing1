package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenshotDemo1 {
		
		public static void main(String[] args) throws IOException{
			ChromeDriver driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://testautomationpractice.blogspot.com/");
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/practice1.png"));
			System.out.println("Captured screenshot");
			driver.quit();
					
		}

	


}
