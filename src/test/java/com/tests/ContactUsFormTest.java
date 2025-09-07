package com.tests;

import com.base.TestNGBase;
import com.pages.ContactUsFormPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;



public class ContactUsFormTest extends TestNGBase {

    ContactUsFormPage contactUsFormPage;

    @BeforeClass
    public void initPages(){
        contactUsFormPage = new ContactUsFormPage(driver);

    }


    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page is not visible.");

    }

    @Test(priority = 2)
    public void testContactUsFormSubmission() throws InterruptedException {
        contactUsFormPage.clickConatctUs();

        boolean isGetInTouchVisible = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();
        Assert.assertTrue(isGetInTouchVisible, "'GET IN TOUCH' is not visible.");

        contactUsFormPage.setName("Satvik");
        contactUsFormPage.setEmail("namdeosat007@gmail.com");
        contactUsFormPage.setSubject("Automation Query");
        contactUsFormPage.setMessage("This is an automated test message.");

        contactUsFormPage.chooseFile(System.getProperty("user.dir") + "/src/main/resources/SimpleText.txt");

        contactUsFormPage.clickSubmit();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        boolean successMessageVisible = driver.findElement(By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")).isDisplayed();
        Assert.assertTrue(successMessageVisible, "Success message not visible after form submission.");

        contactUsFormPage.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Did not navigate back to home page.");

    }

}
