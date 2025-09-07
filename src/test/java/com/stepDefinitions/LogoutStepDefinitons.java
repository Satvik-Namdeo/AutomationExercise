package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinitons {

    WebDriver driver;
    LogoutPage log;
    
    public LogoutStepDefinitons() {
        this.driver = DriverFactory.getDriver();
        this.log = new LogoutPage(driver);
    }

    @Given("User is in Home page")
    public void user_is_in_home_page() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Automation Exercise"), "Home page title mismatch!");
    }

    @When("User clicked on signup\\/login button")
    public void user_clicked_on_signup_login_button() {
        log.clickSignUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Signup/Login page did not open!");
    }

    @When("User entered {string} and {string}")
    public void user_entered_and(String email, String password) {
        log.enterEmail(email);
        log.enterPassword(password);
        log.clickLoginButton();
    }


    @Then("User is Logged in and username is displayed")
    public void user_is_logged_in_and_username_is_displayed() {
        Assert.assertTrue(log.isLoginVisibilityDisplayed(),
                "'Logged in as username' text not visible!");
    }

    @When("User clicked logout button")
    public void user_clicked_logout_button() {
        log.clickLogout();
    }

    @Then("User redirected to login page")
    public void user_redirected_to_login_page() {
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
//        if (actualUrl.equals(expectedUrl)) {
//            ScreenshotUtility.capturePassScreenshot(driver, "PassLogout");
//        } else {
//            ScreenshotUtility.captureFailScreenshot(driver, "FailLogout");
//        }
        Assert.assertEquals(actualUrl, expectedUrl, "User not redirected to home page after logout!");
    }
}
