Feature: Sign from My Account Menu
  Background:
    Given user navigates to url to sign up

  #CP1
  Scenario: Register Account is display
    When selects My Account Menu
    And click on Register option
    Then system shows the Register Account Form
  #CP2
  Scenario: Sign up successfully
    When user fill out the sign up from with valid data
      | Lola | Perez | lola@gmail.com | 1234987 | Pass123 | Pass123 |
    And user submits
    Then Success message should be displayed
  #CP3
  Scenario: Mandatory Fields
    Given user does not fill any field
    When user submit
    Then error message detailing what mandatory fields are missing
  #CP4
  Scenario: Duplicated email
    Given user uses an email already in use
      | Laura | Perez | lola@gmail.com | 1234987 | Pass123 | Pass123 |
    When user submits
    Then error message detailing that the email con be duplicated
  #CP5
  Scenario: Email without an @
    Given user uses an email without @
      | Lola | Perez | lola436567gmail.com | 1234987 | Pass123 | Pass123 |
    When user submit
    Then error message detailing that the email is invalid because @ is missing
  #CP6
  Scenario: Email without .com
    Given user uses an email without domain
      | Lola | Perez | lola436567@gmail | 1234987 | Pass123 | Pass123 |
    When user submit
    Then error message detailing that the email is invalid
  #CP7
  Scenario: Different Password and Confirm Password value
    Given user enter a password confirm different than the password
      | Lola | Perez | lola43656347@gmail.com | 1234987 | Pass123 | Pass12 |
    When user submit
    Then error message detailing that password and password confirm must be equal

