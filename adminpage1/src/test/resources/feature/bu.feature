#Feature: Checking configurations functionality of HirePros
#---------------------------------------------------------------------------------------------------------------------------------
# Authors : pooja                                                                                                                                                         Reviewer    :
# Date   : 14-04-2022                                                                                                                                                                  Reviewed On :
# Last Updated By:
# Last Updated On:
# Feature Name: Configurations functionality of HirePros
# Feature Description: Checking configurations functionality of HirePros
#---------------------------------------------------------------------------------------------------------------------------------
Feature: Checking configurations functionality of HirePros


  #Scenario-1
  @SmokeTest
  Scenario: Filling Business Unit creation
    Given User navigates to the Business Unit page of the Configuration
    When User clicks on New Business Unit button
    And User Enters data to Business Unit name and manager name
    And User clicks on Save button and navigate to Business Unit list page
