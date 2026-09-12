package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  TestAutomationRadioButtons{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void TestDemo() throws Exception {

        Thread.sleep(3000);

        // Enter employee name
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Hannsika");
        Thread.sleep(2000);
        System.out.println("Employee name entered");

        // Select Female radio button
        WebElement female = driver.findElement(By.id("female"));
        female.click();

        // Verify Female is selected
        boolean femaleStatus = female.isSelected();
        System.out.println("Female selected: " + femaleStatus);
        Assert.assertTrue(
            femaleStatus,
            "Female radio button is not selected"
        );

        // Verify Male is not selected
        WebElement male = driver.findElement(By.id("male"));

        boolean maleStatus = male.isSelected();

        System.out.println("Male selected: " + maleStatus);

        Assert.assertFalse(
            maleStatus,
            "Male radio button is selected"
        );

        // Check Female radio button properties
        System.out.println("Female displayed: " + female.isDisplayed());

        System.out.println("Female enabled: " + female.isEnabled());

        // Submit registration
        WebElement submit = driver.findElement(
            By.xpath("//button[contains(text(),'Submit')]")
        );

        submit.click();

        System.out.println("Registration submitted");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}