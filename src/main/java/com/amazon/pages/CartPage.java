package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CartPage {
	private AndroidDriver<AndroidElement> androidDriver = null;
    private WebDriverWait webDriverWait = null;
	
	
	public CartPage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.webDriverWait = new WebDriverWait(this.androidDriver, 30);
        //PageFactory.initElements(driver, this);

    }
	
	public boolean isProductDisplayed(String locator) throws InterruptedException {
		Thread.sleep(2000);
		AndroidElement element = androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text, '"+locator+"')]"));
		return element.isDisplayed(); 
	}
}
