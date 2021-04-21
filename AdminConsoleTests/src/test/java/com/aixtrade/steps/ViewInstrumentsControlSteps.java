package com.aixtrade.steps;

import com.aixtrade.pages.PlatformControlPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewInstrumentsControlSteps {

    private WorldHelper helper;
    private PlatformControlPage platformControl;
    private Popovers popovers;

    public ViewInstrumentsControlSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on 'Apply' button on Instruments$")
    public void iClickOnApplyButtonOnInstruments() throws Throwable {
        popovers = helper.getPlatformControlPage().clickApplyInstrumentStateButton().completeAction();
    }

    @Then("^I can see the validation message for fields requirement in Instruments form$")
    public void iCanSeeTheValidationMessageForFieldsRequirementInInstrumentsForm() throws Throwable {
       String instrumentRequired = TestData.getValue("instrument required");
       String stateRequired = TestData.getValue("state required");
       String stateReasonRequired = TestData.getValue("stateChange reason");
        Assert.assertTrue(platformControl.validateInstrumentErrorMessage(instrumentRequired,stateRequired,stateReasonRequired));
        platformControl.selectInstrumentsLink();

    }

    @When("^I select an instrument on platform control$")
    public void iSelectAnInstrumentOnPlatformControl() throws Throwable {
        platformControl = helper.getPlatformControlPage().selectInstrumentsLink();
    }

    @When("^I select the state of instrument to settlement halted$")
    public void iSelectTheStateOfInstrumentToSettlementHalted() throws Throwable {
        String instrumentTitle = TestData.getValue("instrument title");
        String instrument = TestData.getValue("select instrument");
        String instrumentState = TestData.getValue("settlement state");
        platformControl.clickInstrumentDropdown(instrumentTitle).selectState(instrument);
        platformControl.clickInstrumentStateDropdown().selectState(instrumentState);
    }

    @When("^I enter the reason for instrument to be settlement halted$")
    public void iEnterTheReasonForInstrumentToBeSettlementHalted() throws Throwable {
        String reason = TestData.getValue("instrument settlement");
        platformControl.enterInstrumentStateReason(reason);
    }

    @Then("^I can see the notification of 'INSTRUMENT status changed'$")
    public void iCanSeeTheNotificationOfINSTRUMENTStatusChanged() throws Throwable {
        String message = TestData.getValue("instrument message");
        Assert.assertTrue(platformControl.validateMessage(message));
    }

    @When("^I select an instrument trading halted$")
    public void iSelectAnInstrumentTradingHalted() throws Throwable {
        String instrumentTitle = TestData.getValue("instrument title");
        String instrument = TestData.getValue("select instrument");
        platformControl.clickInstrumentDropdown(instrumentTitle).selectState(instrument);
    }

    @When("^I select the state of instrument to trading halted$")
    public void iSelectTheStateOfInstrumentToTradingHalted() throws Throwable {
        platformControl.clickInstrumentStateDropdown().selectTradeHalt();
    }

    @When("^I enter the reason for instrument to be trading halted$")
    public void iEnterTheReasonForInstrumentToBeTradingHalted() throws Throwable {
        String reason = TestData.getValue("instrument trading");
        platformControl.enterInstrumentStateReason(reason);
    }

    @When("^I select an instrument to suspend$")
    public void iSelectAnInstrumentToSuspend() throws Throwable {
        String instrumentTitle = TestData.getValue("instrument title");
        String instrument = TestData.getValue("select instrument");
        platformControl.clickInstrumentDropdown(instrumentTitle).selectState(instrument);
    }

    @When("^I select the state of instrument to suspend$")
    public void iSelectTheStateOfInstrumentToSuspend() throws Throwable {
        platformControl.clickInstrumentStateDropdown().selectSuspended();
    }

    @When("^I enter the reason for instrument to be suspended$")
    public void iEnterTheReasonForInstrumentToBeSuspended() throws Throwable {
        String reason = TestData.getValue("instrument suspended");
        platformControl.enterInstrumentStateReason(reason);
    }

    @When("^I click on the link of instrument suspended from the chart$")
    public void iClickOnTheLinkOfInstrumentSuspendedFromTheChart() throws Throwable {
        platformControl.clickSuspendedLink();
    }

    @When("^I click on 'Change State' button$")
    public void iClickOnChangeStateButton() throws Throwable {
        platformControl.changeState();
    }

    @Then("^I change the state from suspended to continuous trading of instrument$")
    public void iChangeTheStateFromSuspendedToContinuousTradingOfInstrument() throws Throwable {
        platformControl.clickInstrumentStateDropdown().selectContinueTrade();
    }

    @Then("^I enter the reason for instrument to be continuous trading$")
    public void iEnterTheReasonForInstrumentToBeContinuousTrading() throws Throwable {
        String reason = TestData.getValue("instrument continuous");
        platformControl.enterInstrumentStateReason(reason);
    }


}
