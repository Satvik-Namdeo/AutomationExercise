package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.BasePage;

public class AddToCartPage extends BasePage {

	WebDriver webDriver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public AddToCartPage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) webDriver;
		PageFactory.initElements(webDriver, this);
	}

	// Products link
	@FindBy(xpath = "//a[@href='/products']")
	WebElement products1WebElement;

	public void clickonProducts() {
		js.executeScript("arguments[0].click();", products1WebElement);
	}

	// Product 1 hover + add to cart
	@FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]")
	WebElement hoverproductWebElement1;

	@FindBy(xpath = "//a[@data-product-id = '1']")
	WebElement productWebElement1;

	public void clickHoverProduct1() throws InterruptedException {
		Actions action = new Actions(webDriver);
		action.moveToElement(hoverproductWebElement1).moveToElement(productWebElement1).click().perform();
	}

	// Continue Shopping Button
	@FindBy(css = ".btn.btn-success.close-modal.btn-block")
	WebElement continueButton;

	public void clickContinue() throws InterruptedException {
		continueButton.click();
		Thread.sleep(5000);
	}

	// Product 2 hover + add to cart
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[2]")
	WebElement hoverproductWebElement2;

	@FindBy(xpath = "//a[@data-product-id = '2']")
	WebElement productWebElement2;

	public void clickHoverProduct2() {
		Actions action = new Actions(webDriver);
		action.moveToElement(hoverproductWebElement2).moveToElement(productWebElement2).click().perform();
	}

	// View Cart
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	WebElement viewcartWebElement;

	public void clickViewCart() {
		viewcartWebElement.click();
	}

	// ================= CART VALIDATIONS =================

	// Product 1
	@FindBy(xpath = "(//td[@class='cart_description']/h4/a)[1]")
	WebElement firstProductName;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_price']/p")
	WebElement firstProductPrice;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']/button")
	WebElement firstProductQuantity;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_total']/p")
	WebElement firstProductTotal;

	// Product 2

	@FindBy(xpath = "(//td[@class='cart_description']/h4/a)[2]")
	WebElement secondProductName;

	@FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_price']/p")
	WebElement secondProductPrice;

	@FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_quantity']/button")
	WebElement secondProductQuantity;

	@FindBy(xpath = "//tr[@id='product-2']//td[@class='cart_total']/p")
	WebElement secondProductTotal;

	// Methods for validation
	public String getFirstProductName() {
	    wait.until(ExpectedConditions.visibilityOf(firstProductName));
	    return firstProductName.getText();
	}

	public String getSecondProductName() {
	    wait.until(ExpectedConditions.visibilityOf(secondProductName));
	    return secondProductName.getText();
	}

	public String getFirstProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
		return firstProductPrice.getText();
	}

	public String getSecondProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(secondProductPrice));
		return secondProductPrice.getText();
	}

	public String getFirstProductQuantity() {
		wait.until(ExpectedConditions.visibilityOf(firstProductQuantity));
		return firstProductQuantity.getText();
	}

	public String getSecondProductQuantity() {
		wait.until(ExpectedConditions.visibilityOf(secondProductQuantity));
		return secondProductQuantity.getText();
	}

	public String getFirstProductTotal() {
		wait.until(ExpectedConditions.visibilityOf(firstProductTotal));
		return firstProductTotal.getText();
	}

	public String getSecondProductTotal() {
		wait.until(ExpectedConditions.visibilityOf(secondProductTotal));
		return secondProductTotal.getText();
	}
}
