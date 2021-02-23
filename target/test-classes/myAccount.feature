@MyAccount
Feature: Home Page Links

  Background:
    Given user navigates to url to login
    And user log in

  Scenario: Display my Account Information page
    Given user is in my account page
    When user clicks on the Edit your account information option
    Then is display a page with my account information

  Scenario: Edit telephone from my account information page
    Given user is in my account information form page
    When user edits telephone
    And user click continue button
    Then  message account updated successfully is display on my account page

  Scenario: Go back from My Account Information Page
    Given user is in my account information form page
    When user click on the back button
    Then is display my account page

  Scenario: My account information page - all fields blank
    Given user is in my account information form page
    When user edits all the fields and leaves them blank
    And user click continue button
    Then error message detailing that fields are required

  Scenario: Edit My account information page - email without @
    Given user is in my account information form page
    When user edit email to one without @
      | lola436567gmail.com |
    And  user click continue button
    Then error message in email field detailing that the field is invalid

  Scenario: Edit My account information page - email without domain (.com)
    Given user is in my account page
    When user edit an email without domain
      | lola436567@gmail |
    And  user click continue button
    Then error message in email field detailing that the field is invalid

  Scenario: Display Change Password page
    Given user is in my account page
    When user click on the change password option
    Then is display a change password page

  Scenario: Change Password page - all fields blank
    Given user is in change password page
    When user click continue button
    Then error message detailing that the fields are required

  Scenario: Go back from Change Password page
    Given user is in change password page
    When user click on the back button
    Then is display my account page

  Scenario: Change Password page - different password and password confirm
    Given user is in change password page
    When user enters a password confirm different than password
      | 1234 | 12345 |
    And user click continue button
    Then error message on the password confirm field detailing that the field the both fields most be equals

  Scenario: Edit Password from Change Password page
    Given user is in change password page
    When user fill out the password and password confirm fields with the same value
      | 1234 |
    And user click continue button
    Then message password updated successfully is display on my account page

  Scenario: Display Address Book Entries page
    Given user is in my account page
    When user click on modify your address book entries option
    Then is display a page with address book entries
    And message you have no addresses in your account

  Scenario: Go back from Address Book Entries page
    Given user is in address book entries
    When user click on the back button
    Then is display my account page

  Scenario: Display New Address Book Entries page
    Given user is in address book entries
    When user click on new address button
    Then is display a add address form

  Scenario: Display My Wish List page
    Given user is in my account page
    When user click on the modify your wish list option
    Then is display the message your wish list is empty

  Scenario: Return to My Account Page from My Wish List page
    Given user is in my account page
    And user click on the modify your wish list option
    When user click continue button from wish list
    Then is display my account page

  Scenario: Display Order History page
    Given user is in my account page
    When user click on view your order history option
    Then is display order history page
    And message you have not made any previous orders

  Scenario: Display Newsletter Subscription page
    Given user is in my account page
    When user click on subscribe or unsubscribe to newsletter
    Then is display newsletter subscription page

  Scenario: Newsletter Subscription page - Subscribe = yes
    Given user is in my account page
    And user click on subscribe or unsubscribe to newsletter
    When user click on option yes
    And user click continue button
    Then message newsletter subscription updated successfully

  Scenario: Newsletter Subscription page - Subscribe = no
    Given user is in my account page
    And user click on subscribe or unsubscribe to newsletter
    When user click on option no
    And user click continue button
    Then message newsletter subscription updated successfully

  Scenario: Go back from Newsletter Subscription page
    Given user is in my account page
    And user click on subscribe or unsubscribe to newsletter
    When user click on the back button
    Then is display my account page