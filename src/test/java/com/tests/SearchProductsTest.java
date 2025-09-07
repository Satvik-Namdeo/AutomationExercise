package com.tests;

import com.base.TestNGBase;
import com.pages.SearchProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchProductsTest extends TestNGBase {

    SearchProductsPage searchProductsPage;

    @BeforeClass
    public void initPages() {
        searchProductsPage = new SearchProductsPage(driver);

    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not visible.");

    }

    @Test(priority = 2)
    public void verifyAllProductsPageIsVisible() {
        searchProductsPage.clickProducts();

        String expectedUrl = "https://automationexercise.com/products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Did not navigate to ALL PRODUCTS page");

    }

    @Test(priority = 3)
    public void verifySearchFunctionality() {
        String productToSearch = "dress";
        searchProductsPage.clickSearch1(productToSearch);
        searchProductsPage.clickSearch2();

        WebElement searchedProductsHeader = driver.findElement(By.xpath("//h2[@class='title text-center' and contains(text(),'Searched Products')]"));
        Assert.assertTrue(searchedProductsHeader.isDisplayed(), "'SEARCHED PRODUCTS' is not visible");

        List<WebElement> searchedProducts = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
        Assert.assertFalse(searchedProducts.isEmpty(), "No products are displayed for the search term: " + productToSearch);

        System.out.println("Products found for search term '" + productToSearch + "': " + searchedProducts.size());

    }

}
