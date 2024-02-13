Feature: An example

  Scenario: The example
    Given Open page "https://www.google.com/"
    Then User type message in field "Найти" to search "Первый тест Java + Cucumber + Playwright"
    Then User click the button "Поиск в Google"
    And User see in results page "Playwright: полный гайд + FAQ"
