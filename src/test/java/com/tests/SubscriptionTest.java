package com.tests;

import com.base.TestNGBase;
import com.pages.SubscriptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubscriptionTest extends TestNGBase {

    SubscriptionPage subscriptionPage;

    @BeforeClass
    public void initPages() {
        subscriptionPage = new SubscriptionPage(driver);

    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not visible.");

    }

    @Test(priority = 2)
    public void verifySubscriptionFunctionality() throws InterruptedException {
        subscriptionPage.scrollToFooter();

        WebElement subscriptionText = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertTrue(subscriptionText.isDisplayed(), "'SUBSCRIPTION' text is not visible");

        String testEmail = "testemail@example.com";
        subscriptionPage.setEmail(testEmail);
        subscriptionPage.clickArrow();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not visible");
        Assert.assertTrue(successMessage.getText().contains("You have been successfully subscribed!"), "Success message text mismatch");

    }

}
