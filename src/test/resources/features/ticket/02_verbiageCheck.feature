@home-page @web-driver
Feature: Check the title and verify all the verbiages
  In order for landing in to the right page
  I want to check the title of osticket application

  @verbiages-check
  Scenario: Verify verbiages of osticket application home page
    Given I go to "https://kavinschool.com/ticket/index.php"
    Then I verify the header text contains "Welcome to the Support Center"
    * I verify the paragraph contains "In order to streamline support requests and better serve you, we utilize a support ticket system. Every support request is assigned a unique ticket number which you can use to track the progress and responses online. For your reference we provide complete archives and history of all your support requests. A valid email address is required to submit a ticket."
