package com.base;

import com.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(com.Utility.ExtentManager.class)
public class TestNGBase {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setUp(String browser, String appUrl) {
        
        DriverFactory.initDriver(browser, appUrl);
        driver = DriverFactory.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
