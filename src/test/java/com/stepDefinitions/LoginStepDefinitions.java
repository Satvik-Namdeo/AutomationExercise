package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.Login_Valid_InvalidPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    WebDriver driver;
    Login_Valid_InvalidPage validLogin;
    String emailUsed;
    String passwordUsed;
    String username; // first name for successful login

    public LoginStepDefinitions() {
        this.driver = DriverFactory.getDriver();
        if (driver == null) {
            // initialize driver if not yet initialized
            DriverFactory.initDriver("chrome", "https://automationexercise.com");
            this.driver = DriverFactory.getDriver();
        }
        this.validLogin = new Login_Valid_InvalidPage(driver);
    }
    
    @Given("User is in home page")
    public void user_is_in_home_page() {
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),
                "Home page title did not match");
    }

    @When("user clicks on signup\\/login button")
    public void user_clicks_on_signup_login_button() {
        validLogin.clickSignUp();
        Assert.assertTrue(validLogin.isLoginPageVisible(), "Login page not visible!");
    }

    @Then("user is redirected to login page")
    public void user_is_redirected_to_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Not redirected to Login page!");
    }

    // ----- Valid Login -----
    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String email, String password) {
        emailUsed = email;
        passwordUsed = password;
        username = "Logged in as"; // replace with the actual first name associated with account
        validLogin.enterEmail(emailUsed);
        validLogin.enterPassword(passwordUsed);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        validLogin.clickLoginButton();
    }

    @Then("user has successfully logged in")
    public void user_has_successfully_logged_in() {
    	Assert.assertTrue(validLogin.isLoggedInAsVisible(username),
                "Login failed: 'Logged in as <username>' not visible!");
    }
    
    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        validLogin.clickLogout();
     
    }

    @Then("Logged in as username message is displayed")
    public void logged_in_as_username_message_is_displayed() {
        Assert.assertTrue(validLogin.isLoggedInAsVisible(username),
                "Logged in as username not visible!");
//        ScreenshotUtility.capturePassScreenshot(driver, "ValidLoginPass");
    }

    // ----- Invalid Login -----
    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String email, String password) {
        emailUsed = email;
        passwordUsed = password;
        validLogin.enterEmail(emailUsed);
        validLogin.enterPassword(passwordUsed);
    }

    @When("User click on Login button")
    public void user_click_on_login_button_invalid() {
        validLogin.clickLoginButton();
    }

    @Then("Your email or password is incorrect! is visible")
    public void your_email_or_password_is_incorrect_is_visible() {
        Assert.assertTrue(validLogin.isErrorMessageVisible(),
                "Error message for invalid login not visible!");
//        ScreenshotUtility.captureFailScreenshot(webdriver, "InvalidLoginFail");
    }
}
