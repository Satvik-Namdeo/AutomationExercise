package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.BasePage;

public class IncreasedQuantityPage extends BasePage {

    public IncreasedQuantityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ---------------- PRODUCT PAGE LOCATORS ---------------- //

    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    WebElement viewProductLink;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    // ---------------- CART PAGE LOCATORS ---------------- //

    @FindBy(xpath = "//tr[contains(@id,'product')][1]//td[@class='cart_quantity']/button")
    WebElement cartQuantityBtn;

    // ---------------- PRODUCT PAGE ACTIONS ---------------- //

    public void clickViewProduct() {
        viewProductLink.click();
    }

    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }

    public void clickViewCart() {
        viewCartLink.click();
    }

    // ---------------- CART PAGE ACTIONS ---------------- //

    public String getCartQuantity() {
        return cartQuantityBtn.getText().trim();
    }
}
