package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EnableChannelsForInstitutionSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public EnableChannelsForInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @When("^I search for \"([^\"]*)\" in Institutions to enable Channels$")
    public void iSearchForInInstitutionsToEnableChannels(String institution) throws Throwable {
        institutionsPage = helper.getInstitutionsPage().searchAnInstituton(institution);
    }


    @Then("^I click on Enable channel to select all channels$")
    public void iClickOnEnableChannelToSelectAllChannels() throws Throwable {
        String selectAllChannels = TestData.getValue("selectAll events");
       institutionsPage = helper.getInstitutionsPage().clickToEnableAllChannels(selectAllChannels);
    }

    @Then("^I click on Enable channel to deselect all channels$")
    public void iClickOnEnableChannelToDeselectAllChannels() throws Throwable {
        String deselectAllChannels = TestData.getValue("deselectAll events");
        institutionsPage = helper.getInstitutionsPage().clickToDisableAllChannels(deselectAllChannels);
    }

    @Then("^I click on Enable channel to select Telegram and FIX$")
    public void iClickOnEnableChannelToSelectTelegramAndFIX() throws Throwable {
        String telegram = TestData.getValue("default channel");
        String fix = TestData.getValue("channel name2");
        institutionsPage = helper.getInstitutionsPage().clickToEnableTelegramFIX(telegram,fix);

    }

    @Then("^Verify TelegramId and FixId fields are enabled$")
    public void verifyTelegramIdAndFixIdFieldsAreEnabled() throws Throwable {
        Assert.assertTrue(institutionsPage.verifyTelegramFixFieldsEnabled());
    }

    @Given("^I go back to Institutions page$")
    public void iGoBackToInstitutionsPage() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().goBackToInstitutionPage();
    }

    @Then("^I click on Enable channel to deselect Telegram and Fix channels$")
    public void iClickOnEnableChannelToDeselectTelegramAndFixChannels() throws Throwable {
        String deselectAllChannels = TestData.getValue("deselectAll events");
        institutionsPage = helper.getInstitutionsPage().clickToDisableTelegranFixChannels(deselectAllChannels);
    }


}
