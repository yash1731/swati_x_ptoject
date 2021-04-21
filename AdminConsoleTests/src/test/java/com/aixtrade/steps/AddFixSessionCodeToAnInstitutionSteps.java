package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddFixSessionCodeToAnInstitutionSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public AddFixSessionCodeToAnInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on clear Institution info$")
    public void iClickOnClearInstitutionInfo() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().clickClearButton();
    }

    @When("^I enter the fix session code on Institution level$")
    public void iEnterTheFixSessionCodeOnInstitutionLevel() throws Throwable {
        String fixCode = TestData.getValue("fix code");
        institutionsPage.enterFixSessionCode(fixCode);
    }

    @Then("^I can view Fix session code is added against institution in the list$")
    public void iCanViewFixSessionCodeIsAddedAgainstInstitutionInTheList() throws Throwable {
        String fixCode = TestData.getValue("fix code");
        Assert.assertTrue(institutionsPage.validateFixCodeInList(fixCode));
    }
}
