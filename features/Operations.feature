Feature: Stylelabs Assessment

  Scenario Outline: Perform a google search and verify the result
    Given I launch the google search page
    When I search for "<location>"
    Then I should see the search result page
    And I take the screenshot of the result page

    Examples: 
      | location  |
      | Bahamas   |
      | Amsterdam |

  Scenario: Search for Flight+accomdation on expedia and verify the result
    Given I launch the Expedia US version application
    When I search for flight from "Brussels" to "_New york"
    And I enter travelers details as "1" adult and "1" child of "3" years age
    And I enter other itinerary details and search
    Then I should see the travel options for searched destination

  Scenario: Verify the new york's max temparature is below 10degree celsius
    When I make a get request to Openweathermap api and verify the max temprature is below 10
