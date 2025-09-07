package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinitions {

    WebDriver driver;
    RegistrationPage registration;
    
    public RegistrationStepDefinitions() {
    	driver = DriverFactory.getDriver();
        registration = new RegistrationPage(driver);
    }

    @Given("User is on the Home page")
    public void user_is_on_the_home_page() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise",
                "Home page title did not match!");
    }

    @Given("User clicks on the Sign-Up\\/Login button")
    public void user_clicks_on_the_sign_up_login_button() {
        registration.clickSignUp();
        Assert.assertTrue(registration.isNewUserSignupVisible(),
                "New User Signup section not visible after clicking Sign-Up/Login!");
    }

    @Then("User is redirected to the Sign-Up page")
    public void user_is_redirected_to_the_sign_up_page() {
        Assert.assertTrue(registration.isNewUserSignupVisible(),
                "User was not redirected to Sign-Up page!");
    }

    @When("User fills in the signup details {string} and {string}")
    public void user_fills_in_the_signup_details_and(String name, String email) throws InterruptedException {
        registration.enterNameandEmail(name, email);
        Thread.sleep(1000);
    }

    @When("User clicks the Sign-Up button")
    public void user_clicks_the_sign_up_button() {
        registration.clickNewSignUp();
        Assert.assertTrue(registration.isEnterAccountInfoVisible(),
                "Enter Account Information page not visible after signup!");
    }

    @Then("User is redirected to the account information page")
    public void user_is_redirected_to_the_account_information_page() {
        Assert.assertTrue(registration.isEnterAccountInfoVisible(),
                "User is not on Account Information page!");
    }

    @When("User enters the following details {string}, {string} ,{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void user_enters_the_following_details_and(String password, String day, String month, String year,
                                                      String firstname, String lastname, String address,
                                                      String country, String state, String city,
                                                      String zipcode, String mobile) throws InterruptedException {
        registration.enterPassword(password);
        registration.enterUserDetails(day, month, year, firstname, lastname, address,
                country, state, city, zipcode, mobile);
        Thread.sleep(1000);
    }

    @When("User clicks on the Create Account button")
    public void user_clicks_on_the_create_account_button() {
        registration.clickCreateAccount();
        Assert.assertTrue(registration.isAccountCreatedVisible(),
                "Account Created message not visible!");
    }

    @Then("User account created")
    public void user_account_created() {
        Assert.assertTrue(registration.isAccountCreatedVisible(),
                "User account was not created!");
    }

    @Then("Account created message verified")
    public void account_created_message_verified() {
        Assert.assertTrue(registration.isAccountCreatedVisible(),
                "Account created confirmation not verified!");
    }

    @Then("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        registration.clickContinue();
    }

    @Then("logged in as username is visible")
    public void logged_in_as_username_is_visible() {
        Assert.assertTrue(registration.isLoggedInAsVisible("anushka"),
                "Logged in as username not visible!");
    }

    @When("user clicks on delete account button")
    public void user_clicks_on_delete_account_button() {
        registration.clickDelAcc();
    }

    @Then("account deleted is visible")
    public void account_deleted_is_visible() {
        Assert.assertTrue(registration.isAccountDeletedVisible(),
                "Account deleted message not visible!");
    }

    @Then("user clicks continue button")
    public void user_clicks_continue_button() {
        registration.clickContinueButton();

        String expectedUrl = "https://automationexercise.com/";
//        if (webdriver.getCurrentUrl().equals(expectedUrl)) {
//            ScreenshotUtility.capturePassScreenshot(driver, "PassRegistration2");
//        } else {
//            ScreenshotUtility.captureFailScreenshot(driver, "FailRegistration2");
//        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,
                "User not redirected back to Home page after deleting account!");
    }
}
