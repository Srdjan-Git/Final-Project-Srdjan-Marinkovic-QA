Feature: Automobile
  As I user should be able to search new and used automobiles to the app.

    Scenario Outline: Search automobile with filters
    As I user should be able to search new and used automobiles to the app and close filters and again search automobile and check results searches.

      Given I am on the polovni automobili home page and I load data from "TestData" "Automobiles" for "<tc_id>"
      When I click on cookie button
      And I select desire automobile brand
      And I select desire automobile model
      And I enter desire automobile price
      And I select desire automobile year from
      And I select desire automobile year to
      And I select desire automobile chassis
      And I select desire automobile fuel
      And I select desire automobile region
      And I select desire automobile old new vehicles
      And I check automobile waranty
      And I click search button
      And I click on survey button
      Then I should by see result search
      And I uncheck waranty filter
      And I cancel chassis filter
      And I cancel fuel filter
      And I cancel price filter
      And I cancel region filter
      And I select again desire automobile chassis
      And I click again to search button
      Then I should by see new result search

      Examples:
        | tc_id  |
        | TC_0001|