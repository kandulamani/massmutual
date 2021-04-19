Feature: BalanceCheck operations
  To perform Balance Check operations

  Background: 
    Given I launch "browser"
    And I enter "URL"

  @mockTest
  Scenario: Need to verify the right count of values appear on the screen
    Then I verify the right count of values appear on the screen
    And I close the browser

  @mockTest
  Scenario: Need to verify the values on the screen are greater than 0
  Then I verify the values on the screen are greater than 0
    And I close the browser

  @mockTest
  Scenario: Need to verify the total balance is correct based on the values listed on the screen
  Then I verify the total balance is correct based on the values listed on the screen
    And I close the browser

  @mockTest
  Scenario: Need to verify the values are formatted as currencies
  Then I verify the values are formatted as currencies
    And I close the browser

  #@mockTest
  Scenario: Need to verify the total balance matches the sum of the values
  Then I verify the total balance matches the sum of the values
    And I close the browser

  
