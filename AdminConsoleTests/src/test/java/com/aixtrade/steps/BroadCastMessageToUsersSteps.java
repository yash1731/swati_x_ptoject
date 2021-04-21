package com.aixtrade.steps;

import com.aixtrade.pages.BroadcastMessagesPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BroadCastMessageToUsersSteps {

    private WorldHelper helper;
    private BroadcastMessagesPage broadcastMessagesPage;

    public BroadCastMessageToUsersSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I select a user associated to selected institution$")
    public void iSelectAUserAssociatedToSelectedInstitution() throws Throwable {
        String user = TestData.getValue("broadcast user1");
       broadcastMessagesPage = helper.getBroadcastMessagesPage().clickUsers().selectUser(user);
    }

    @Then("^I enter the announcements to broadcast to a user$")
    public void iEnterTheAnnouncementsToBroadcastToAUser() throws Throwable {
        String userMessage1 = TestData.getValue("user message1");
        broadcastMessagesPage.enterTextToBroadcast(userMessage1);
    }

    @Then("^I can verify the broadcasted message to a user in the list$")
    public void iCanVerifyTheBroadcastedMessageToAUserInTheList() throws Throwable {
        String broadcastMessage = TestData.getValue("broadcast alert");
        broadcastMessagesPage.validateBroadcastMessage(broadcastMessage);
        broadcastMessagesPage.validateBroadcastMessageHistory();
    }

    @When("^I open the Broadcasted Info Details sent to user$")
    public void iOpenTheBroadcastedInfoDetailsSentToUser() throws Throwable {
        String userMessage = TestData.getValue("user message1");
        broadcastMessagesPage.searchMessage(userMessage).broadcastInfoDetails();
    }


    @Then("^I can verify a selected user of an Institution$")
    public void iCanVerifyASelectedUserOfAnInstitution() throws Throwable {
        String broadcastUser = TestData.getValue("broadcast user1");
        broadcastMessagesPage.validateSelectedUserOfAnInstitution(broadcastUser);
        broadcastMessagesPage.closeInfoDetails();
    }

    @When("^I select a institution to Broadcast Message to multiple users$")
    public void iSelectAInstitutionToBroadcastMessageToMultipleUsers() throws Throwable {
        String broadcastInstitution = TestData.getValue("broadcast institution");
        broadcastMessagesPage.clickInstitution(broadcastInstitution).selectAnInstitution(broadcastInstitution).selectAnInstitution(broadcastInstitution);
    }


    @When("^I select multiple users of an institution to Broadcast Message$")
    public void iSelectMultipleUsersOfAnInstitutionToBroadcastMessage() throws Throwable {
        //String broadcastUser = TestData.getValue("broadcast user1");
        String selectUser = TestData.getValue("broadcast user2");
        broadcastMessagesPage = helper.getBroadcastMessagesPage().selectUser(selectUser);
    }

    @When("^I enter the announcements to broadcast to multiple Users$")
    public void iEnterTheAnnouncementsToBroadcastToMultipleUsers() throws Throwable {
        String userMessage = TestData.getValue("user message2");
        broadcastMessagesPage.enterTextToBroadcast(userMessage);
    }

    @Then("^I can verify the broadcasted message to multiple Users of an Institution in the list$")
    public void iCanVerifyTheBroadcastedMessageToMultipleUsersOfAnInstitutionInTheList() throws Throwable {
        String broadcastMessage = TestData.getValue("broadcast alert");
        broadcastMessagesPage.validateBroadcastMessage(broadcastMessage);
        broadcastMessagesPage.validateBroadcastMessageHistory();
    }

    @Then("^I can verify multiple users associated to an institution$")
    public void iCanVerifyMultipleUsersAssociatedToAnInstitution() throws Throwable {
        String broadcastUser = TestData.getValue("broadcast user1");
        String broadcastUser2 = TestData.getValue("broadcast user2");
        broadcastMessagesPage.validateSelectedUserOfAnInstitution(broadcastUser);
        broadcastMessagesPage.validateSelectedUserOfAnInstitution(broadcastUser2);
    }


    @When("^I open the Broadcasted Info Details sent to multiple user$")
    public void iOpenTheBroadcastedInfoDetailsSentToMultipleUser() throws Throwable {
        String userMessage = TestData.getValue("user message2");
        broadcastMessagesPage.searchMessage(userMessage).broadcastInfoDetails();
    }

}
