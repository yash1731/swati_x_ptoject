package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.When;

public class AddUpdateDeleteInstitutionUserSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public AddUpdateDeleteInstitutionUserSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I enable user as admin$")
    public void iEnableUserAsAdmin() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().enableUserAsAdmin();
    }

    @When("^I click on 'Update User' button$")
    public void iClickOnUpdateUserButton() throws Throwable {
       helper.getInstitutionsPage().clickUpdateUserButton();
    }

    @When("^I disable user as admin$")
    public void iDisableUserAsAdmin() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().enableUserAsAdmin();
    }

    @When("^I enable user as trader$")
    public void iEnableUserAsTrader() throws Throwable {
        institutionsPage.enableUserAsTrader();
    }

    @When("^I disable user as trader$")
    public void iDisableUserAsTrader() throws Throwable {
        institutionsPage.enableUserAsTrader();
    }

    @When("^I enable user as market maker$")
    public void iEnableUserAsMarketMaker() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().enableUserAsMM();
    }

    @When("^I disable user as market maker$")
    public void iDisableUserAsMarketMaker() throws Throwable {
        institutionsPage.enableUserAsMM();
    }

}
