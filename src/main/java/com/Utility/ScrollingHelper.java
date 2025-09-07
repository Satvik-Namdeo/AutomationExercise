
package com.Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollingHelper {
    
    public static void scrollToBottom(WebDriver webDriver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0 , document.body.scrollHeight);");
        Thread.sleep(4000);
    }

    public static void scrollToElement(WebDriver webDriver , WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(4000);
    }

    public void scrollDownByPixel(WebDriver webDriver, int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixel);
    }
    
    public static void closePopUps(WebDriver webDriver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("var popups = document.querySelectorAll('[id^=\"popup\"], [class*=\"ad\"], [class*=\"overlay\"]'); popups.forEach(el => el.remove());");
        } catch (Exception e) {
            System.out.println("No pop-ups found.");
        }
    }

    // Dismiss JavaScript pop-up alerts
    public static void dismissAlert(WebDriver webDriver) {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.dismiss();  // or alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present.");
        }
    }

    // Click outside the modal to close ads
    public static void clickOutside(WebDriver webDriver) {
        try {
            Actions actions = new Actions(webDriver);
            actions.moveByOffset(10, 10).click().perform(); // Clicks an empty area on the screen
        } catch (Exception e) {
            System.out.println("No modal to close.");
        }
    }
}

