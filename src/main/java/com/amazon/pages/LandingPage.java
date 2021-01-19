package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LandingPage {
	private AndroidDriver<AndroidElement> androidDriver = null;
    private WebDriverWait webDriverWait = null;
    
    
    @FindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    private WebElement skipSignInButton;
    
	private By skipSignInButtonLocator = By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button");
	
	
	public LandingPage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.webDriverWait = new WebDriverWait(this.androidDriver, 30);
        //PageFactory.initElements(driver, this);

    }
	public void clickSkipSignInButton() {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(skipSignInButtonLocator)).click();
		//skipSignInButton.click();
	}
	
}
