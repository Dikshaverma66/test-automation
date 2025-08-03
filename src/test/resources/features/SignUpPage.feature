@signup
Feature: User Registration on Magento

  Background:
    Given I am on the Magento Create Account page

  @positive
  Scenario: Successful registration with valid data
    When the user enter "Diksha" in the First Name field
    And the user enter "Verma" in the Last Name field
    And the user enter "diksha.verma+test18@gmail.com" in the Email field
    And the user enter "Test@12345" in the Password field
    And the user enter "Test@12345" in the Confirm Password field
    And the user click the Create an Account button
    Then the user gets the title of the account page
    And the account page title should be "My Account"


  @negative
  Scenario: Attempt to create account with empty fields
    When the user click the Create an Account button
    Then the user see required validation messages "This is a required field."


  @negative
  Scenario Outline: Invalid email format
    When the user enter "<firstName>" in the First Name field
    And the user enter "<lastName>" in the Last Name field
    And the user enter "<email>" in the Email field
    And the user enter "<password>" in the Password field
    And the user enter "<confirmPassword>" in the Confirm Password field
    And the user click the Create an Account button
    Then the user should see an "<error>" for invalid email format
    Examples:
      | firstName | lastName | email                | password   | confirmPassword | error                                                        |
      | Diksha    | Verma    | user@invalid-tld.123 | Test@12345 | Test@12345      | Please enter a valid email address (Ex: johndoe@domain.com). |
      | Diksha    | Verma    | user#domain.com      | Test@12345 | Test@12345      | Please enter a valid email address (Ex: johndoe@domain.com). |

  @negative
  Scenario: Passwords do not match
    When the user enter "Diksha" in the First Name field
    And the user enter "Verma" in the Last Name field
    And the user enter "diksha.verma+test124@gmail.com" in the Email field
    And the user enter "Test@12345" in the Password field
    And the user enter "Mismatch123" in the Confirm Password field
    And the user click the Create an Account button
    Then the user should see an error that "Please enter the same value again."


  @negative
  Scenario Outline: Passwords doesn't meet criteria
    When the user enter "<firstName>" in the First Name field
    And the user enter "<lastName>" in the Last Name field
    And the user enter "<email>" in the Email field
    And the user enter "<password>" in the Password field
    And the user enter "<confirmPassword>" in the Confirm Password field
    And the user click the Create an Account button
    Then the user should see an "<error>" related to the password criteria
    Examples:
      | firstName | lastName | email                          | password | confirmPassword | error                                                                                                                                   |
      | Diksha    | Verma    | diksha.verma+test125@gmail.com | abc      | abc             | Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.                      |
      | Diksha    | Verma    | diksha.verma+test126@gmail.com | 12345678 | 12345678        | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |

  @negative
  Scenario: Prevent account creation when email is already registered
    When the user enter "Diksha" in the First Name field
    And the user enter "Verma" in the Last Name field
    And the user enter "diksha.verma+test1@gmail.com" in the Email field
    And the user enter "Test@12345" in the Password field
    And the user enter "Test@12345" in the Confirm Password field
    And the user click the Create an Account button
    Then the user should see an already registered mail error that "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."