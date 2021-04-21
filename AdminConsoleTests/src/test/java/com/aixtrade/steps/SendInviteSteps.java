package com.aixtrade.steps;

import com.aixtrade.pages.InvitationsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SendInviteSteps {

    private WorldHelper helper;
    private InvitationsPage invitationsPage;

    public SendInviteSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on the 'Resend' Invite button for any of the invitations on the list$")
    public void iClickOnTheResendInviteButtonForAnyOfTheInvitationsOnTheList() {
        invitationsPage = helper.getInvitationsPage().resendInvite();
    }

    @Then("^I should be able to receive a \"([^\"]*)\" for invite sent to the client$")
    public void iShouldBeAbleToReceiveAForInviteSentToTheClient(String message) throws Throwable {
        message = TestData.getValue(message);
        invitationsPage.validateResentInvite(message);
    }
}
