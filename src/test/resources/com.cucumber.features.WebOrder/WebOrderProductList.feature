Feature: This is for web order all products
  Scenario: Validation of all product data
    Given the user navigates to the web orders page
    When the user provides valid username
    And the user provides valid password
    Then the user validates menu order List
    Then click on view all products
    And then validate the table data