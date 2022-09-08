Feature: Perform convert request

  Scenario: convert ECM walkthrough
    Given I am in Convert To ECM page
    When I click on convert request help? button walkthrough starts
    Then I click on Next button to point to next convert helper
    And I click on Done button to stop convert tab walkthrough
    
    
    Scenario: convert Parquet walkthrough
    Given I am in Convert To Parquet page
    When I click on Parquet request help? button walkthrough starts
    Then I click on Next button to point to next parquet helper
    And I click on Done button to stop parquet tab walkthrough
    
    #Scenario: perform convert To ECM request
    #Given user is on ECM request tab
    #When user ensures the Optim server status and provides inputs
    #Then conversion will start processing
