package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewAMLAndKYCReportsSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;
    private Popovers popovers;

    public ViewAMLAndKYCReportsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on selected applicant's application$")
    public void iClickOnSelectedApplicantSApplication() throws Throwable {
       applicationsPage = helper.getApplicationsPage().viewSelectedApplications();
    }

    @When("^I select the Authorised Signer menu$")
    public void iSelectTheAuthorisedSignerMenu() throws Throwable {
        applicationsPage.selectAuthorisedSignerMenu();
    }

    @Then("^I should be able to view the Authorised signer of the application$")
    public void iShouldBeAbleToViewTheAuthorisedSignerOfTheApplication() throws Throwable {
       applicationsPage.viewAllAuthorisedSigners();
    }

    @When("^I click on 'View' AML report button$")
    public void iClickOnViewAMLReportButton() throws Throwable {
      applicationsPage.clickViewAMLReportButton();
    }

    @Then("^I should see the AML report of the selected Authorised Signer$")
    public void iShouldSeeTheAMLReportOfTheSelectedAuthorisedSigner() throws Throwable {
        String authSigner = TestData.getValue("auth signer");
        Assert.assertTrue(applicationsPage.validateAMLReportForUser(authSigner));

    }

    @Then("^I click on 'Close' AML report button$")
    public void iClickOnCloseAMLReportButton() throws Throwable {
        applicationsPage.closeAMLReport();
    }

    @When("^I click on 'View' KYC report button$")
    public void iClickOnViewKYCReportButton() throws Throwable {
        applicationsPage.clickViewKYCReportButton();
    }

    @Then("^I should see the KYC report of the selected Authorised Signer$")
    public void iShouldSeeTheKYCReportOfTheSelectedAuthorisedSigner() throws Throwable {
        String authSigner = TestData.getValue("auth signer");
        Assert.assertTrue(applicationsPage.validateKYCReportForUser(authSigner));
    }

    @Then("^I click on 'Close' KYC report button$")
    public void iClickOnCloseKYCReportButton() throws Throwable {
        applicationsPage.closeKYCReport();
    }

    @When("^I click on 'Reset' AML report button$")
    public void iClickOnResetAMLReportButton() throws Throwable {
        popovers = helper.getApplicationsPage().clickResetAMLReportButton().completeAction();
    }

    @Then("^I should able to see \"([^\"]*)\"$")
    public void iShouldAbleToSee(String message) throws Throwable {
      Assert.assertTrue(applicationsPage.validateAMLKYCStatusMessage(message));
    }

    @When("^I click on 'Reset' KYC report button$")
    public void iClickOnResetKYCReportButton() throws Throwable {
        popovers = helper.getApplicationsPage().clickResetKYCReportButton().completeAction();
    }

    @When("^I click on 'Run' AML checks for all authorised signer$")
    public void iClickOnRunAMLChecksForAllAuthorisedSigner() throws Throwable {
        popovers = helper.getApplicationsPage().clickRunAMLChecksButton().completeAction();
    }

    @When("^I click on 'Run' KYC checks for all authorised signer$")
    public void iClickOnRunKYCChecksForAllAuthorisedSigner() throws Throwable {
        popovers = helper.getApplicationsPage().clickRunKYCCheckstButton().completeAction();
    }

}
