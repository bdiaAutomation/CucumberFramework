Feature: Add a coupon
  As a customer I want to add come coupon
  in order to get some discount

  Rule: discount coupon
    @coupons
    Scenario: add a discount coupon
      Given I'm on coupons list page
        | username                    | password |
        | nathan@neville.com          | Test1111 |
        | uncomptepourbre@yopmail.com | Test     |
      And I have a product in the cart
      When I add a discount coupon
      Then I see the discount reduction in the cart