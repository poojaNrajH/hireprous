#Feature: Login Functionality of the Hirepros
#---------------------------------------------------------------------------------------------------------------------------------
# Authors : pooja                                                                                                                                                         Reviewer    :
# Date   : 14-04-2022                                                                                                                                                                  Reviewed On :
# Last Updated By:
# Last Updated On:
# Feature Name: Login functionality
# Feature Description: Login Functionality of the Hirepros
#---------------------------------------------------------------------------------------------------------------------------------
Feature: Login Functionality of the Hirepros

  #Scenario-1
  @SmokeTest
  Scenario: Login functionality
    Given User has to navigate to Hirepros login page
    When User enter username and password for Hirepros
    And User clicks on Login button
    Then User will be logged in successfully
