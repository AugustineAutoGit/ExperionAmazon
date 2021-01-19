package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofMillis;

public class ProductPage {
	private AndroidDriver<AndroidElement> androidDriver = null;
    private WebDriverWait webDriverWait = null;
    
    private By enterAPincodeButtonLocator = By.id("com.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode");
    private By pincodeFieldLocator = By.id("com.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1");
    private By applyButtonLocator = By.id("com.amazon.mShop.android.shopping:id/loc_ux_update_pin_code");
    private By productTextLocator = By.xpath("/hierarchy/android.widget.FrameLayout/"
    		+ "android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/"
    		+ "android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/"
    		+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/"
    		+ "android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
    		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/"
    		+ "android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/"
    		+ "android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/"
    		+ "android.view.View[1]/android.view.View[2]/android.view.View/android.view.View");
//    private By addToCartButtonLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
//    		+ "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/"
//    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/"
//    		+ "android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
//    		+ "android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/"
//    		+ "android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/"
//    		+ "android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/"
//    		+ "android.view.View[2]/android.view.View[6]/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/"
//    		+ "android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    private By addToCartButtonLocator = By.id("add-to-cart-button");
    private String addTocartButtonLocator = "new UiSelector().text(\"Add to Cart\")";
    private By proceedToCheckOutButtonLocator = By.id("a-autoid-1-announce");
    private String proceedTocheckOutButtonLocator = "new UiSelector().text(\"Proceed to checkout\")";
    private String cartButtonLocator = "new UiSelector().text(\"Cart\")";
    private By optionsLocator = By.id("vas-ppd-mobile-twister-announce");
    private By reviewLinkLocator = By.id("acrCustomerReviewLink");
    
    public ProductPage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.webDriverWait = new WebDriverWait(this.androidDriver, 20);

    }
    
    public void clickEnterAPincodeButton() {
    	webDriverWait.until(ExpectedConditions.elementToBeClickable(enterAPincodeButtonLocator)).click();
    }
    
    public void enterPincode(String pincode) {
    	webDriverWait.until(ExpectedConditions.elementToBeClickable(pincodeFieldLocator)).clear();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(pincodeFieldLocator)).click();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(pincodeFieldLocator)).sendKeys(pincode);
    }
    
    public void clickApplyButton() {
    	webDriverWait.until(ExpectedConditions.elementToBeClickable(applyButtonLocator)).click();
    }
    
    public String getProductText() {
    	return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(productTextLocator)).getText();
    }
    
    public boolean isProductTextDisplayed(String text) throws InterruptedException {
    	Thread.sleep(2000);
    	AndroidElement productText = androidDriver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")");
    	return productText.isDisplayed();
    }
    
    
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(androidDriver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
    
    public void clickAddToCartButton() throws InterruptedException {
    	verticalSwipeByPercentages(0.99, 0.01, 0.05);
    	Thread.sleep(2000);
    	//androidDriver.findElement(addToCartButtonLocator).click();
    	////boolean displayed = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(addToCartButtonLocator)).isDisplayed();
    	//AndroidElement mElement  = (AndroidElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
    	androidDriver.findElementByAndroidUIAutomator(addTocartButtonLocator).click();
    	//mElement.click();
    }
    
    public void clickProceedToCheckOutButton() throws InterruptedException {
    	Thread.sleep(2000);
    	androidDriver.findElementByAndroidUIAutomator(proceedTocheckOutButtonLocator).click();
    	//webDriverWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButtonLocator)).click();
    }
    
    public void clickCartButton() {
    	androidDriver.findElementByAndroidUIAutomator(cartButtonLocator).click();
    }
}
