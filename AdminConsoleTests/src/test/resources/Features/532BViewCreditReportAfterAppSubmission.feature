#There is no credit report generated for any application
# @regression
#Feature: View Credit Report for a Submitted Application
#  As an authorised user
#  I want to view a user's Credit Report
#  So that I can decide on the status of an application
#
#  @viewReportForSub
#  Scenario:View applicant's Credit Report when an application is submitted
#    Given I am on the Applications page
#    When I search for "approved applications"
#    Then I should be able to see all submitted applications
#    When I select any of the submitted application and access the Credit Check Report page
#    Then I should be able to view the credit Report for that application