Feature: Products API

  Scenario: Validate that mandatory fields are present in the products list
    Given I perform a GET request to the products API
    Then I should receive a response with status code 200
    And the response should contain at most 45 products
    And each product should have id, name, price, brand, usertype, and category
