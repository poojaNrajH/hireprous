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
  Scenario: Verifies Vendor creation
    Given User navigates to the Vendor Management page of the service
    When User clicks on Vendor Management button
    And User clicks on New Vendor Management button
    Then User Enters data to VendorName, ContactNo, Email,Location,and CCEmailIDs field and verifies
    And User clicks on Save button and navigate to view Vendor list page
    And User verify the added Vendor by searching
