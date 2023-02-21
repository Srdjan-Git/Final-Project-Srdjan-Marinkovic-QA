Feature: Bus
  As I user should be able to search new and used bus to the app.

  Scenario Outline: Search bus with filters
  As I user should be able to more detailed search new and used bus to the app and and check results searches.

    Given I am on the polovni automobili home page for bus and I load data from "TestData" "Buses" for "<tc_id>"
    When I click on cookie button page bus
    And I clicked on icon transport vehicles in menu
    And I clicked on icon bus in sub menu
    And I clicked on search button on bus page
    And I select desire bus brand
    And I enter desire bus price from
    And I enter desire bus price to
    And I select desire bus year from
    And I select desire bus year to
    And I select desire bus km from
    And I select desire bus km to
    And I select desire bus fuel
    And I select desire bus region
    And I select bus seats from
    And I select bus seats to
    And I click search button bus
    Then I should by see result search bus

    Examples:
      | tc_id  |
      | TC_0001|