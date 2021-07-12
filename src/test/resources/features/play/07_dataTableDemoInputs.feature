@web-driver @data-table
Feature: Clear and Enter Text
    As a basic user
    Filling out the demo inputs page using page objects

  Scenario Outline: Scenario Outline name: Clearing Text Field and entering text
    Given I go to "https://kavinschool.com/playground/DemoInputs.html"
    When I enter firstName "<firstName>"
    And I enter lastName "<lastName>"
    And I enter email "<email>"

    Examples: 
      | firstName | lastName   | email                 |
      | Kangeyan  | Passoubady | kangs@kavinschool.com |
      | jill      | schubbs    | jill@lm.com           |
      | doreen    | weorer     | doreen@lm.com         |
      | keith     | kepler     | keith@lm.com          |
      | john      | doe        | john@lm.com           |
      | mike      | wednesday  | mike@lm.com           |
