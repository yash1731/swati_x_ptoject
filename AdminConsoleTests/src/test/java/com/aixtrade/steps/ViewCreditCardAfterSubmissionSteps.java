package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewCreditCardAfterSubmissionSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;

    public ViewCreditCardAfterSubmissionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String approved) throws Throwable {
        approved = TestData.getValue(approved);
       applicationsPage = helper.getApplicationsPage().searchForApplication(approved);
    }

    @Then("^I should be able to see all submitted applications$")
    public void iShouldBeAbleToSeeAllSubmittedApplications() {
        applicationsPage.validateSubmittedApplications();
    }

    @When("^I select any of the submitted application and access the Credit Check Report page$")
    public void iSelectAnyOfTheSubmittedApplicationAndAccessTheCreditCheckReportPage() {
        applicationsPage.viewSelectedApplications().selectCreditCheckReportPage();
    }

    @Then("^I should be able to view the credit Report for that application$")
    public void iShouldBeAbleToViewTheCreditReportForThatApplication() {
        Assert.assertTrue(applicationsPage.validateCreditLimit());
        Assert.assertTrue(applicationsPage.validateCreditRating());
    }
}
