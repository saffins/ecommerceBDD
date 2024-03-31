Feature: Login page testing


  @FunctionalTest
  Scenario: To verify that user can login with valid credentials

    When clicked on my account link
    And I login with "valid" credentials and expecting message "Edit your account information"
    Then user logs out of the application

  @FunctionalTest
  Scenario: To verify that user cannot login with Invalid credentials

    When clicked on my account link
    And I login with "invalid" credentials and expecting message "Warning: No match for E-Mail Address and/or Password."


