@web-driver @frames
Feature: Handling Frames
    As a basic user
    Verify switching to a frame

  Scenario: Switching to a frame
    Given I go to "https://kavinschool.com/playground/frames.html"
    When I switch to frame index 1
    * I enter firstName "Kangeyan"
    * I enter lastName "Passoubady"
    * I enter email "kangs@kavinschool.com"
    * I switch to frame index 2
    Then I verfy "Quiz - Kavin School" header exist
