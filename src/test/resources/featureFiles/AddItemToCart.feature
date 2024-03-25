Feature: Add item to cart functionality

  Background:
    When User is on the Home Page



  @addItemToCart
  Scenario: To verify that user can add/remove item to cart


    When clicked on my account link
    And I login with credentials , username "saifsh12786@gmail.com" and password "saffin123" expecting message "Edit your account information"
    Then user search for product "htc touch hd"
    When I click on searched Product hyperlink
    When user click on Add to Cart button
    Then verify success msg on item added to cart
    Then click view cart button
    When I click remove item button
    Then I see message as "Your shopping cart is empty!" on screen