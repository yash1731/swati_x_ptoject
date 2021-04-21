@regression
Feature: Reject and Approve an Onboarding Applications
  As an admin user
  I want to reject and Approve an applicant application
  So I ensure the proper checks and decision is done

  @severity=normal
  @reject
  Scenario: Reject Onboarding Applications
    Given I am on the Applications page
#   FTP SeedCX
    When I search for "Beatrice1 Otugo1" applications
    And I click on the FTP SeedCX button
    Then I should see a message to let me know that participant details is shared with SeedCX
  #   FTP Copper
    When I search for "Beatrice1 Otugo1" applications
    And I click on the FTP Copper button
    Then I should see a message to let me know that participant details is shared with Copper
#   Reject Application
 #   When I search for "Approved" applications
 #   And I click on the Reject button for one of the applications
 #    And I confirm rejection
 #   Then I should be able to see a success message that application has been rejected
  #  When I search for "Submitted" applications
#    Approve Application
  #  And I click on the Approve button
  #  Then I should see a message to let me know that application is approved


