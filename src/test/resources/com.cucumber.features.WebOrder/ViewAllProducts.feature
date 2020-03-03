Feature: Test view all orders page
  Scenario: Tests view all orders
    Given the user navigates to the web orders page
    When user enters valid credentials "Tester" and "test"
    And user clicks to the view all orders button
    Then validates the "List of All Orders" header displayed