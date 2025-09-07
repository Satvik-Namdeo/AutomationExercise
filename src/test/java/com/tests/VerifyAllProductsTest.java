package com.tests;

import com.base.TestNGBase;
import com.pages.VerifyAllProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class VerifyAllProductsTest extends TestNGBase {


    VerifyAllProductsPage allProductsPage;

    @BeforeClass
    public void initPages() {
        allProductsPage = new VerifyAllProductsPage(driver);

    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not visible.");

    }

    @Test(priority = 2)
    public void verifyAllProductsPageIsVisible() {
        allProductsPage.clickProducts();

        String expectedUrl = "https://automationexercise.com/products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Did not navigate to ALL PRODUCTS page");

    }

    @Test(priority = 3)
    public void verifyViewProductsFunctionality() {
        List<WebElement> productsList = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
        Assert.assertFalse(productsList.isEmpty(), "Products list is not visible");

        allProductsPage.clickViewProduct();

        WebElement productInfoSection = driver.findElement(By.cssSelector(".product-information"));
        Assert.assertTrue(productInfoSection.isDisplayed(), "Product detail page is not visible");

        Assert.assertTrue(productInfoSection.findElement(By.tagName("h2")).isDisplayed(), "Product name not visible");
        Assert.assertTrue(productInfoSection.getText().contains("Category:"), "Category not visible");
        Assert.assertTrue(productInfoSection.getText().contains("Rs."), "Price not visible");
        Assert.assertTrue(productInfoSection.getText().contains("Availability:"), "Availability not visible");
        Assert.assertTrue(productInfoSection.getText().contains("Condition:"), "Condition not visible");
        Assert.assertTrue(productInfoSection.getText().contains("Brand:"), "Brand not visible");

    }

}
