package com.Hooks;

import com.Utility.ScreenshotUtility;
import com.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    @After
    public void addScreenshotToCucumberReport(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            System.out.println("Driver is null, cannot capture screenshot!");
            return;
        }

        boolean failed = scenario.isFailed();
        String path = ScreenshotUtility.captureScreenshot(scenario.getName().replaceAll(" ", "_"), failed);

        if (path != null) {
            
            byte[] screenshotBytes = ((org.openqa.selenium.TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
    }
}



