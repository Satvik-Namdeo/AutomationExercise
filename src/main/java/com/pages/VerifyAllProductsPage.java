package com.pages;

import com.basePage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyAllProductsPage extends BasePage {

    WebDriver webDriver;
    public VerifyAllProductsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver , this);

    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsWebElement;

    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement viewproductWebElement;

    public void clickProducts() {
        productsWebElement.click();

    }

    public void clickViewProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewproductWebElement);

        viewproductWebElement.click();

    }

}

