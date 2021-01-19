Feature: Purchase a Product from Amazon App
      
  Scenario: Verify the user is able to purchase a product
  	Given User searches for "samsung 65 inch tv"
  	And User selects the product from the search results
    When User enters the pincode "683513"
    And User adds the product into the cart
    Then Product is added to the Cart
