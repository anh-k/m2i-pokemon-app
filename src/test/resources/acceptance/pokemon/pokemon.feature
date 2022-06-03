Feature: Pokemon
  Scenario: Application wants to save a valid pokemon in database
    Given Application saves Pokemon from file "acceptance/pokemon/valid.json"
    When Application wants to call Pokemon with POST /pokemon/createOrUpdate
    Then Saves 1 Pokemon
    Then Application receives http status code of 200 with Pokemon

#  Scenario: Application wants to save an invalid pokemon in database
#    Given Application saves Pokemon from file "acceptance/pokemon/invalid.json"
#    When Application wants to call Pokemon with POST /pokemon/createOrUpdate
#    Then Saves 0 Pokemon
#    Then Application receives http status code of 400 with Pokemon