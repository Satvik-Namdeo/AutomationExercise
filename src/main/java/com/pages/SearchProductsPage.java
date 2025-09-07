package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.BasePage;


public class SearchProductsPage extends BasePage{

    public SearchProductsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver , this);
    }


    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsWebElement;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchWebElement1;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchWebElement2;


    public void clickProducts() {
        productsWebElement.click();

    }

    public void clickSearch1(String search) {
        searchWebElement1.sendKeys(search);

    }

    public void clickSearch2() {
        searchWebElement2.click();

    }
}

