Feature: Save User
  Scenario: Application wants to save a valid user in database
    Given Application saves User from file "acceptance/user/valid.json"
    When Application wants to call User with POST /user/register
    Then Saves 1 User
    Then Application receives http status code of 200 with User