Feature: Registration page testing

  Background:
    When User is on the Home Page


  @registerUserNew
  Scenario: To verify that we can not register new account if already used email id used


    When clicked on my account link
    Then user click on Register link
    And I pass registration information inputs by passing firstname as "saffin" last name as "last" email as "saifsh12786@gmail.com" telephone as "9090909090" password as "passtest123"
    Then I click agree policy checkbox
    When I click on continue button to register
    Then I see warning message on registration screen


  @registerUserNew
  Scenario: To verify that we can register new account with random email id


    When clicked on my account link
    Then user click on Register link
    And I pass registration information inputs by passing firstname as "saffin" last name as "last" email as "random" telephone as "9090909090" password as "passtest123"
    Then I click agree policy checkbox
    When I click on continue button to register
    Then I see message "Your Account Has Been Created!" on the screen