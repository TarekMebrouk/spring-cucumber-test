Feature: Account Management

  Scenario: Register an account
    Given the user provides valid account details
    When the user sends a POST request to "/accounts"
    Then the response status code of account registration should be 200
    And the response body should contain the created account ID 1

  Scenario: Get an existing account
    Given an existing account with ID 1
    When the user sends a GET request to "/accounts"
    Then the response status code of getting an account should be 200
    And the response body should contain the account details
