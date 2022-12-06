@tag
Feature: Five tasks in Github
  I want to use this template for my feature file
  
  Background:
	Given user send login credentials

  Scenario: Create New Repository
  Given user is on home page
  When user click on New Repo Text box
  And the user send the name as "AyyappanAlways" click on CreateRepo Box
  Then validate the Current url contains "AyyappanAlways" or not
  
  Scenario: Change Repository Name
    Given user is on home page
  When user click on search repo Text box with "AyyappanAlways"
  And the user click on first repo with has "AyyappanAlways"
  And the user click on setting tab
  And user click on rename field and send name as "AyyappanAlwaysTasks" and click on rename button
  Then validate the Current url contains the expected "AyyappanAlwaysTasks" or not

Scenario: Profile Name change
    Given user is on home page
  When user click on profile button
  And the user click on your profile button and click on edit profile button
  And the user send name as "AyyappanGunasekaran"
  And user click on save button

  
Scenario: Profile Bio change
    Given user is on home page
  When user click on profile button
  And the user click on your profile button and click on edit profile button
  And the user send Bio as "Part time engineer"
  And user click on save button
  
  Scenario: Search REpo
    Given user is on home page
  When user click on search box and pass data as "ninadpchaudhari/React-Tutorial" and press enter
  And the user click on particular repo
  Then verify current url contains "ninadpchaudhari/React-Tutorial"
  
  
  