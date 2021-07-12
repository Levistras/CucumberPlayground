@web-driver @frames
Feature: Handling Frames
    As a basic user
    Verify switching to a frame

  Scenario: Switching to a frame
    Given I go to "https://kavinschool.com/playground/frames.html"
    When I switch to frame index 1
    When I enter firstName "Kangeyan"
    And I enter lastName "Passoubady"
    And I enter email "kangs@kavinschool.com"
    And I switch to frame index 2
    And I verfy "Quiz - Kavin School" header exist
