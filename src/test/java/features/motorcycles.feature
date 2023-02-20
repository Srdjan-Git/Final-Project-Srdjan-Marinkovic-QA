Feature: Motorcycles
  As I user should be able to search new and used motorcycles to the app.

  Scenario: Search motorcycles with filters
  As I user should be able to search new and used motorcycles to the app and sort the obtained results by descending price.

    Given I am on the polovni automobili home page for motorcycles
    When I click on cookie button page motorcycles
    And I clicked on icon motorcycles in menu
    And I select desire motorcycles brand
    And I enter desire motorcycles price
    And I select desire motorcycles year from
    And I select desire motorcycles year to
    And I select desire motorcycles type
    And I select desire motorcycles region
    And I select another desire motorcycles type
    And I select another desire motorcycles region
    And I check motorcycles credit
    And I click search button motorcycles
    Then I should by see result search motorcycles
    And I  to sort by descending price