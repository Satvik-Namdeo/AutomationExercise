package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestNGBase;
import com.pages.RegistrationWhileCheckoutPage;

public class RegistrationWhileCheckoutTest extends TestNGBase{

    RegistrationWhileCheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
    	checkoutPage = new RegistrationWhileCheckoutPage(driver);
    }

    @Test
    public void verifyCheckoutWithRegistrationFlow() throws InterruptedException {
        // Step 3: Verify home page
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not visible");

        // Step 4: Add product to cart
        checkoutPage.clickHoverProduct1();

        // Step 5: Click Cart button
        checkoutPage.clickViewCart();

        // Step 6: Verify cart page
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not displayed");

        // Step 7: Click Proceed To Checkout
        checkoutPage.clickProceedToCheckout();

        // Step 8: Click Register / Login
        checkoutPage.clickRegisterLogin();

        // Step 9: Fill signup form
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
        checkoutPage.setZipcode("451001");
        checkoutPage.setMobileNumber("9876543210");
        checkoutPage.clickCreate();

        // Step 10: Verify account created
        Assert.assertEquals(checkoutPage.getAccountCreatedMsg(), "ACCOUNT CREATED!");
        checkoutPage.clickContinue1();

        // Step 11: Verify logged in
        Assert.assertTrue(checkoutPage.getLoggedInAsText().contains("Rony"), "Not logged in properly");

        // Step 12: Click Cart again
        checkoutPage.clickCart();

        // Step 13: Proceed to checkout
        checkoutPage.clickProceedToCheckout();

        // Step 14: Verify Address + Review Order
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order missing");

        // Step 15: Enter description and place order
        checkoutPage.setDescription("Please deliver fast");
        checkoutPage.clickplaceorder();

        // Step 16: Payment details
        checkoutPage.setCardName("Rony M");
        checkoutPage.setCardNumber("4111111111111111");
        checkoutPage.setCardNumberCVC("123");
        checkoutPage.setExpireMonth("12");
        checkoutPage.setExpireYear("2028");

        // Step 17: Pay and confirm
        checkoutPage.onClickPayConfirm();

        // Step 18: Verify success message
        Assert.assertTrue(checkoutPage.getSuccessOrderMsg().contains("Your order has been confirmed!"));

        // Step 19: Delete account
        checkoutPage.clickDelete();

        // Step 20: Verify account deleted
        Assert.assertEquals(checkoutPage.getAccountDeletedMsg(), "ACCOUNT DELETED!");
        checkoutPage.clickContinue1();
    }

}
