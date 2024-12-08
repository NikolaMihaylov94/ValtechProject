Feature:BrokenInfo

  Scenario: Search for broker and look at the information attached
    Given I open "https://www.yavlena.com/en/broker?city=Sofia" url
    And I click "Clear" mui-button
    And I fill "Name" input field with "Aleksandar Petkov"
    And I see only "Aleksandar Petkov" mui-card on the page
    And I click "Details" mui-button
    And I see "+359 2 926 26" mui-link
    And I see "+359 888 106 040" mui-link
    And I see "11 properties" mui-link
    And I see "Aleksandar Petkov" mui-card contains "Sofia / Office Center" subtext
    And I see "Aleksandar Petkov" mui-card contains 'Real-estate agent, Department. "Sales and Rentals"' subtext