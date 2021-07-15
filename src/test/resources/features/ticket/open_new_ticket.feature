@web-driver @osticket @new-ticket
Feature: Check the opening of a new ticket in osticket application
  I want to open a new ticket using osticket application
  I want to check whether the ticket successfully submitted

  Background: Verify the title of osticket application
    Given I go to "https://kavinschool.com/ticket/index.php"
    Then Title should be "osTicket-Support Ticket System-KavinSchool"

  @form-check
  Scenario Outline: Verify new ticket creation in osticket application
    When I clicked on the Open New Ticket button
    Then I wait for "Open a New Ticket" header text to show
    * I verify paragraph text exists "Please fill in the form below to open a new ticket."
    * I verify h3 text exists "Contact Information"
    * I verify span contains text "Email Address"
    * I verify span contains text "Full Name"
    * I verify span contains text "Phone Number"
    * I verify bold label exist "Help Topic"
    When I type email address "<emailAddress>" value
    * I type full name "<fullName>" value
    * I type telephone "<phoneNumber>" and "<ext>" value
    * I type select a help topic "<helpTopic>" from dropdown
    * I verify span contains text "Issue Summary"
    * I verify h3 text exists "Ticket Details"
    * I verify div contains text "Please Describe Your Issue"
    Then I type a subject "<issueSummary>" value
    * I type a message "<message>" value
    * I attach a file "<file>"
    And I click on the Create Ticket button
    When I waited for a new created message shows up with "Support ticket request created"
    And I verify that the message contains first name "<fullName>"

    Examples: 
      | fullName   | emailAddress          | phoneNumber    | ext  | helpTopic | issueSummary         | message                         | file |
      | Kangeyan Passoubady | kpassoubady@gmail.com | 1-510-991-7591 | 1234 | Feedback  | Testing a new ticket | Testing a ticket with a message | media/logo-automation.png|
      #| Lovely Dad | lovely@kavinschool.com | 1-510-991-7591 |  1234  | Feedback | Testing a new ticket | Testing a ticket with a message| media/logo-book1.png |
