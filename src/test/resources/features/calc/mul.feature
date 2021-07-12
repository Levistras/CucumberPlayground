@mul @calc
Feature: Multiply

    Multiply Feature verification

    Scenario Outline: Multiply two numbers
        Given the numbers <x> and <y>
        When they are multiplied
        Then the expected result should be <result>

        Examples:
            | x | y | result |
            | 8 | 4 | 32     |
            | 4 | 2 | 8      |
            | 9 | 3 | 27     |
