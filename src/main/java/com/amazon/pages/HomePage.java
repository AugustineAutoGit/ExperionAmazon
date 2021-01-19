package com.amazon.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage {
	private AndroidDriver<AndroidElement> androidDriver = null;
    private WebDriverWait webDriverWait = null;
    
    @FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    private WebElement searchField;
    
	private By searchFieldLocator = By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
	private By suggestionsLocator = By.id("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions");
	private By productsLocator = By.id("com.amazon.mShop.android.shopping:id/item_title");
	
	
	public HomePage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.webDriverWait = new WebDriverWait(this.androidDriver, 30);
        //PageFactory.initElements(driver, this);

    }
	
	public void enterTextInSearchField(String text) throws InterruptedException {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator)).clear();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator)).click();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator)).sendKeys(text);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(suggestionsLocator)).click();
		
		
	}
	
	public String clickProductInSearchResult() {
		List<WebElement> productList = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsLocator));
		//int n = productList.size();
        String expectedProductText = productList.get(0).getText();
        //System.out.println(expectedProductText);
        productList.get(0).click();
        return expectedProductText;
	}
	

}
