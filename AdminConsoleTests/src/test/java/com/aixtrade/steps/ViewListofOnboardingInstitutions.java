package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ViewListofOnboardingInstitutions {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public ViewListofOnboardingInstitutions(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Institutions page$")
    public void iAmOnTheInstitutionsPage() {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        institutionsPage = helper.getBasePage().loginWith(username, password).goToInstitutionsPage();
    }

    @Then("^I should be able to see all institutions$")
    public void iShouldBeAbleToSeeAllInstitutions() {
        Assert.assertNotNull(institutionsPage.validateApplicationsExist());
        Assert.assertTrue(institutionsPage.validateApplicationsExist());
    }
}
