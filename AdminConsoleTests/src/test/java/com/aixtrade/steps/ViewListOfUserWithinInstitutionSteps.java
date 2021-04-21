package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewListOfUserWithinInstitutionSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public ViewListOfUserWithinInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select a specific institution$")
    public void iSelectASpecificInstitution() throws Throwable {
        institutionsPage = helper.getInstitutionsPage();
    }

    @When("^I click on the 'View Users' button$")
    public void iClickOnTheViewUsersButton() throws Throwable {
        institutionsPage.viewUsersWithinAnInstitution();
    }

    @Then("^I should be able to see users associated with that specific institution$")
    public void iShouldBeAbleToSeeUsersAssociatedWithThatSpecificInstitution() throws Throwable {
        Assert.assertNotNull(helper.getInstitutionsPage().validateUsersExist());
       Assert.assertTrue(helper.getInstitutionsPage().validateUsersExist());
    }
}
