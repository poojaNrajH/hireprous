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

  #Scenario-2
  @SmokeTest
  Scenario: Verifies customer creation field
    Given User navigates to the customer page of the Configuration
    When User clicks on new customer unit button
    And User Enters data to customer name,location,region field
    And User clicks on save button and navigate to customer list page

  #Scenario-3
  @SmokeTest
  Scenario: Filling Project creation
    Given User navigates to the Project page in the Configuration
    When User clicks on New Project button
    And User Enters data to Project name and business unit and customer from dropdown for project creation
    And User clicks on Save button and navigate to view Project list page
    Then User redirects to the configuration page

  #Scenario-4
  @SmokeTest
  Scenario: Verifies Recruitment Role creation
    Given User navigates to the Recruitment Role menu in the Configuration
    When User clicks on New Recruitment Role button
    And User Enters data to Recruitment Role name field and verifies
    And User clicks on Save button and navigate to view Recruitment Role list page
    Then User can search Recruitment name in search text-box
