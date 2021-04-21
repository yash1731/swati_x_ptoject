package com.aixtrade.steps;

import com.aixtrade.pages.PlatformControlPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewUsersControlSteps {

    private WorldHelper helper;
    private PlatformControlPage platformControl;
    private Popovers popovers;

    public ViewUsersControlSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select an Users on platform control$")
    public void iSelectAnUsersOnPlatformControl() throws Throwable {
       platformControl = helper.getPlatformControlPage().selectUserLink();
    }

    @When("^I click on 'Apply' button on Users control$")
    public void iClickOnApplyButtonOnUsersControl() throws Throwable {
      popovers = platformControl.clickApplyUsersStateButton().completeAction();
    }

    @Then("^I can see the validation message for fields requirement on Users control$")
    public void iCanSeeTheValidationMessageForFieldsRequirementOnUsersControl() throws Throwable {
        String userRequired = TestData.getValue("user required");
        String stateRequired = TestData.getValue("state required");
        String stateReasonRequired = TestData.getValue("stateChange reason");
       Assert.assertTrue(platformControl.validateUsersErrorMessage(userRequired,stateRequired,stateReasonRequired));
    }

    @When("^I select the state of Users to settlement halted$")
    public void iSelectTheStateOfUsersToSettlementHalted() throws Throwable {
        String institutionTitle = TestData.getValue("select institution");
        String institution1 = TestData.getValue("restrict institution");
        String institution2 = TestData.getValue("restrict institution2");
        String user1 = TestData.getValue("restrict user1");
        String user2 = TestData.getValue("restrict user2");
        platformControl.clickInstitutionForUser(institutionTitle).selectInstitutionToChooseUser(institution1);
        platformControl.clickUsersDropdown().selectState(user1);
        platformControl.clickInstitutionForUser(institution1).selectInstitutionToChooseUser(institution2);
        platformControl.clickUsersDropdown().selectState(user2).clickUsersDropdown();
        platformControl.selectUsersStateDropdown().selectSettlementState();
    }

    @When("^I enter the reason for Users to be settlement halted$")
    public void iEnterTheReasonForUsersToBeSettlementHalted() throws Throwable {
        String  reason = TestData.getValue("users settlement");
        platformControl.enterUsersControlReason(reason);

    }

    @Then("^I can see the notification of 'Users status changed'$")
    public void iCanSeeTheNotificationOfUsersStatusChanged() throws Throwable {
        String message = TestData.getValue("users message");
        Assert.assertTrue(platformControl.validateMessage(message));
    }

    @When("^I select an Users trading halted$")
    public void iSelectAnUsersTradingHalted() throws Throwable {
        String institutionTitle = TestData.getValue("select institution");
        String institution1 = TestData.getValue("restrict institution");
        String user1 = TestData.getValue("restrict user1");
        platformControl.clickInstitutionForUser(institutionTitle).selectInstitutionToChooseUser(institution1);
        platformControl.clickUsersDropdown().selectState(user1).clickUsersDropdown();
    }

    @When("^I select the state of Users to trading halted$")
    public void iSelectTheStateOfUsersToTradingHalted() throws Throwable {
        platformControl.selectUsersStateDropdown().selectTradeHalt();
    }

    @When("^I enter the reason for Users to be trading halted$")
    public void iEnterTheReasonForUsersToBeTradingHalted() throws Throwable {
        String  reason = TestData.getValue("users trading");
        platformControl.enterUsersControlReason(reason);
    }

    @When("^I select an Users to suspend$")
    public void iSelectAnUsersToSuspend() throws Throwable {
        String institutionTitle = TestData.getValue("select institution");
        String institution2 = TestData.getValue("restrict institution");
        String user2 = TestData.getValue("restrict user1");
        platformControl.clickInstitutionForUser(institutionTitle).selectInstitutionToChooseUser(institution2);
        platformControl.clickUsersDropdown().selectState(user2).clickUsersDropdown();
    }

    @When("^I select the state of Users to suspend$")
    public void iSelectTheStateOfUsersToSuspend() throws Throwable {
        platformControl.selectUsersStateDropdown().selectSuspended();
    }

    @When("^I enter the reason for Users to be suspended$")
    public void iEnterTheReasonForUsersToBeSuspended() throws Throwable {
        String  reason = TestData.getValue("users suspended");
        platformControl.enterUsersControlReason(reason);
    }

    @When("^I click on the link of Users suspended from the chart$")
    public void iClickOnTheLinkOfUsersSuspendedFromTheChart() throws Throwable {
      platformControl.clickUsersSuspendedLink();
    }

    @When("^I click on 'Change State' button on Users control$")
    public void iClickOnChangeStateButtonOnUsersControl() throws Throwable {
     platformControl.changeState();
    }

    @Then("^I change the state from suspended to continuous trading of Users$")
    public void iChangeTheStateFromSuspendedToContinuousTradingOfUsers() throws Throwable {
        platformControl.selectUsersStateDropdown().selectContinueTrade();
    }

    @Then("^I enter the reason for Users to be continuous trading$")
    public void iEnterTheReasonForUsersToBeContinuousTrading() throws Throwable {
        String  reason = TestData.getValue("users continuous");
        platformControl.enterUsersControlReason(reason);
    }




}
