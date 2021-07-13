@web-driver @get-text
Feature: Getting Text
    As a basic user
    Check text of any element

    Scenario: Fetch text from a web element
        Given I go to "https://kavinschool.com/playground/DemoInputs.html"
        Then First H2 Element should match with "Provide Your Details:"