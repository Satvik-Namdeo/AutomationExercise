package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.BasePage;

public class ContactUsFormPage extends BasePage{

    WebDriver webDriver;

    public ContactUsFormPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver , this);
    }



    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement contactUsWebElement;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameWebElement;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailWebElement;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement subjectWebElement;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageWebElement;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadWebElement;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement submitWebElement;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    WebElement homeWebElement;



    public void clickConatctUs() {
        contactUsWebElement.click();

    }

    public void setName(String name) {
        nameWebElement.sendKeys(name);

    }

    public void setEmail(String email) {
        emailWebElement.sendKeys(email);

    }

    public void setSubject(String subject) {
        subjectWebElement.sendKeys(subject);

    }

    public void setMessage(String message) {
        messageWebElement.sendKeys(message);

    }

    public void chooseFile(String path) throws InterruptedException {
        uploadWebElement.sendKeys(path);

        //Thread.sleep(1000);
        //uploadWebElement.click();

    }

    public void clickSubmit() {
        submitWebElement.click();

    }

    public void clickHome() {
        homeWebElement.click();

    }

}


