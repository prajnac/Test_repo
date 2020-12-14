@locationcheck


Feature: API tests


  Scenario Outline: As a user I want to verify that the city Frankfurt is
  in Germany and return their corresponded latitude and longitude

    Given The link is accessible
    Then confirm the city <City> is in <Country>

    Examples:
    |City|Country|
    |Frankfurt| Germany|

