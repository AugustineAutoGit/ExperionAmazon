package com.amazon.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.ProductPage;



public class AmazonTest extends BaseClass{
	LandingPage landingPage;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	@Test
	public void amazonTest() throws InterruptedException {
		landingPage =  new LandingPage(androidDriver);
		homePage = new HomePage(androidDriver);
		productPage = new ProductPage(androidDriver);
		cartPage = new CartPage(androidDriver);
		
		landingPage.clickSkipSignInButton();
		homePage.enterTextInSearchField("samsung 65 inch tv");
		String productTextInSearchResults = homePage.clickProductInSearchResult();
		System.out.println(productTextInSearchResults);
		productPage.clickEnterAPincodeButton();
		productPage.enterPincode("683513");
		productPage.clickApplyButton();
		boolean isProductTextDisplayed = productPage.isProductTextDisplayed(productTextInSearchResults);
//		String productTextInProductPage = productPage.getProductText();
//		Assert.assertEquals("Product Text in Search Results is not same as the Product Text in Product Page", productTextInSearchResults, 
//				productTextInProductPage);
		Assert.assertTrue(isProductTextDisplayed, "Product Text in Search Results is not same as the Product Text in Product Page");
		productPage.clickAddToCartButton();
		//productPage.clickProceedToCheckOutButton();
		productPage.clickCartButton();
		String expectedProductTextInCartPage = productTextInSearchResults.substring(0, productTextInSearchResults.indexOf("TV")+2);
		boolean isProductDisplayed = cartPage.isProductDisplayed(expectedProductTextInCartPage);
		Assert.assertTrue(isProductDisplayed, "Product is not added into the Cart");
		
		
		
	}

}
