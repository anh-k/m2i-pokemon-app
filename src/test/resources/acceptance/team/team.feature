Feature: Save Team of Pokemon
  Scenario: Application wants to save a valid team in database
    Given Application saves Team from file "acceptance/team/valid.json"
    When Application wants to call Team with POST /teams/createOrUpdate
    Then Saves 1 Team
    Then Application receives http status code of 200 with Team

#  Scenario: Application wants to save an invalid team in database
#    Given Application saves Team from file "acceptance/team/invalid.json"
#    When Application wants to call Team with POST /teams/createOrUpdate
#    Then Saves 0 Team
#    Then Application receives http status code of 400 with Team