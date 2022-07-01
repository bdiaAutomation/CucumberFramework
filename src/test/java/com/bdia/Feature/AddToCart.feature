Feature: Add To cart
  As a customer I want to add product to the cart
  In order to purchase it

  Rule: From store page
    @addToCart
    Scenario Outline: Add one product
      Given I'm on store page
      When I add one "<product>" to cart
      Then I see one "<product>" in the cart

      Examples:
      |product|
      |Blue Shoes  |


