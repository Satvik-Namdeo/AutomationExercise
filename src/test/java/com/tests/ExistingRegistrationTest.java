package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestNGBase;
import com.pages.ExistingRegistrationPage;

public class ExistingRegistrationTest extends TestNGBase {

	ExistingRegistrationPage registrationPage;

	@BeforeClass
	public void initPages() {
		registrationPage = new ExistingRegistrationPage(driver);
	}

	@Test(priority = 1)
	public void verifyHomePageVisible() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Automation Exercise"), "Home page is not visible!");
	}

	@Test(priority = 2)
	public void clickSignupAndVerifyNewUserSignup() {
		registrationPage = new ExistingRegistrationPage(driver); // Initialize here
		registrationPage.clickSignup();
		Assert.assertTrue(registrationPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");
	}

	@Test(priority = 3)
	public void registerWithExistingEmailAndVerifyError() {
		registrationPage.setUsername("red");
		registrationPage.setEmail("red@gmail.com"); // Replace with a real registered email
		registrationPage.clickSignin();
		Assert.assertTrue(registrationPage.isEmailExistErrorVisible(),
				"'Email Address already exist!' error not visible");
	}
}
