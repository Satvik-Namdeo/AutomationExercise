package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.BasePage;

public class Login_Valid_InvalidPage extends BasePage {

    private WebDriverWait wait;

    public Login_Valid_InvalidPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signupWebElement;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailWebElement;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordWebElement;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButtonWebElement;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInAsElement;
    
    @FindBy(xpath = "//a[text()=' Logout']") 
    WebElement logoutButtonWebElement;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement errorMessageWebElement;

    // ---------------- Actions ----------------

    public void clickSignUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signupWebElement);
    }

    public void enterEmail(String email) {
        loginEmailWebElement.clear();
        loginEmailWebElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordWebElement.clear();
        wait.until(ExpectedConditions.elementToBeClickable(passwordWebElement));
        passwordWebElement.sendKeys(password);
    }

    public void clickLoginButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButtonWebElement);
    }
    
    public void clickLogout() {
        logoutButtonWebElement.click();
    }

    // ---------------- Validations ----------------

    public boolean isLoggedInAsVisible(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(loggedInAsElement));
            String text = loggedInAsElement.getText(); // e.g., "Logged in as David"
            return text.contains(username);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginPageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginEmailWebElement));
            return loginEmailWebElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessageWebElement));
            return errorMessageWebElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
