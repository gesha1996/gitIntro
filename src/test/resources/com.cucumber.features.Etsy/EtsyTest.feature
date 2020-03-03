Feature: Etsy website discovery

  Background:
    Given user navigates to the etsy website

  @spoon
  Scenario: search for wooden spoon
    When user searches for "wooden spoon"
    Then user validates the title "Wooden spoon | Etsy"

  @makeUpOrganizer
  Scenario: make up organizer
    When user searches for "make up organizer"
    Then user validates the title "Make up organizer | Etsy"
