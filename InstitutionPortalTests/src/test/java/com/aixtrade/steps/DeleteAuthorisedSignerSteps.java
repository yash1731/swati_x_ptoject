package com.aixtrade.steps;

import com.aixtrade.pages.*;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteAuthorisedSignerSteps {

    private WorldHelper helper;
    private AuthorisedSignersPage authorisedSignersPage;
    private AlertsAndPopovers alertsAndPopovers;

    public DeleteAuthorisedSignerSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Authorised Signer page$")
    public void iAmOnTheAuthorisedSignerPage() {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        authorisedSignersPage = helper
                .getBasePage()
                .loginWith(username, password)
                //.closeCookiePolicy()
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo()
                .goToAuthorisedSignersPage();
    }

    @When("^I select to delete an Authorised Signer$")
    public void iSelectToDeleteAnAuthorisedSigner() {
        alertsAndPopovers = authorisedSignersPage
                .clickDeleteAuthButton()
                .completeDelete();
    }

    @Then("^I should be able to see the Authorised Signers details deleted$")
    public void iShouldBeAbleToSeeTheAuthorisedSignersDetailsDeleted() {
    }
}
