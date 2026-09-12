package javaScriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility1.Helper;

public class RediffDemo {

	    @Test
	    public void TestLogin() throws Exception {

	        WebDriver driver = Helper.startBrowser("Edge");

	        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

	        driver.findElement(By.id("login1")).sendKeys("sudhikshaa2006");

	        driver.findElement(By.id("password")).sendKeys("TestPassword123");

	        driver.findElement(By.name("proceed")).click();

	        Thread.sleep(3000);

	        String result = driver.findElement(By.tagName("body")).getText();

	        System.out.println("Result:");
	        System.out.println(result);

	        Assert.assertTrue(result.contains("Please verify that you are a human."));

	        driver.quit();
	    }

}
