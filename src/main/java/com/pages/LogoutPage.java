package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.BasePage;

public class LogoutPage extends BasePage {

    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupWebElement;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailWebElement;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordWebElement;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButtonWebElement;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loginVisibilityWebElement;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButtonWebElement;

    // ----------------- Actions -----------------

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signupWebElement)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginEmailWebElement));
        loginEmailWebElement.clear();
        loginEmailWebElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordWebElement));
        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonWebElement)).click();
    }

    public boolean isLoginVisibilityDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(loginVisibilityWebElement)).isDisplayed();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButtonWebElement)).click();
    }
}
