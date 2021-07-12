@web-driver @element-present
Feature: Presence of an Element
    As a basic user
    Check if an element is present or not

  Scenario: Edit Me button Element Presence
    Given I go to "https://kavinschool.com/playground/DemoInputs.html"
    Then I verify the Edit button should be present
