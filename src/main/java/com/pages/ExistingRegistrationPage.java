package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.BasePage;

public class ExistingRegistrationPage extends BasePage {

	WebDriver driver;
    
    public ExistingRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signUpWebElement;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupHeader;

    @FindBy(xpath = "//input[@data-qa = 'signup-name']")
    WebElement usernameWebElement;

    @FindBy(xpath = "//input[@data-qa= 'signup-email']")
    WebElement emailWebElement;

    @FindBy(xpath = "//button[@data-qa= 'signup-button']")
    WebElement signinWebElement;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    WebElement emailExistError;

    public void clickSignup() {
        signUpWebElement.click();
    }

    public boolean isNewUserSignupVisible() {
        return newUserSignupHeader.isDisplayed();
    }

    public void setUsername(String uname) {
        usernameWebElement.sendKeys(uname);
    }

    public void setEmail(String email) {
        emailWebElement.sendKeys(email);
    }

    public void clickSignin() {
        signinWebElement.click();
    }

    public boolean isEmailExistErrorVisible() {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(emailExistError));
            return emailExistError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
