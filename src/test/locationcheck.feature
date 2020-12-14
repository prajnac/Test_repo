@locationcheck


Feature: API tests


  Scenario Outline: As a user I want to verify that the city Frankfurt is
  in Germany and return their corresponded latitude and longitude

    Given The link is accessible
    Then confirm the city <city> is in <country>

    Examples:
    |city|country|
    |Frankfurt| Germany|

