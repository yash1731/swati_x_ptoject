package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EnableInstrumentsToSeeOnUserPrefSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public EnableInstrumentsToSeeOnUserPrefSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @When("^I click on Instruments tab to enable instruments$")
    public void iClickOnInstrumentsTabToEnableInstruments() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().clickInstrumentsTab();
    }

    @When("^I choose the base currencies to enable instruments$")
    public void iChooseTheBaseCurrenciesToEnableInstruments() throws Throwable {
        String base = TestData.getValue("base currency");
        institutionsPage.chooseBaseCurrencies(base).clickSaveInstrumentsButton();
    }

    @When("^I choose the quote currencies to enable instruments$")
    public void iChooseTheQuoteCurrenciesToEnableInstruments() throws Throwable {
        String quote = TestData.getValue("quote currency");
        institutionsPage.chooseQuoteCurrencies(quote);
    }

    @Then("^I see the instrument in clearing partner per instrument list$")
    public void iSeeTheInstrumentInClearingPartnerPerInstrumentList() throws Throwable {
       institutionsPage.verifyInstrumentsInClearingPartnerList();
    }

    @When("^I enable the security to be with SeedCX Clearing Partner$")
    public void iEnableTheSecurityToBeWithSeedCXClearingPartner() throws Throwable {
        institutionsPage.enableInstrumentsToBeInSeedCX();
    }

    @When("^I click on Save instrument button$")
    public void iClickOnSaveInstrumentButton() throws Throwable {
        institutionsPage.clickSaveInstrumentsButton();
    }

    @When("^I disable the security to be with SeedCX Clearing Partner$")
    public void iDisableTheSecurityToBeWithSeedCXClearingPartner() throws Throwable {
        institutionsPage.disableInstrumentsToBeInSeedCX();
    }

    @Then("^I see the acknowledgement message for enabling instruments$")
    public void iSeeTheAcknowledgementMessageForEnablingInstruments() throws Throwable {
       String message = TestData.getValue("enable instrument");
        Assert.assertTrue(institutionsPage.validateClearingPartnerUpdatedMessage(message));
    }

    @Then("^I see the enabled instrument in the User Preferences list$")
    public void iSeeTheEnabledInstrumentInTheUserPreferencesList() throws Throwable {
         Assert.assertTrue(institutionsPage.validateInstrumentInUserPref());
    }

    @Then("^I should not see instrument in the User Preferences list$")
    public void iShouldNotSeeInstrumentInTheUserPreferencesList() throws Throwable {
        Assert.assertTrue(institutionsPage.validateInstrumentIsNotInUserPref());
    }


}
