Feature:

  Background:
    Given I go to login

  Scenario:
    When 'username' and 'password' entered
    And control 'username' exists and 'password' matches
    Then prints true on the screen
    |username   |irem|
    |password   | Testing193! |


