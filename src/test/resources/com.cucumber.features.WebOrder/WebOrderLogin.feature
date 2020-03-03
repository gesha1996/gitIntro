Feature: WebOrders login functionality


  Background:
    Given the user navigates to the web orders page

  Scenario: WebOrders login positive testing 1

    When the user provides valid username
    And the user provides valid password
    Then the user should see home page

@negative @smoke
  Scenario: WebOrders login negative testing with string

    When the user provides username "Test"
    And the user provides password "admin"
    Then the user should validate text "Invalid Login or Password"
@negative
  Scenario: WebOrders login negative testing with number

    When the user provides username 1234
    And the user provides password 67890
    Then the user should validate text "Invalid Login or Password"
@negative @smoke
  Scenario: WebOrders login negative testing with one step

    When the user provides username "Tester" and password "tt"
    Then the user should validate text "Invalid Login or Password"
@menuList
  Scenario: WebOrder menu positive testing 2
    Then the user validates menu order List
