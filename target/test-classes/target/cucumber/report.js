$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:test/locationcheck.feature");
formatter.feature({
  "name": "API tests",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@locationcheck"
    }
  ]
});
formatter.scenarioOutline({
  "name": "As a user I want to verify that the city Frankfurt is",
  "description": "  in Germany and return their corresponded latitude and longitude",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The link is accessible",
  "keyword": "Given "
});
formatter.step({
  "name": "confirm the city \u003cCity\u003e is in \u003cCountry\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "City",
        "Country"
      ]
    },
    {
      "cells": [
        "Frankfurt",
        "Germany"
      ]
    }
  ]
});
formatter.scenario({
  "name": "As a user I want to verify that the city Frankfurt is",
  "description": "  in Germany and return their corresponded latitude and longitude",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@locationcheck"
    }
  ]
});
formatter.step({
  "name": "The link is accessible",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "confirm the city Frankfurt is in Germany",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});