package com.aixtrade.steps;

import com.aixtrade.pages.BroadcastMessagesPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BroadCastMessageToAnInstitutionSteps {

    private WorldHelper helper;
    private BroadcastMessagesPage broadcastMessagesPage;
    private Popovers popovers;

    public BroadCastMessageToAnInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Broadcast Messages page$")
    public void iAmOnTheBroadcastMessagesPage() throws Throwable {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        broadcastMessagesPage = helper.getBasePage().loginWith(username, password).goToBroadcastMessagePage();
    }

    @When("^I select a institution to Broadcast Message$")
    public void iSelectAInstitutionToBroadcastMessage() throws Throwable {
        String selectInstitution = TestData.getValue("select institution");
        String broadcastInstitution = TestData.getValue("broadcast institution");
        broadcastMessagesPage.clickInstitution(selectInstitution).selectAnInstitution(broadcastInstitution);
    }

    @When("^I enter the announcements to broadcast$")
    public void iEnterTheAnnouncementsToBroadcast() throws Throwable {
        String institutionMessage = TestData.getValue("institution message1");
        broadcastMessagesPage.enterTextToBroadcast(institutionMessage);
    }

    @When("^I send the broadcast message$")
    public void iSendTheBroadcastMessage() throws Throwable {
       broadcastMessagesPage.clickSendMessageButton();
    }

    @Then("^I can verify the broadcasted message in the list$")
    public void iCanVerifyTheBroadcastedMessageInTheList() throws Throwable {
        String broadcastMessage = TestData.getValue("broadcast alert");
        broadcastMessagesPage.validateBroadcastMessage(broadcastMessage);
        broadcastMessagesPage.validateBroadcastMessageHistory();
    }

    @When("^I open the Broadcasted Info Details$")
    public void iOpenTheBroadcastedInfoDetails() throws Throwable {
        String institutionMessage = TestData.getValue("institution message1");
       broadcastMessagesPage.searchMessage(institutionMessage).broadcastInfoDetails();
    }

    @Then("^I can verify an institution$")
    public void iCanVerifyAnInstitution() throws Throwable {
        String broadcastInstitution = TestData.getValue("broadcast institution");
        broadcastMessagesPage.validateSelectedInstitution(broadcastInstitution);
    }


    @When("^I select multiple institutions to Broadcast Message$")
    public void iSelectMultipleInstitutionsToBroadcastMessage() throws Throwable {
        String selectedInstitution = TestData.getValue("broadcast institution");
        String selectInstitution = TestData.getValue("broadcast institution2");
      broadcastMessagesPage.closeInfoDetails().clickInstitution(selectedInstitution).selectAnInstitution(selectInstitution);
    }

    @When("^I enter the announcements to broadcast to multiple Institutions$")
    public void iEnterTheAnnouncementsToBroadcastToMultipleInstitutions() throws Throwable {
        String institutionMessage = TestData.getValue("institution message2");
        broadcastMessagesPage.enterTextToBroadcast(institutionMessage);
    }

    @Then("^I can verify the broadcasted message to multiple Institutions in the list$")
    public void iCanVerifyTheBroadcastedMessageToMultipleInstitutionsInTheList() throws Throwable {
        broadcastMessagesPage.validateBroadcastMessageHistory();
    }

    @Then("^I can verify multiple institutions$")
    public void iCanVerifyMultipleInstitutions() throws Throwable {
        String broadcastInstitution1 = TestData.getValue("broadcast institution");
        String broadcastInstitution2 = TestData.getValue("broadcast institution2");
        broadcastMessagesPage.validateSelectedInstitution(broadcastInstitution1);
        broadcastMessagesPage.validateSelectedInstitution(broadcastInstitution2);
    }

    @When("^I open the Broadcasted Info Details for multiple institution$")
    public void iOpenTheBroadcastedInfoDetailsForMultipleInstitution() throws Throwable {
        String institutionMessage = TestData.getValue("institution message2");
        broadcastMessagesPage.searchMessage(institutionMessage).broadcastInfoDetails();
    }



}
