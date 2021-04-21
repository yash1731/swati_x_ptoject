package com.aixtrade.steps;

import com.aixtrade.pages.InvitationEmailModal;
import com.aixtrade.pages.InvitationsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreviewOnboardingInvitationSteps {

    private WorldHelper helper;
    private InvitationEmailModal invitationEmailModal;
    private InvitationsPage invitationsPage;

    public PreviewOnboardingInvitationSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Invitations page$")
    public void iAmOnTheInvitationsPage() {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        invitationsPage = helper.getBasePage().loginWith(username, password).goToInvitationsPage();
    }

    @When("^I fill client's details on the 'Invite Institution' section as below:$")
    public void iFillClientSDetailsOnTheInviteInstitutionSectionAsBelow(DataTable dataTable) {
        List<List<String>> previewDetails = dataTable.raw();
        String name = TestData.getValue(previewDetails.get(1).get(1));
        String first = TestData.getValue(previewDetails.get(2).get(1));
        String last = TestData.getValue(previewDetails.get(3).get(1));
        String email = TestData.getValue(previewDetails.get(4).get(1));
        invitationsPage.fillInstitutionInformation(name, first, last, email);
    }

    @When("^I click on the 'Preview' button$")
    public void iClickOnThePreviewButton() throws Throwable {
        invitationEmailModal = invitationsPage.previewInvite();
    }

    @Then("^I should be able to preview invite to be sent with the below keywords:$")
    public void iShouldBeAbleToPreviewInviteToBeSentWithTheBelowKeywords(DataTable dataTable) {
        List<List<String>> previewInvite = dataTable.raw();
        String invite = TestData.getValue(previewInvite.get(1).get(1));
        String login = TestData.getValue(previewInvite.get(2).get(1));
        String email = TestData.getValue(previewInvite.get(3).get(1));
        assertThat(invitationEmailModal.validateModalBody(invite), is(true));
        assertThat(invitationEmailModal.validateLoginText(login), is(true));
        assertThat(invitationEmailModal.validateEmailAddress(email), is(true));
        invitationsPage = invitationEmailModal.closeModal();
    }

    @When("^I preview any of the existing invitations$")
    public void iPreviewAnyOfTheExistingInvitations(){
        invitationsPage.previewExistingInvitation();
    }

    @Then("^I should be able to preview sent invite with the below keywords:$")
    public void iShouldBeAbleToPreviewSentInviteWithTheBelowKeywords(DataTable dataTable) {
        List<List<String>> previewInvite = dataTable.raw();
        String invite = TestData.getValue(previewInvite.get(1).get(1));
        String login = TestData.getValue(previewInvite.get(2).get(1));
        assertThat(invitationEmailModal.validateModalBody(invite), is(true));
        assertThat(invitationEmailModal.validateLoginText(login), is(true));
        invitationsPage = invitationEmailModal.closeModal();
    }
}
