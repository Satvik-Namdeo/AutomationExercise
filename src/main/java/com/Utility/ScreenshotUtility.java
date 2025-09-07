package com.Utility;

import com.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/screenshots";

    public static String captureScreenshot(String name, boolean isFailed) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (driver == null) {
                System.out.println("Driver is null, cannot capture screenshot!");
                return null;
            }

            String statusFolder = isFailed ? "failed" : "passed";
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String screenshotDir = SCREENSHOT_DIR + "/" + statusFolder;
            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();

            String path = screenshotDir + "/" + name + "_" + timestamp + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            org.openqa.selenium.io.FileHandler.copy(src, dest);

            System.out.println("Screenshot saved at: " + path);
            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}





