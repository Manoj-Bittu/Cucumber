Feature: Login Action
  Description: This feature will test a LogIn functionality

  @bvt @smoke
  Scenario: Login with valid username and password
    Given User is on Login page
    When User enters valid username and password
    And User clicks on Login button
    Then User should logged In and navigated to Dashboard page