@home-page @web-driver
Feature: Check the title
  In order for landing in to the right page
  I want to check the title of osticket application

  @title-check
  Scenario: Verify the title of osticket application
    Given I go to "https://kavinschool.com/ticket/open.php"
    Then Title should be "osTicket-Support Ticket System-KavinSchool"
