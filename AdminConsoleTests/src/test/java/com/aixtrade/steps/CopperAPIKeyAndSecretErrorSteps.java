package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopperAPIKeyAndSecretErrorSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public CopperAPIKeyAndSecretErrorSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @When("^I click on the 'Clearing Partners Mapping' button$")
    public void iClickOnTheClearingPartnersMappingButton() throws Throwable {
      institutionsPage = helper.getInstitutionsPage().clickClearingPartnersButton();
    }

    @Then("^Clearing Partners tab is displayed$")
    public void clearingPartnersTabIsDisplayed() throws Throwable {
       String header = TestData.getValue("clearingPartners header");
       institutionsPage.clearingPartnersTab(header);
    }

    @When("^I enter the Copper api key and api secret to specified institution$")
    public void iEnterTheCopperApiKeyAndApiSecretToSpecifiedInstitution() throws Throwable {
        String key = TestData.getValue("copper key");
        String secret = TestData.getValue("copper secret");
        institutionsPage.enterClearingPartnersKeyAndSecret(key,secret);
    }

    @When("^I save the Copper api key and secret$")
    public void iSaveTheCopperApiKeyAndSecret() throws Throwable {
      institutionsPage.clickSaveXlearingPartnersButton();
    }

    @Then("^Verify the copper api validation message is displayed$")
    public void verifyTheCopperApiValidationMessageIsDisplayed() throws Throwable {
        String error = TestData.getValue("copper error");
      institutionsPage.validateCopperError(error);
    }


}
