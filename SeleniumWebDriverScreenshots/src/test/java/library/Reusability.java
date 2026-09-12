package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {
	
	public static void CapturedScreenshot(WebDriver driver,String ScreenshotName) {
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" +ScreenshotName +".png"));
			System.out.println("captured screenshot by slenium web driver");
		}catch (Exception e){
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
	}

}
