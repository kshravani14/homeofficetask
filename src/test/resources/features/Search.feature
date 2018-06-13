Feature: As a customer I want to test search page functinality, as part of this testing sorting
          and printing search results


  @search
  Scenario: Searching for an item, sorting and listing results

    Given As a user, I navigated to Etsy home page
    And I click on Accept for GDPR settings if presented
    When I enter search term 'sports shoes' in the search box
    Then I can see search suggestions listed

    When I select the second suggestion from the list
    Then I can see search results page to be loaded

    When I sort the search results by 'Highest Price'
    Then I can see search results are sorted by 'Highest Price'
    And I print the prices of top '10' items