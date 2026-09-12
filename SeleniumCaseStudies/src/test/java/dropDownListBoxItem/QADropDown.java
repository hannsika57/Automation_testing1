package dropDownListBoxItem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility1.Helper;

public class QADropDown {

    WebDriver driver = Helper.startBrowser("Chrome");

    @BeforeTest
    public void Setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void DropDownLists() throws Exception {

        driver.navigate().to(
                "https://www.qa-practice.com/forms/practice-form");

        Thread.sleep(3000);

        List<WebElement> dropdowns =
                driver.findElements(By.tagName("select"));


        System.out.println("Number of Drop Downs: "
                + dropdowns.size());
        // State
        Select state = new Select(dropdowns.get(0));

        System.out.println("Number of State Options: "
                + (state.getOptions().size() - 1));
        // Open State
        driver.findElements(By.cssSelector(".custom-dropdown-control")).get(0).click();
                

        Thread.sleep(500);

        // Select Rajasthan
        driver.findElement(
                By.cssSelector("[data-value='Rajasthan']")).click();

        Thread.sleep(1000);

        // Open City
        driver.findElements(
                By.cssSelector(".custom-dropdown-control")).get(1).click();

        Thread.sleep(500);

        // Get visible city options
        List<WebElement> cities =
                driver.findElements(
                        By.cssSelector(".custom-dropdown-option"));

        int count = 0;

        for (WebElement city : cities) {

            if (city.isDisplayed()
                    && !city.getText().trim().isEmpty()) {

                count++;

                System.out.println("City: "
                        + city.getText().trim());
            }
        }

        System.out.println("Number of City Options: " + count);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}