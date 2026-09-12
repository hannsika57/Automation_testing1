package radioButtons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmpRegJotForm {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.jotform.com/build/262511769568469?s=templates");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> d.findElements(
                By.cssSelector("#id_25 input[type='radio']")
        ).size() > 0);
    }

    @Test
    public void verifyRadioButtonSelection() {

        List<WebElement> options = driver.findElements(
                By.cssSelector("#id_25 input[type='radio']")
        );

        // Count and print the total number of radio buttons
        int totalRadioButtons = options.size();

        System.out.println("Total number of Type Of Work radio buttons: "
                + totalRadioButtons);

        // Select Permanent
        WebElement permanent = driver.findElement(
                By.cssSelector("label[for='input_25_0']")
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", permanent
        );

        int selectedCount = 0;
        int notSelectedCount = 0;

        // Verify and print the selection status
        for (WebElement option : options) {

            String value = option.getAttribute("value");

            if (option.isSelected()) {
                System.out.println(value + " is selected");
                selectedCount++;

                Assert.assertEquals(value, "Permanent");
            } else {
                System.out.println(value + " is not selected");
                notSelectedCount++;
            }
        }

        System.out.println("Total selected radio buttons: " + selectedCount);
        System.out.println("Total unselected radio buttons: " + notSelectedCount);

        Assert.assertEquals(selectedCount, 1);
        Assert.assertEquals(notSelectedCount, totalRadioButtons - 1);

        System.out.println("Permanent is selected.");
        System.out.println("All other Type Of Work options are not selected.");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}