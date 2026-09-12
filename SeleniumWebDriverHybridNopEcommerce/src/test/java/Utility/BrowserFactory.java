package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver startBrowser(
            String browserName,
            String appUrl) {

        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome")
                || browserName.equalsIgnoreCase("GC")
                || browserName.equalsIgnoreCase("Google Chrome")) {

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Edge")
                || browserName.equalsIgnoreCase("EG")
                || browserName.equalsIgnoreCase("Microsoft Edge")) {

            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")
                || browserName.equalsIgnoreCase("FF")
                || browserName.equalsIgnoreCase("Mozilla Firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browserName
            );
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        driver.get(appUrl);

        return driver;
    }

    public static void closeBrowser(WebDriver driver) {

        if (driver != null) {
            driver.quit();
        }
    }
}