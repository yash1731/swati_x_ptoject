package com.aixtrade.steps;

import com.aixtrade.pages.PlatformControlPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewInstitutionsControlSteps {

    private WorldHelper helper;
    private PlatformControlPage platformControl;
    private Popovers popovers;

    public ViewInstitutionsControlSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select an institutions on platform control$")
    public void iSelectAnInstitutionsOnPlatformControl() throws Throwable {
         platformControl = helper.getPlatformControlPage().selectInstitutionsLink();
    }

    @When("^I click on 'Apply' button on institution control$")
    public void iClickOnApplyButtonOnInstitutionControl() throws Throwable {
        popovers = helper.getPlatformControlPage().clickApplyInstitutionStateButton().completeAction();
    }

    @When("^I select the state of institutions to settlement halted$")
    public void iSelectTheStateOfInstitutionsToSettlementHalted() throws Throwable {
        String institutionText = TestData.getValue("select institution");
        String selectedInstitution = TestData.getValue("restrict institution");
        String state = TestData.getValue("settlement state");
       platformControl.clickInstitutions(institutionText).selectState(selectedInstitution);
       platformControl.clickInstitutionStateDropdown().selectState(state);
    }

    @When("^I enter the reason for institutions to be settlement halted$")
    public void iEnterTheReasonForInstitutionsToBeSettlementHalted() throws Throwable {
      String reason = TestData.getValue("institution settlement");
      platformControl.enterInstitutionReason(reason);
    }

    @Then("^I can see the notification of 'institutions status changed'$")
    public void iCanSeeTheNotificationOfInstitutionsStatusChanged() throws Throwable {
        String message = TestData.getValue("institution message");
        Assert.assertTrue(platformControl.validateMessage(message));
    }

    @When("^I select an institutions trading halted$")
    public void iSelectAnInstitutionsTradingHalted() throws Throwable {
        String institutionText = TestData.getValue("select institution");
        String selectedInstitution = TestData.getValue("restrict institution");
        platformControl.clickInstitutions(institutionText).selectState(selectedInstitution);

    }

    @When("^I select the state of institutions to trading halted$")
    public void iSelectTheStateOfInstitutionsToTradingHalted() throws Throwable {
        platformControl.clickInstitutionStateDropdown().selectTradeHalt();
    }

    @When("^I enter the reason for institutions to be trading halted$")
    public void iEnterTheReasonForInstitutionsToBeTradingHalted() throws Throwable {
        String reason = TestData.getValue("institution trading");
        platformControl.enterInstitutionReason(reason);
    }

    @When("^I select an institutions to suspend$")
    public void iSelectAnInstitutionsToSuspend() throws Throwable {
        String institutionText = TestData.getValue("select institution");
        String selectedInstitution = TestData.getValue("restrict institution");
        platformControl.clickInstitutions(institutionText).selectState(selectedInstitution);
    }

    @When("^I select the state of institutions to suspend$")
    public void iSelectTheStateOfInstitutionsToSuspend() throws Throwable {
        platformControl.clickInstitutionStateDropdown().selectSuspended();
    }

    @When("^I enter the reason for institutions to be suspended$")
    public void iEnterTheReasonForInstitutionsToBeSuspended() throws Throwable {
        String reason = TestData.getValue("institution suspended");
        platformControl.enterInstitutionReason(reason);
    }

    @When("^I click on the link of institutions suspended from the chart$")
    public void iClickOnTheLinkOfInstitutionsSuspendedFromTheChart() throws Throwable {
      platformControl.clickInstitutionSuspendedLink();
    }

    @Then("^I change the state from suspended to continuous trading of institutions$")
    public void iChangeTheStateFromSuspendedToContinuousTradingOfInstitutions() throws Throwable {
        platformControl.clickInstitutionStateDropdown().selectContinueTrade();
    }

    @When("^I select an institutions to Continuous trading$")
    public void iSelectAnInstitutionsToContinuousTrading() throws Throwable {
        String institutionText = TestData.getValue("select institution");
        String selectedInstitution = TestData.getValue("restrict institution");
        platformControl.clickInstitutions(institutionText).selectState(selectedInstitution);

    }

    @Then("^I enter the reason for institutions to be continuous trading$")
    public void iEnterTheReasonForInstitutionsToBeContinuousTrading() throws Throwable {
        String reason = TestData.getValue("institution continuous");
        platformControl.enterInstitutionReason(reason);
    }

    @Then("^I can see the validation message for fields requirement on Institutions form$")
    public void iCanSeeTheValidationMessageForFieldsRequirementOnInstitutionsForm() throws Throwable {
        String institutionRequired = TestData.getValue("institution required");
        String stateRequired = TestData.getValue("state required");
        String stateReasonRequired = TestData.getValue("stateChange reason");
        Assert.assertTrue(platformControl.validateInstitutionErrorMessage(institutionRequired,stateRequired,stateReasonRequired));
       // platformControl.selectInstitutionsLink();

    }

    @When("^I click on 'Change State' button of Suspended Institution$")
    public void iClickOnChangeStateButtonOfSuspendedInstitution() throws Throwable {
      // platformControl.clickChangeInstitutionState();
        platformControl.changeState();
    }


}
