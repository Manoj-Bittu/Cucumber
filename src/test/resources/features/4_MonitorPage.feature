Feature: Monitor the requests

  Scenario: Monitor ECM walkthrough
    Given I am in monitor ECM tab
    When I click on ECM tab help? button walkthrough starts
    Then I click on Next button to point to next ECM helper
    And I click on Done button to stop ECM tab walkthrough

  Scenario: ECM Request Details walkthrough
    When I click on ECM Request Id
    Then I should navigate to ECM Request details
    When I click on ECM Request details help? button walkthrough starts
    Then I click on Next button to point to next ECM Request details helper
    And I click on Done button to stop ECM Request details walkthrough

  Scenario: Monitor Parquet walkthrough
    Given I am in monitor Parquet tab
    When I click on Parquet tab help? button walkthrough starts
    Then I click on Next button to point to next Parquet helper
    And I click on Done button to stop Parquet tab walkthrough
    
    
  Scenario: Parquet Request Details walkthrough
    When I click on Parquet Request Id
    Then I should navigate to Parquet Request details
    When I click on Parquet Request details help? button walkthrough starts
    Then I click on Next button to point to next Parquet Request details helper
    And I click on Done button to stop Parquet Request details walkthrough
    

