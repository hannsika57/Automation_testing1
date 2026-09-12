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

public class ElfSightDropDownCount{

    WebDriver driver = Helper.startBrowser("Chrome");

    @BeforeTest
    public void Setup() {
        driver.manage().window().maximize();
    }

    @Test
    public void DropDownLists() throws Exception {

        // 1. Elfsight Employee Registration Form
        driver.navigate().to("https://elfsight.com/online-form-builder/templates/html-employee-registration-form/");
        Thread.sleep(5000);

        List<WebElement> elfsightDropdowns =
                driver.findElements(By.tagName("select"));

        System.out.println("Number of Drop Downs: " + elfsightDropdowns.size());

        for (WebElement dropdown : elfsightDropdowns) {

            Select list = new Select(dropdown);

            List<WebElement> options = list.getOptions();

            System.out.println("Items Count: " + options.size());

            for (WebElement ele : options) {
                System.out.println("Item: " + ele.getText());
            }
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}