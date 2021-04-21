package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EmptyClearingPartnersDetailsSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public EmptyClearingPartnersDetailsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I clear SeedCX Participant id$")
    public void iClearSeedCXParticipantId() throws Throwable {
       institutionsPage = helper.getInstitutionsPage().clearClearingPartnerSeedCXId();
    }

    @Then("^I verify instruments tab is not displayed$")
    public void iVerifyInstrumentsTabIsNotDisplayed() throws Throwable {
       Assert.assertTrue(institutionsPage.instrumentTabDisplay());
    }

    @When("^I enter SeedCX Participant id details$")
    public void iEnterSeedCXParticipantIdDetails() throws Throwable {
        String id = TestData.getValue("clearingPartner seedcx");
        institutionsPage = helper.getInstitutionsPage().enterClearingPartnerSeedCXId(id);
    }

    @Then("^I see the acknowledgement message for duplicate clearing Partners$")
    public void iSeeTheAcknowledgementMessageForDuplicateClearingPartners() throws Throwable {
        String message = TestData.getValue("duplicate clearingPartner");
        Assert.assertTrue(institutionsPage.validateInstrumentAssociatedMessage(message));
    }


    @When("^I click on Clearing Partners tab to clear seedcx id$")
    public void iClickOnClearingPartnersTabToClearSeedcxId() throws Throwable {
        institutionsPage.clickClearingPartnersTab();
    }

    @Then("^I see the validation message where clearing partner is associated for an instrument is still enabled$")
    public void iSeeTheValidationMessageWhereClearingPartnerIsAssociatedForAnInstrumentIsStillEnabled() throws Throwable {
      String message = TestData.getValue("disable clearingPartner");
      Assert.assertTrue(institutionsPage.validateInstrumentAssociatedMessage(message));
    }
}
