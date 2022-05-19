#Feature: Checking services functionality of HirePros
#---------------------------------------------------------------------------------------------------------------------------------
# Authors : pooja                                                                                                                                                         Reviewer    :
# Date   : 14-04-2022                                                                                                                                                                  Reviewed On :
# Last Updated By:
# Last Updated On:
# Feature Name: services functionality of HirePros
# Feature Description: Checking services functionality of HirePros
#---------------------------------------------------------------------------------------------------------------------------------
Feature: Checking services functionality of HirePros

  #Scenario-1
  @SmokeTest
  Scenario: Filling Resources creation
    Given User clicks on Services
    When User clicks on Resource Management button
    And User clicks on New Resource Management button
    User Enters data to EmployeeId, EmployeeId By HR, WorkOrderNumber, Employment Type, 
    FirstName, LastName, ContactNo, Email, Gender, Project Allocation,CustomerName, 
    Project Name, Business Unit, Designation,Year Of Experience, Skillset field and verifies
    And User clicks on Save button and navigate to view Resources list page
    And User verify the added Resource by searching
