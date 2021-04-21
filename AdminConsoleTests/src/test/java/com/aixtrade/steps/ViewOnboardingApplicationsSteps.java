package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewOnboardingApplicationsSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;

    public ViewOnboardingApplicationsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Applications page$")
    public void iAmOnTheApplicationsPage() {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        applicationsPage = helper.getBasePage().loginWith(username, password).goToApplicationsPage();
    }

    @Then("^I should be able to see all applications and their status$")
    public void iShouldBeAbleToSeeAllApplicationsAndTheirStatus() {
        Assert.assertNotNull(applicationsPage.validateApplicationsExist());
        Assert.assertTrue(applicationsPage.validateApplicationsExist());
    }

    @When("^I select to view a specific user's application$")
    public void iSelectToViewASpecificUserSApplication() throws Throwable {
        String app = TestData.getValue("app search");
        applicationsPage.searchForApplication(app);
        applicationsPage.viewSelectedApplications();
    }

    @Then("^I should be able to see client's individual application$")
    public void iShouldBeAbleToSeeClientSIndividualApplication() throws Throwable {
        Assert.assertTrue(applicationsPage.validateAllApplicationPages());
    }
}
