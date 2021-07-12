@web-driver @get-url
Feature: Getting URL
    As a basic user
    Get website Url

  Scenario: Fetching Website URL
    When I go to "https://kavinschool.com/playground/DemoInputs.html"
    Then URL should be "https://kavinschool.com/playground/DemoInputs.html"
