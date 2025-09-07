package com.TestRunner;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import com.factory.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = {"com.stepDefinitions", "com.Hooks"},
	    tags = "@Valid or @Invalid",
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)
public class LoginRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUpClass(String browser, String appUrl) {
    	DriverFactory.initDriver(browser, appUrl);
    }
    
    @AfterClass
    public void tearDownClass() {
    	DriverFactory.quitDriver();
    }
}

