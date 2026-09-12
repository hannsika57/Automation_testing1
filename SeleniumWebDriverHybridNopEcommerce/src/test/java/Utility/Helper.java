package Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

    public static void capturedScreenShot(WebDriver driver) {

        try {

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File folder =
                    new File("./ScreenShots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File destination = new File(
                    "./ScreenShots/NopCommerce_"
                            + getCurrentDateTime()
                            + ".png"
            );

            FileUtils.copyFile(
                    source,
                    destination
            );

            System.out.println(
                    "Screenshot captured on failure: "
                            + destination.getAbsolutePath()
            );

        } catch (Exception e) {

            System.out.println(
                    "Exception while taking screenshot: "
                            + e.getMessage()
            );
        }
    }

    private static String getCurrentDateTime() {

        DateFormat customFormat =
                new SimpleDateFormat(
                        "MM_dd_yyyy_HH_mm_ss"
                );

        Date currentDate = new Date();

        return customFormat.format(currentDate);
    }
}