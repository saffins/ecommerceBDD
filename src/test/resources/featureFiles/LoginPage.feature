Feature: Login page testing

  Background:
    When User is on the Home Page


#  Scenario: To verify that user can login with valid credentials
#
#
#    When User clicked on Continue with email
#    And enter email and password as
#      | saifsh12786@gmail.com | saffin123 |
#    And clicked on login button
#    Then User gets signed in to application using valid credentials and your's home page gets displayed with Page Title as "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more"

  @FunctionalTest
  Scenario: To verify that user can login with valid credentials


    When clicked on my account link
    And I login with credentials , username "saifsh12786@gmail.com" and password "saffin123" expecting message "Edit your account information"
    Then user logs out of the application

  @FunctionalTest
  Scenario Outline: To verify that user cannot login with Invalid credentials

    When clicked on my account link
    And I login with credentials , username "<EmailId>" and password "<password>" expecting message "Warning: No match for E-Mail Address and/or Password."

    Examples:
      | EmailId                     | password |
      | testingpurposesel@gmail.com | asas     |
      | testingpurpose@gmail.com    | eqw      |



  @FunctionalTest
  Scenario: To verify that user can not login with Blank Email address

    When clicked on my account link
    And I login with credentials , username "" and password "saffin123" expecting message "Warning: No match for E-Mail Address and/or Password."

  @FunctionalTest
  Scenario: To verify that user can not login with Blank Password

    When clicked on my account link
    And I login with credentials , username "saifsh12786@gmail.com" and password "" expecting message "Warning: No match for E-Mail Address and/or Password."