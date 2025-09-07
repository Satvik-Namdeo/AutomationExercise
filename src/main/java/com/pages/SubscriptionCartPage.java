package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.ScrollingHelper;
import com.basePage.BasePage;

public class SubscriptionCartPage extends BasePage {

    WebDriver driver;

    public SubscriptionCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Cart Button
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    WebElement cartWebElement;

    public void clickCart() {
        cartWebElement.click();
    }

    // Footer
    @FindBy(xpath = "//footer[@id='footer']")
    WebElement footer;

    public void scrollToFooter() throws InterruptedException {
        ScrollingHelper.scrollToElement(driver, footer);
    }

    // Subscription Section Heading
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionHeading;

    public boolean isSubscriptionHeadingVisible() {
        return subscriptionHeading.isDisplayed();
    }

    // Email input
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement emailWebElement1;

    public void setEmail(String email) {
        emailWebElement1.sendKeys(email);
    }

    // Arrow Button
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement arrowWebElement;

    public void clickArrow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", arrowWebElement);
    }

    // Success message
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successMessage;

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
