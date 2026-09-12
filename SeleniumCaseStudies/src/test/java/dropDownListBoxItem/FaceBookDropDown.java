package dropDownListBoxItem;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility1.Helper;

public class FaceBookDropDown {

    @Test
    public void dropdowns() throws Exception {

        WebDriver driver = Helper.startBrowser("GC");

        driver.get("https://www.facebook.com/reg/");

        Thread.sleep(5000);

        // Find the dropdowns
        List<WebElement> dropdowns =
                driver.findElements(By.xpath("//*[@role='combobox']"));

        System.out.println("Total Number of Dropdowns: "
                + dropdowns.size());


        // Process each dropdown separately
        for (int i = 0; i < dropdowns.size(); i++) {

            System.out.println("\n");
            System.out.println("Dropdown " + (i + 1));
            System.out.println("\n");

            // Click current dropdown
            dropdowns.get(i).click();

            Thread.sleep(1000);

            // Find all option elements
            List<WebElement> allOptions =
                    driver.findElements(
                            By.xpath("//*[@role='option']")
                    );

            // Store only visible options
            List<WebElement> visibleOptions =
                    new ArrayList<WebElement>();

            for (WebElement option : allOptions) {

                if (option.isDisplayed()
                        && !option.getText().trim().isEmpty()) {

                    visibleOptions.add(option);
                }
            }

            // COUNT FIRST
            System.out.println("Number of Options: "
                    + visibleOptions.size());

            // DISPLAY OPTIONS
            System.out.println("Options:");

            for (WebElement option : visibleOptions) {

                System.out.println(option.getText().trim());
            }

            System.out.println("------------------------------");

        }

        driver.quit();
    }
}