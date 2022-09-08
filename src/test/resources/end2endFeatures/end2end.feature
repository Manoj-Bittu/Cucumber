Feature: End-to-End functionality

  @smoke
  Scenario: Login as admin and perform convert request
    Given I am in login page
    When I logged in with admin credentials
    Then I should navigate to Dashboard page
    And I do convert ECM and Parquet request

  @RegressionTest
  Scenario: Create new user
    Given User Logged In as admin
    When I clicked on Manage Users
    And I Create New user
    Then User should be added

  @BA-login
  Scenario: Login with Business Analyst
    Given User is in login page
    When I logged in with BA credentials
    Then I should be in Dashboard page
    And I should see reports tail

  #@Operator
  #Scenario: Login with operator
    #Given Operator is on login page
    #When I logged in as Operator
    #And I perform convert request
    #Then I should navigate to monitor page
    #And I shoould verify my request details
