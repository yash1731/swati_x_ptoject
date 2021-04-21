package com.aixtrade.steps;

import com.aixtrade.pages.PlatformControlPage;
import com.aixtrade.pages.Popovers;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewPlatformControlSteps {

    private WorldHelper helper;
    private PlatformControlPage platformControl;
    private Popovers popovers;

    public ViewPlatformControlSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on Platform Control page$")
    public void iAmOnPlatformControlPage() throws Throwable {
         String username = TestData.getValue("admin email");
         String password = TestData.getValue("admin password");
         platformControl = helper.getBasePage().loginWith(username,password).goToPlatformControlPage();
    }

    @Then("^I can see the validation message for fields requirement$")
    public void iCanSeeTheValidationMessageForFieldsRequirement() throws Throwable {
        String state = TestData.getValue("state required");
        String stateReason = TestData.getValue("stateChange reason");
        Assert.assertTrue(platformControl.validateStateErrorMessage(state));
        Assert.assertTrue(platformControl.validateStateReasonErrorMessage(stateReason));
    }

    @When("^I select the platform suspended option$")
    public void iSelectThePlatformSuspendedOption() throws Throwable {
        String selectState = TestData.getValue("select state");
        String stateSuspended = TestData.getValue("suspended state");
        platformControl.clickState(selectState).selectState(stateSuspended);
    }

    @When("^I enter the platform suspended reason$")
    public void iEnterThePlatformSuspendedReason() throws Throwable {
        String enterReason = TestData.getValue("platform suspended");
        platformControl.enterPlatoformStateReason(enterReason);
    }

    @When("^I click on 'Apply' button$")
    public void iClickOnApplyButton() throws Throwable {
         popovers = helper.getPlatformControlPage().clickApplyButton().completeAction();
    }

    @Then("^I can see the notification of 'Platform status changed'$")
    public void iCanSeeTheNotificationOfPlatformStatusChanged() throws Throwable {
         String message = TestData.getValue("platform message");
         Assert.assertTrue(platformControl.validateMessage(message));
    }

    @Then("^I can see 'Y' across the platform suspended$")
    public void iCanSeeYAcrossThePlatformSuspended() throws Throwable {
        Assert.assertTrue(platformControl.validateSuspendedChart());
    }

    @Then("^I can see in control table all the fields are greyed out$")
    public void iCanSeeInControlTableAllTheFieldsAreGreyedOut() throws Throwable {
        Assert.assertTrue(platformControl.instrumentSuspended());
        Assert.assertTrue(platformControl.institutionsSuspended());
        Assert.assertTrue(platformControl.usersSuspended());
    }

    @When("^I select the platform halt for trading option$")
    public void iSelectThePlatformHaltForTradingOption() throws Throwable {
        String selectState = TestData.getValue("select state");
        String stateTradeHalted = TestData.getValue("trading state");
        platformControl.clickState(selectState).selectState(stateTradeHalted);
    }

    @When("^I enter the platform trading halted reason$")
    public void iEnterThePlatformTradingHaltedReason() throws Throwable {
        String enterReason = TestData.getValue("platform trading");
        platformControl.enterPlatoformStateReason(enterReason);
    }

    @Then("^I can see 'Y' across the platform halted for trading$")
    public void iCanSeeYAcrossThePlatformHaltedForTrading() throws Throwable {
        Assert.assertTrue(platformControl.validateTradingHaltChart());
    }

    @Then("^I can see in control table all the fields are greyed out except suspended$")
    public void iCanSeeInControlTableAllTheFieldsAreGreyedOutExceptSuspended() throws Throwable {
        Assert.assertTrue(platformControl.instrumentTradingHalt());
        Assert.assertTrue(platformControl.institutionsTradingHalt());
        Assert.assertTrue(platformControl.usersTradingHalt());
    }

    @When("^I select the platform halt for settlement option$")
    public void iSelectThePlatformHaltForSettlementOption() throws Throwable {
        String selectState = TestData.getValue("select state");
        String stateSettlementHalted = TestData.getValue("settlement state");
        platformControl.clickState(selectState).selectState(stateSettlementHalted);
    }

    @When("^I enter the platform settlement halted reason$")
    public void iEnterThePlatformSettlementHaltedReason() throws Throwable {
        String enterReason = TestData.getValue("platform settlement");
        platformControl.enterPlatoformStateReason(enterReason);
    }

    @Then("^I can see 'Y' across the platform halted for settlement$")
    public void iCanSeeYAcrossThePlatformHaltedForSettlement() throws Throwable {
        Assert.assertTrue(platformControl.validateSettlementHaltChart());
    }

    @Then("^I can see in control table all the fields are greyed out except trading halted and suspended$")
    public void iCanSeeInControlTableAllTheFieldsAreGreyedOutExceptTradingHaltedAndSuspended() throws Throwable {
        Assert.assertTrue(platformControl.instrumentSettlementHalt());
        Assert.assertTrue(platformControl.institutionsSettlementHalt());
        Assert.assertTrue(platformControl.usersSettlementHalt());
    }

    @When("^I select the platform continuous for trading option$")
    public void iSelectThePlatformContinuousForTradingOption() throws Throwable {
        String selectState = TestData.getValue("select state");
        String stateContinueTrade = TestData.getValue("continuous state");
        platformControl.clickState(selectState).selectState(stateContinueTrade);
    }

    @When("^I enter the platform trading continuously reason$")
    public void iEnterThePlatformTradingContinuouslyReason() throws Throwable {
        String enterReason = TestData.getValue("platform continuous");
        platformControl.enterPlatoformStateReason(enterReason);
    }

    @Then("^I can see 'Y' across the platform continuous for trading$")
    public void iCanSeeYAcrossThePlatformContinuousForTrading() throws Throwable {
        Assert.assertTrue(platformControl.validateContinueTradingChart());
    }

    @Then("^I can see in control table all the fields are enabled$")
    public void iCanSeeInControlTableAllTheFieldsAreEnabled() throws Throwable {
        Assert.assertTrue(platformControl.instrumentContinueTrading());
        Assert.assertTrue(platformControl.institutionsContinueTrading());
        Assert.assertTrue(platformControl.usersContinueTrading());
    }



}
