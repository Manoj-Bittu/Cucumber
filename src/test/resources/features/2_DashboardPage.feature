Feature: Dashboard Action
  Description: This feature will test a Dashboard functionality

  Scenario: Validate the welcome note
    Given User logged into application
    When User navigates to Dashboard page
    Then Welcome note with user name should visible

  Scenario: Verify Dashboard Help ?(walkthrough)
    When user clicks on Help ? button walkthrough start
    Then user clicks on Next button walkthrough point to next tail
    And User clicks on Done button walkthrough stops
