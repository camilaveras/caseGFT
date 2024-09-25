Feature: Create Account API

  Scenario: Create a new user account
    Given I send a POST request to create a new account
    Then I should receive a response with status code 201 for account creation
    And the response should contain success message
