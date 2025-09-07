package com.tests;

import com.base.TestNGBase;
import com.pages.SubscriptionCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubscriptionCartTest extends TestNGBase {

    private SubscriptionCartPage subscriptionCartPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        // Initialize Page Object using driver from TestNGBase
        subscriptionCartPage = new SubscriptionCartPage(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Automation Exercise"),
                "❌ Home page is not visible successfully!");
    }

    @Test(priority = 2)
    public void verifySubscriptionFlow() throws InterruptedException {
        // Step 4: Click 'Cart'
        subscriptionCartPage.clickCart();

        // Step 5: Scroll down to footer
        subscriptionCartPage.scrollToFooter();

        // Step 6: Verify text 'SUBSCRIPTION'
        Assert.assertTrue(subscriptionCartPage.isSubscriptionHeadingVisible(),
                "❌ 'SUBSCRIPTION' heading not visible!");

        // Step 7: Enter email and click arrow
        subscriptionCartPage.setEmail("testemail" + System.currentTimeMillis() + "@gmail.com");
        subscriptionCartPage.clickArrow();

        // Step 8: Verify success message
        String successMsg = subscriptionCartPage.getSuccessMessage();
        Assert.assertEquals(successMsg.trim(), "You have been successfully subscribed!",
                "❌ Subscription success message not matched!");
    }
}
