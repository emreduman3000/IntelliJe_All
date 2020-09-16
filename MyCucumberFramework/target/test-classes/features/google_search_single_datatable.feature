@datatable1
Feature: Single Data Table

  Scenario Outline: TC01_ google search test
    Given user is in the google page
    And user searches "<value>"
    Then verify result has "<value>"

    Examples: Test Data
      |value|
      |Selenium|
      |Cucumber|
      |Automation Tester|
      |Istanbul         |

#4 tane value yazdım ve runner cllasssını calsıtırınca 4 kez test edicek
 #   //And , Then stepleri defined olmadıgı ici 2 tane method verecek bize consolda