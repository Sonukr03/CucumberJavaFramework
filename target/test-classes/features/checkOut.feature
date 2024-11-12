
Feature: Search and Place the Order for Product

@Test  @PlaceOrder  @Sanity  @Regression
Scenario Outline: Search Experience for Product in both home and Ofers page

Given User is on Greencart landing page
When user searched with Shortname <Name> and extracted actual name of product 
And Added "3" items of Selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name   |
| Tom    |  
| Beet   |