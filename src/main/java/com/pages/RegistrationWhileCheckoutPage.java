package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basePage.BasePage;

public class RegistrationWhileCheckoutPage extends BasePage {

    WebDriver webDriver;
    JavascriptExecutor js;

    public RegistrationWhileCheckoutPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.js = (JavascriptExecutor) webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // ------------------- Product Selection -------------------
    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]")
    WebElement hoverproductWebElement1;

    @FindBy(xpath = "//a[@data-product-id = '1']")
    WebElement productWebElement1;

    public void clickHoverProduct1() throws InterruptedException {
        Actions action = new Actions(webDriver);
        action.moveToElement(hoverproductWebElement1)
              .moveToElement(productWebElement1)
              .click()
              .perform();
        Thread.sleep(2000);
    }

    // ------------------- Cart & Checkout -------------------
    @FindBy(xpath = "//*[@id='cartModal']/div/div/div[2]/p[2]/a/u")
    WebElement viewcartWebElement;

    public void clickViewCart() {
        viewcartWebElement.click();
    }

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement proceedToCheckoutWebElement;

    public void clickProceedToCheckout() {
        proceedToCheckoutWebElement.click();
    }
    
 // Home page "Signup / Login"
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupLoginHeader;
    
    public void clickSignupLoginHeader() {
        signupLoginHeader.click();
    }

    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    WebElement registerloginWebElement;

    public void clickRegisterLogin() {
        registerloginWebElement.click();
    }

    // ------------------- Signup Form -------------------
    @FindBy(xpath = "//input[@data-qa = 'signup-name']")
    WebElement usernameWebElement;

    public void setUsername(String uname) {
        usernameWebElement.sendKeys(uname);
    }

    @FindBy(xpath = "//input[@data-qa= 'signup-email']")
    WebElement emailWebElement;

    public void setEmail(String email) {
        emailWebElement.sendKeys(email);
    }

    @FindBy(xpath = "//button[@data-qa= 'signup-button']")
    WebElement signinWebElement;

    public void clickSignin() {
        signinWebElement.click();
    }

    @FindBy(id = "id_gender1")
    WebElement radioWebElement;

    public void setGender() {
        radioWebElement.click();
    }

    @FindBy(id = "password")
    WebElement passwordWebElement;

    public void setPassword(String password) {
        passwordWebElement.sendKeys(password);
    }

    @FindBy(id = "days")
    WebElement dateWebElement;

    public void setDate(String date) {
        dateWebElement.sendKeys(date);
    }

    @FindBy(id = "months")
    WebElement monthsWebElement;

    public void setMonths(String months) {
        monthsWebElement.sendKeys(months);
    }

    @FindBy(id = "years")
    WebElement yearsWebElement;

    public void setYears(String years) {
        yearsWebElement.sendKeys(years);
    }

    @FindBy(id = "newsletter")
    WebElement newsletterWebElement;

    public void clickNewsletter() {
        js.executeScript("arguments[0].click();", newsletterWebElement);
    }

    @FindBy(id = "optin")
    WebElement specialWebElement;

    public void clickSpecial() {
        js.executeScript("arguments[0].click();", specialWebElement);
    }

    @FindBy(id = "first_name")
    WebElement firstnameWebElement;

    public void setFirstname(String firstname) {
        firstnameWebElement.sendKeys(firstname);
    }

    @FindBy(id = "last_name")
    WebElement lastnameWebElement;

    public void setLastname(String lastname) {
        lastnameWebElement.sendKeys(lastname);
    }

    @FindBy(id = "company")
    WebElement companyWebElement;

    public void setCompany(String company) {
        companyWebElement.sendKeys(company);
    }

    @FindBy(id = "address1")
    WebElement addressWebElement1;

    public void setAddress1(String address1) {
        addressWebElement1.sendKeys(address1);
    }

    @FindBy(id = "address2")
    WebElement addressWebElement2;

    public void setAddress2(String address2) {
        addressWebElement2.sendKeys(address2);
    }

    @FindBy(id = "state")
    WebElement stateWebElement;

    public void setState(String state) {
       stateWebElement.sendKeys(state);
    }

    @FindBy(id = "city")
    WebElement cityWebElement;

    public void setCity(String city) {
        cityWebElement.sendKeys(city);
    }

    @FindBy(id = "zipcode")
    WebElement zipcodeWebElement;

    public void setZipcode(String zipcode) {
        zipcodeWebElement.sendKeys(zipcode);
    }

    @FindBy(id = "mobile_number")
    WebElement mobilenumberWebElement;

    public void setMobileNumber(String mobile_number) {
        mobilenumberWebElement.sendKeys(mobile_number);
    }

    @FindBy(xpath = "//button[@data-qa = 'create-account']")
    WebElement createWebElement;

    public void clickCreate() {
        js.executeScript("arguments[0].click();", createWebElement);
    }

    // ------------------- Assertions & Validation -------------------
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedMsg;

    public String getAccountCreatedMsg() {
        return accountCreatedMsg.getText();
    }

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement clickContinueWebElement1;

    public void clickContinue1() {
       clickContinueWebElement1.click();
    }

    @FindBy(xpath = "//li[10]//a[1]")
    WebElement loggedInAsMsg;

    public String getLoggedInAsText() {
        return loggedInAsMsg.getText();
    }

    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    WebElement cartWebElement;

    public void clickCart() {
        js.executeScript("arguments[0].click();", cartWebElement);
    }

    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    WebElement addressDetails;

    public boolean isAddressDetailsVisible() {
        return addressDetails.isDisplayed();
    }

    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    WebElement reviewOrder;

    public boolean isReviewOrderVisible() {
        return reviewOrder.isDisplayed();
    }

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement descriptionWebElement;

    public void setDescription(String description) {
        descriptionWebElement.sendKeys(description);
    }

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement placeorderWebElement1;

    public void clickplaceorder() {
        placeorderWebElement1.click();
    }

    // ------------------- Payment -------------------
    @FindBy(name = "name_on_card")
    WebElement nameOnCardElement;

    public void setCardName(String name) {
        nameOnCardElement.sendKeys(name);
    }

    @FindBy(name = "card_number")
    WebElement cardNumberElement;

    public void setCardNumber(String cardno) {
        cardNumberElement.sendKeys(cardno);
    }

    @FindBy(name = "cvc")
    WebElement cvcElement;

    public void setCardNumberCVC(String cardcvc) {
        cvcElement.sendKeys(cardcvc);
    }

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[2]/input")
    WebElement expireMonthElement;

    public void setExpireMonth(String exp) {
        expireMonthElement.sendKeys(exp);
    }

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[3]/input")
    WebElement expireYearElement;

    public void setExpireYear(String year) {
        expireYearElement.sendKeys(year);
    }

    @FindBy(xpath = "//button[@id='submit']")
    WebElement payConfirmElement;

    public void onClickPayConfirm() {
        payConfirmElement.click();
    }

    @FindBy(xpath = "//*[contains(normalize-space(text()),'Your order has been confirmed!')]")
    WebElement successOrderMsg;

    public String getSuccessOrderMsg() {
        return successOrderMsg.getText();
    }

    // ------------------- Delete Account -------------------
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement clickDeleteWebElement;

    public void clickDelete() {
        js.executeScript("arguments[0].click();", clickDeleteWebElement);
    }

    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedMsg;

    public String getAccountDeletedMsg() {
        return accountDeletedMsg.getText();
    }
}
