package com.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.base.TestNGBase;
import com.pages.RegistrationWhileCheckoutPage;

public class RegistrationBeforeCheckoutTest extends TestNGBase {

	RegistrationWhileCheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        checkoutPage = new RegistrationWhileCheckoutPage(driver);
    }

    @Test
    public void verifyPlaceOrderAfterSignup() throws InterruptedException {
        // Step 3: Verify home page
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not visible");

        // Step 4: Click 'Signup / Login' from header
        checkoutPage.clickSignupLoginHeader();

        // Step 5: Fill signup form and create account
        checkoutPage.setUsername("Rony");
        checkoutPage.setEmail("rony" + System.currentTimeMillis() + "@test.com");
        checkoutPage.clickSignin();

        checkoutPage.setGender();
        checkoutPage.setPassword("Test@123");
        checkoutPage.setDate("1");
        checkoutPage.setMonths("January");
        checkoutPage.setYears("2000");
        checkoutPage.clickNewsletter();
        checkoutPage.clickSpecial();
        checkoutPage.setFirstname("Rony");
        checkoutPage.setLastname("Mehta");
        checkoutPage.setCompany("TestCompany");
        checkoutPage.setAddress1("123 Main Street");
        checkoutPage.setAddress2("Near Temple");
        checkoutPage.setState("Odisha");
        checkoutPage.setCity("Bhubaneswar");
        checkoutPage.setZipcode("751001");
        checkoutPage.setMobileNumber("9876543210");
        checkoutPage.clickCreate();

        // Step 6: Verify 'ACCOUNT CREATED!' and click Continue
        Assert.assertEquals(checkoutPage.getAccountCreatedMsg(), "ACCOUNT CREATED!");
        checkoutPage.clickContinue1();

        // Step 7: Verify 'Logged in as username'
        Assert.assertTrue(checkoutPage.getLoggedInAsText().contains("Rony"), "Not logged in properly");

        // Step 8: Add product to cart
        checkoutPage.clickHoverProduct1();

        // Step 9: Click 'Cart' button
        checkoutPage.clickViewCart();

        // Step 10: Verify cart page
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not displayed");

        // Step 11: Click Proceed To Checkout
        checkoutPage.clickProceedToCheckout();

        // Step 12: Verify Address + Review Order
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order missing");

        // Step 13: Enter description and place order
        checkoutPage.setDescription("Please deliver quickly");
        checkoutPage.clickplaceorder();

        // Step 14: Enter payment details
        checkoutPage.setCardName("Rony M");
        checkoutPage.setCardNumber("4111111111111111");
        checkoutPage.setCardNumberCVC("123");
        checkoutPage.setExpireMonth("12");
        checkoutPage.setExpireYear("2028");

        // Step 15: Pay and confirm order
        checkoutPage.onClickPayConfirm();

        // Step 16: Verify success message
        Assert.assertTrue(
            checkoutPage.getSuccessOrderMsg().contains("Your order has been confirmed!"),
            "Order success message not found"
        );

        // Step 17: Delete account
        checkoutPage.clickDelete();

        // Step 18: Verify 'ACCOUNT DELETED!' and click Continue
        Assert.assertEquals(checkoutPage.getAccountDeletedMsg(), "ACCOUNT DELETED!");
        checkoutPage.clickContinue1();
    }
}
