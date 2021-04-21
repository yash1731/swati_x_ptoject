package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewUserPreferencesListSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public ViewUserPreferencesListSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I search for \"([^\"]*)\" in Institutions$")
    public void iSearchForInInstitutions(String institution) throws Throwable {
     //institution  = TestData.getValue("trade institution2");
     institutionsPage = helper.getInstitutionsPage().searchAnInstituton(institution);
    }

    @When("^I click on the 'Users' button$")
    public void iClickOnTheUsersButton() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().clickUsersButton();
    }


    @When("^I click on user preferences info button$")
    public void iClickOnUserPreferencesInfoButton() throws Throwable {
      institutionsPage.clickUserPrefInfoButton();
    }

    @Then("^I should able to see the user preferences of the specific user$")
    public void iShouldAbleToSeeTheUserPreferencesOfTheSpecificUser() throws Throwable {
        String ltc = TestData.getValue("ltc security");
        String pax = TestData.getValue("pax security");
        Assert.assertFalse(institutionsPage.validateLTCSecurity(ltc));
        Assert.assertFalse(institutionsPage.validatePAXSecurity(pax));

    }
}
