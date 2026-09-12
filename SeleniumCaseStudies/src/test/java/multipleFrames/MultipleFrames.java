package multipleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility1.Helper;

public class MultipleFrames {

    @Test
    public void Frames() throws Exception {

        WebDriver driver = Helper.startBrowser("GC");

        // 1. Launch browser and open iframe page
        driver.get("file:///C:/IFrames/iframe.html");
        Thread.sleep(3000);

        // 2. Identify available frames
        int totalFrames = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames: " + totalFrames);

        Assert.assertEquals(totalFrames, 3);


        // 3. Switch to first frame using WebElement
        WebElement firstFrame =
                driver.findElements(By.tagName("iframe")).get(0);

        driver.switchTo().frame(firstFrame);

        // 4. Perform an action inside first frame
        String firstFrameText = driver.findElement(By.tagName("body")).getText();

        System.out.println("First Frame Text:");
        System.out.println(firstFrameText.substring(0,
                Math.min(firstFrameText.length(), 150)));

        Assert.assertTrue(firstFrameText.contains("Selenium"));

        // 5. Return to main page
        driver.switchTo().defaultContent();


        // 6. Switch to another frame using NAME
        driver.switchTo().frame("easycalculation");

        // Perform action inside EasyCalculation frame
        String easyText = driver.findElement(By.tagName("body")).getText();

        System.out.println("EasyCalculation Frame Loaded");
        Assert.assertTrue(easyText.contains("Free Calculators"));

        // 7. Return to main page
        driver.switchTo().defaultContent();


        // 8. Switch to another frame using INDEX
        driver.switchTo().frame(2);

        // Perform action inside Practice Test Automation frame
        String loginText = driver.findElement(By.tagName("body")).getText();

        System.out.println("Practice Test Automation Frame Loaded");

        Assert.assertTrue(loginText.contains("Test login"));

        // Enter login details
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        driver.findElement(By.id("submit")).click();

        Thread.sleep(3000);

        System.out.println("Login completed inside third frame");

        // 9. Return to main page
        driver.switchTo().defaultContent();


        // 10. Navigate to DemoQA Nested Frames page
        driver.get("https://demoqa.com/nestedframes");

        Thread.sleep(3000);

        System.out.println("DemoQA Nested Frames Page Opened");


        // 11. Switch to Parent Frame
        driver.switchTo().frame("frame1");

        String parentText = driver.findElement(By.tagName("body")).getText();

        System.out.println("Parent Frame Text:");
        System.out.println(parentText);

        Assert.assertTrue(parentText.contains("Parent frame"));


        // 12. Switch to Child Frame
        WebElement childFrame =
                driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(childFrame);

        String childText = driver.findElement(By.tagName("body")).getText();

        System.out.println("Child Frame Text:");
        System.out.println(childText);


        // 13. Validate Child Frame text
        Assert.assertTrue(childText.contains("Child Iframe"));

        System.out.println("Child Frame text validated successfully");


        // 14. Return to Parent Frame
        driver.switchTo().parentFrame();

        String parentFrameText =
                driver.findElement(By.tagName("body")).getText();

        System.out.println("Back to Parent Frame:");
        System.out.println(parentFrameText);


        // 15. Validate Parent Frame text
        Assert.assertTrue(parentFrameText.contains("Parent frame"));

        System.out.println("Parent Frame text validated successfully");


        // 16. Return to main page and verify
        driver.switchTo().defaultContent();

        String currentURL = driver.getCurrentUrl();

        System.out.println("Back to Main Page");
        System.out.println("Current URL: " + currentURL);

        Assert.assertTrue(currentURL.contains("demoqa.com/nestedframes"));

        System.out.println("Successfully returned to main page");
        Thread.sleep(10000);


        driver.quit();
    }
}