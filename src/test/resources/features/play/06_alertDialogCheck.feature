@web-driver @alert
Feature: Handling JavaScript PopUps
    As a basic user
    Verify and accept a JavaScript popup alert

  Scenario: Accept Javascript Alert
    Given I go to "https://kavinschool.com/playground/DemoInputs.html"
    When I click on submit button
    Then I accept popup alert with msg "Thank You for submitting!!"
