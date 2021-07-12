@web-driver @drop-dwon
Feature: DropDown Handling
    As a basic user
    Select a value from dropdown

  Scenario: Select Dropdown value
    Given I go to "https://kavinschool.com/playground/DemoInputs.html"
    Then I select training choice from the dropdown
