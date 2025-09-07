package com.tests;

import com.base.TestNGBase;
import com.pages.VerifyTestCasePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class VerifyTestCaseTest extends TestNGBase {

    VerifyTestCasePage verifyTestCasePage;

    @BeforeClass
    public void initPages() {
        verifyTestCasePage = new VerifyTestCasePage(driver);

    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not visible.");

    }

    @Test(priority = 2)
    public void verifyTestCasesNavigation() {
        verifyTestCasePage.clickTestCases();

        String expectedUrl = "https://automationexercise.com/test_cases";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Navigation to Test Cases page failed!");

    }

}
