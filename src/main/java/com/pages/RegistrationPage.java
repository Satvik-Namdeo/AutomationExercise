package com.pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.BasePage;

public class RegistrationPage extends BasePage {

    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signupWebElement;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserWebElement;

    @FindBy(xpath = "//input[@data-qa = 'signup-name']")
    WebElement nameWebElement;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailWebElement;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButtonWebElement;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement enterAccInfoWebElement;

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement titleWebElement;

    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement passwordWebElement;

    @FindBy(id = "days")
    WebElement daysWebElement;

    @FindBy(id = "months")
    WebElement monthWebElement;

    @FindBy(xpath = "//select[@data-qa='years']")
    WebElement yearWebElement;

    @FindBy(id = "newsletter")
    WebElement newsLetterWebElement;

    @FindBy(id = "optin")
    WebElement optionWebElement;

    @FindBy(id = "first_name")
    WebElement firstnameWebElement;

    @FindBy(id = "last_name")
    WebElement lastnameWebElement;

    @FindBy(id = "address1")
    WebElement addressWebElement;

    @FindBy(id = "country")
    WebElement countryWebElement;

    @FindBy(id = "state")
    WebElement stateWebElement;

    @FindBy(id = "city")
    WebElement cityWebElement;

    @FindBy(id = "zipcode")
    WebElement zipcodeWebElement;

    @FindBy(id = "mobile_number")
    WebElement mobileWebElement;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement creatAccountButtonWebElement;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButtonWebElement;

    @FindBy(partialLinkText = "Logged in")
    WebElement loggedinasUsernameElement;

    @FindBy(xpath = "//a[contains(@href, 'delete_account')]")
    WebElement deleteAccountButtonElement;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButtonElement;

    // Actions
    public void clickSignUp() {
        signupWebElement.click();
    }

    public boolean isNewUserSignupVisible() {
        return newUserWebElement.isDisplayed();
    }

    public void enterNameandEmail(String name, String email) {
        nameWebElement.sendKeys(name);
        emailWebElement.sendKeys(email);
    }

    public void clickNewSignUp() {
        signupButtonWebElement.click();
    }

    public boolean isEnterAccountInfoVisible() {
        return enterAccInfoWebElement.isDisplayed();
    }

    public void enterPassword(String pass) {
        passwordWebElement.sendKeys(pass);
    }

    public void enterUserDetails(String day, String month, String year, String firstname,
                                 String lastname, String address, String country,
                                 String state, String city, String zipcode, String mobNo) {
        daysWebElement.sendKeys(day);
        monthWebElement.sendKeys(month);
        yearWebElement.sendKeys(year);
        firstnameWebElement.sendKeys(firstname);
        lastnameWebElement.sendKeys(lastname);
        addressWebElement.sendKeys(address);
        countryWebElement.sendKeys(country);
        stateWebElement.sendKeys(state);
        cityWebElement.sendKeys(city);
        zipcodeWebElement.sendKeys(zipcode);
        mobileWebElement.sendKeys(mobNo);
    }

    public void clickCreateAccount() {
        creatAccountButtonWebElement.click();
    }

    public void clickContinue() {
        continueButtonWebElement.click();
    }

    public void clickDelAcc() {
        deleteAccountButtonElement.click();
    }

    public void clickContinueButton() {
        continueButtonElement.click();
    }

    // Validation helpers
    public boolean isLoggedInAsVisible(String username) {
        return loggedinasUsernameElement.getText().contains("Logged in");
    }

    public boolean isAccountCreatedVisible() {
        return driver.getPageSource().contains("Account Created!");
    }

    public boolean isAccountDeletedVisible() {
        return driver.getPageSource().contains("Account Deleted!");
    }
}
