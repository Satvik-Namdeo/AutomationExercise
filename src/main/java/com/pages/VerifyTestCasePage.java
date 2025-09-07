package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.basePage.BasePage;


public class VerifyTestCasePage extends BasePage {

    public VerifyTestCasePage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(webdriver, this);

    }


    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCasesWebElement;


    public void clickTestCases() {
        testCasesWebElement.click();

    }

}


