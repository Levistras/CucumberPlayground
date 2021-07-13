@web-driver @send-keys
Feature: Clear and Enter Text
    As a basic user
    Filling out the demo inputs page

  Scenario: Clearing Text Field and entering text
    Given I go to "https://kavinschool.com/playground/DemoInputs.html"
    When I enter firstName "Kangeyan"
    * I enter lastName "Passoubady"
    * I enter email "kangs@kavinschool.com"
