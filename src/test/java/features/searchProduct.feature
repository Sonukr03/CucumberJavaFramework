
Feature: Search and Place the Order for Product

@OffersPage   @Smoke  @Regression
Scenario Outline: Search Experience for Product in both home and Ofers page

Given User is on Greencart landing page
When user searched with Shortname <Name> and extracted actual name of product 
Then user searched for <Name> shortname in offers page
And Validate product name in offers page matches with Landing page

Examples:
| Name   |
| Tom    |  
| Beet   |