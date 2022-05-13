Feature: Registration

  Background:
    Given I go to register

  Scenario: Successful registration with valid entries

    When email, firstname,lastname,username,password entered
    And set role as user,set enabled and save user
    Then user created


  Scenario: Unsuccessful registration with invalid password

    When email, firstname,lastname,username,password entered
    But password is not valid
    Then prints "invalid password"

