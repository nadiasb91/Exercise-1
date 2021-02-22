Feature: Home Page Links

  Background:
    Given user navigates to url to login
    And user is already sign up


  Scenario: Display my Account Information page
    Given user is in my account page
    When user clicks on the Edit your account information option
    Then is display a page with my account information

  Scenario: Edit telephone from my account information page
    Given user is in my account page
    When user edits telephone
    And user click continue button
    Then success message is displayed on my account page

  Scenario: Go back from My Account Information Page
    When user clicks on the back button
    Then is display my account page

  Scenario: My account information page - all fields blank
    When user edits all the fields and leaves them blank
    And user click continue button
    Then error message detailing that fields are required

