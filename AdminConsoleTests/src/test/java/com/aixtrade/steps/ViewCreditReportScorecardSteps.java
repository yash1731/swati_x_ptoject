package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.pages.CreditScoreCardModal;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ViewCreditReportScorecardSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;
    private CreditScoreCardModal creditScoreCardModal;

    public ViewCreditReportScorecardSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\" on this page$")
    public void iSearchForOnThisPage(String application) throws Throwable {
        application = TestData.getValue(application);
        applicationsPage = helper.getApplicationsPage().searchForApplication(application);
    }

    @And("^I select to view the credit report scorecard for any of the displayed applications$")
    public void iSelectToViewTheCreditReportScorecardForAnyOfTheDisplayedApplications(){
        creditScoreCardModal = applicationsPage.clickCreditScoreCardButton();
    }

    @Then("^I should be able to see the credit score card displayed$")
    public void iShouldBeAbleToSeeTheCreditScoreCardDisplayed() {
        Assert.assertTrue(creditScoreCardModal.validateCreditScoreTitle());
    }

    @And("^the credit score card will have the following details below:$")
    public void theCreditScoreCardWillHaveTheFollowingDetailsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        String riskLevel = TestData.getValue(fieldOption.get(1).get(1));
        String creditLimit = TestData.getValue(fieldOption.get(2).get(1));
        String status = TestData.getValue(fieldOption.get(3).get(1));
        Assert.assertTrue(creditScoreCardModal.validateCreditScoreCardDetails(riskLevel));
        Assert.assertTrue(creditScoreCardModal.validateCreditScoreCardDetails(creditLimit));
        Assert.assertTrue(creditScoreCardModal.validateCreditScoreCardDetails(status));
    }
}
