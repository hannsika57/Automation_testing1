package LocatorsDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EasyCalculationLinkText {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.easycalculation.com/");
    }

    @Test
    public void findElementByLinkText() {
    	
        /*WebElement formulas = driver.findElement(By.xpath("//a[normalize-space()='Formulas']"));
        String formulasUrl = formulas.getAttribute("href");
        System.out.println("Formulas URL: " + formulasUrl);
        driver.navigate().to(formulasUrl);*/
        
        //Link text
        driver.findElement(By.linkText("Charts")).click();
        
        //partial Link text
        driver.findElement(By.partialLinkText("Form")).click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());

        List<WebElement> links =driver.findElements(By.tagName("a"));               
        System.out.println("Number of links: " + links.size());

        for (WebElement link : links) {
            String linkName = link.getText().trim();
            if (!linkName.isEmpty()) {
                System.out.println(linkName);
            }
        }
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}