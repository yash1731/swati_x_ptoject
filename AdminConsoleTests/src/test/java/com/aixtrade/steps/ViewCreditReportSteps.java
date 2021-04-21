package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ViewCreditReportSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;
    private Popovers popovers;

    public ViewCreditReportSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @And("^I select to credit check a specific application by clicking on the credit check button$")
    public void iSelectToCreditCheckASpecificApplicationByClickingOnTheCreditCheckButton() {
        applicationsPage = helper.getApplicationsPage().searchForApplication("submitted").clickCreditCheckButton();
        popovers = helper.getPopovers().completeAction();
    }

    @Then("^I should be able to see a \"([^\"]*)\" to let user know credit check has been done$")
    public void iShouldBeAbleToSeeAToLetUserKnowCreditCheckHasBeenDone(String creditCheckMessage) throws Throwable {
        creditCheckMessage = TestData.getValue(creditCheckMessage);
        assertThat(applicationsPage.validateCreditCheckMessage(creditCheckMessage), is(true));
    }

    @When("^I click on applicant's application$")
    public void iClickOnApplicantSApplication() {
        applicationsPage.searchForApplication("Swati Symphony User").viewSelectedApplications();
    }

    @When("^I select the credit Report menu$")
    public void iSelectTheCreditReportMenu() throws Throwable {
        applicationsPage.selectCreditCheckReportPage();
    }

    @Then("^I should be able to view that applicant's credit Report$")
    public void iShouldBeAbleToViewThatApplicantSCreditReport() {
        Assert.assertTrue(applicationsPage.validateCreditLimit());
        Assert.assertTrue(applicationsPage.validateCreditRating());
    }
}
