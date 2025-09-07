package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.BasePage;

public class SubscriptionPage extends BasePage{

    WebDriver webDriver;
    public SubscriptionPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver , this);

    }


    @FindBy(xpath = "//footer[@id='footer']")
    WebElement footer;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement emailWebElement1;

    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement arrowWebElement;


    public void scrollToFooter() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
        Thread.sleep(4000);

    }

    public void setEmail(String email) {
        emailWebElement1.sendKeys(email);

    }

    public void clickArrow() {
        arrowWebElement.click();

    }
}

