@web-driver @get-title
Feature: Getting Title
    As a basic user
    Get website title

  Scenario: Fetching Website Title
    When I go to "https://kavinschool.com/playground/DemoInputs.html"
    Then Title should be "Kavin School-Input Elements"
