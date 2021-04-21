package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RejectAndApproveOnboardingApplicationSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;
    private Popovers popovers;

    public RejectAndApproveOnboardingApplicationSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\" applications$")
    public void iSearchForApplications(String approved) throws Throwable {
        applicationsPage = helper.getApplicationsPage().searchForApplication(approved);
    }

    @And("^I click on the Reject button for one of the applications$")
    public void iClickOnTheRejectButtonForOneOfTheApplications() {
        popovers = applicationsPage.clickRejectButton();
    }

    @When("^I confirm rejection$")
    public void iConfirmRejection() throws Throwable {
        popovers.completeAction();
    }

    @Then("^I should be able to see a success message that application has been rejected$")
    public void iShouldBeAbleToSeeASuccessMessageThatApplicationHasBeenRejected() throws Throwable {
        String rejectMessage = TestData.getValue("reject message");
        Assert.assertTrue(helper.getApplicationsPage().validateCreditCheckMessage(rejectMessage));
    }

    @When("^I click on the Approve button$")
    public void iClickOnTheApproveButton() throws Throwable {
        popovers = helper.getApplicationsPage().clickApproveButton().completeAction();
    }

    @Then("^I should see a message to let me know that application is approved$")
    public void iShouldSeeAMessageToLetMeKnowThatApplicationIsApproved() {
        String approveMessage = TestData.getValue("approve message");
        Assert.assertTrue(applicationsPage.validateCreditCheckMessage(approveMessage));
    }


    @When("^I click on the FTP SeedCX button$")
    public void iClickOnTheFTPSeedCXButton() throws Throwable {
        String name = TestData.getValue("seedCX docs");
        applicationsPage.clickFTPSeedCXButton(name).completeAction();

    }

    @Then("^I should see a message to let me know that participant details is shared with SeedCX$")
    public void iShouldSeeAMessageToLetMeKnowThatParticipantDetailsIsSharedWithSeedCX() throws Throwable {
        String ftpSeedCXMessage = TestData.getValue("ftpSeedCX message");
        Assert.assertTrue(helper.getApplicationsPage().validateCreditCheckMessage(ftpSeedCXMessage));
    }

    @When("^I click on the FTP Copper button$")
    public void iClickOnTheFTPCopperButton() throws Throwable {
        String name = TestData.getValue("copper docs");
        applicationsPage.clickFTPSeedCXButton(name).completeAction();
    }

    @Then("^I should see a message to let me know that participant details is shared with Copper$")
    public void iShouldSeeAMessageToLetMeKnowThatParticipantDetailsIsSharedWithCopper() throws Throwable {
        String ftpCopperMessage = TestData.getValue("ftpCopper message");
        Assert.assertFalse(helper.getApplicationsPage().validateCreditCheckMessage(ftpCopperMessage));

    }
}
