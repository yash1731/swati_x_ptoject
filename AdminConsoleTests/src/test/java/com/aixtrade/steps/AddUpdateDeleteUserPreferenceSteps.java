package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddUpdateDeleteUserPreferenceSteps {
    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public AddUpdateDeleteUserPreferenceSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I set the preferred channel of the user$")
    public void iSetThePreferredChannelOfTheUser() throws Throwable {
//        String preChannel = TestData.getValue("default channel");
//        String channel = TestData.getValue("channel name");
       //institutionsPage = helper.getInstitutionsPage().setPreferedChannel(preChannel,channel);
        institutionsPage = helper.getInstitutionsPage().setPreferredChannelForUser();
    }

    @When("^I set the security for the user$")
    public void iSetTheSecurityForTheUser() throws Throwable {
        institutionsPage.receiveSecurity();
    }

    @Then("^I see the quote expiry, min and max volume field is displayed$")
    public void iSeeTheQuoteExpiryMinAndMaxVolumeFieldIsDisplayed() throws Throwable {
        assertThat(institutionsPage.validateQuoteExpiry(), is(true));
        assertThat(institutionsPage.validateMaxVolume(), is(true));
        assertThat(institutionsPage.validateMinVolume(), is(true));
    }

    @When("^I disable the security for the user$")
    public void iDisableTheSecurityForTheUser() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().receiveSecurity();
    }

    @When("^I set the preferred channel of the user to default$")
    public void iSetThePreferredChannelOfTheUserToDefault() throws Throwable {
//        String preChannel = TestData.getValue("channel name");
//        String channel = TestData.getValue("default channel");
//        institutionsPage = helper.getInstitutionsPage().setPreferedChannel(preChannel,channel);
        institutionsPage = helper.getInstitutionsPage().setPreferredChannelForUser();

    }

    @Then("^I see the quote expiry, min and max volume field is not displayed$")
    public void iSeeTheQuoteExpiryMinAndMaxVolumeFieldIsNotDisplayed() throws Throwable {
        institutionsPage.isSecurityDisabled();
    }


}
