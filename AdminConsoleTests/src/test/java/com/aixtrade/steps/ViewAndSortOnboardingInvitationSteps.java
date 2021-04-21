package com.aixtrade.steps;

import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ViewAndSortOnboardingInvitationSteps {

    private WorldHelper helper;

    public ViewAndSortOnboardingInvitationSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I can view all invitations$")
    public void iCanViewAllInvitations() {
        Assert.assertNotNull(helper.getInvitationsPage().viewListOfInvitations());
        Assert.assertTrue(helper.getInvitationsPage().viewListOfInvitations());
    }

    @And("^I can sort entries based on preferred choice$")
    public void iCanSortEntriesBasedOnPreferredChoice() {
        helper.getInvitationsPage().filterInvitationsEntries();
    }
}
