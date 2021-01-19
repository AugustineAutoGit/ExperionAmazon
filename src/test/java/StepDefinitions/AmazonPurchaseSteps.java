package StepDefinitions;

import org.testng.Assert;

import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.ProductPage;
import com.amazon.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPurchaseSteps {
	LandingPage landingPage =  new LandingPage(DriverFactory.getDriver());
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	ProductPage productPage = new ProductPage(DriverFactory.getDriver());
	CartPage cartPage = new CartPage(DriverFactory.getDriver());
	String productTextInSearchResults = null;
	
	@Given("User searches for {string}")
	public void user_searches_for(String string) throws InterruptedException {
		landingPage.clickSkipSignInButton();
		homePage.enterTextInSearchField(string);
		
	}

	@Given("User selects the product from the search results")
	public void user_selects_the_product_from_the_search_results() {
		productTextInSearchResults = homePage.clickProductInSearchResult();
	}

	@When("User enters the pincode {string}")
	public void user_enters_the_pincode(String string) {
		productPage.clickEnterAPincodeButton();
		productPage.enterPincode(string);
		productPage.clickApplyButton();
	}

	@When("User adds the product into the cart")
	public void user_adds_the_product_into_the_cart() throws InterruptedException {
		productPage.verticalSwipeByPercentages(0.99, 0.01, 0.05);
		productPage.verticalSwipeByPercentages(0.99, 0.01, 0.05);
		productPage.clickAddToCartButton();
		productPage.clickCartButton();
	}

	@Then("Product is added to the Cart")
	public void product_is_added_to_the_cart() throws InterruptedException {
		String expectedProductTextInCartPage = productTextInSearchResults.substring(0, productTextInSearchResults.indexOf("TV")+2);
		boolean isProductDisplayed = cartPage.isProductDisplayed(expectedProductTextInCartPage);
		Assert.assertTrue(isProductDisplayed, "Product is not added into the Cart");
	}
}
