package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Allow2ChannelsForUserSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public Allow2ChannelsForUserSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on the valid combination of channel tooltip$")
    public void iClickOnTheValidCombinationOfChannelTooltip() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().clickValidCombinationToolTip();
    }

    @Then("^Verify the combined channels header and text$")
    public void verifyTheCombinedChannelsHeaderAndText() throws Throwable {
      String header = TestData.getValue("channelCombination header");
      String text = TestData.getValue("channelCombination text");
      institutionsPage.verifyChannelHeaderText(header,text);
    }

    @Then("^I click the close button of channels tooltip modal$")
    public void iClickTheCloseButtonOfChannelsTooltipModal() throws Throwable {
       institutionsPage.closeChannelTooltipButton();
    }

    @When("^I enable telegram and OTC channels for a user$")
    public void iEnableTelegramAndOTCChannelsForAUser() throws Throwable {
      helper.getInstitutionsPage().enableValidCombinationOfChannel();
    }

    @When("^I enable Symphony as a channel for user$")
    public void iEnableSymphonyAsAChannelForUser() throws Throwable {
     helper.getInstitutionsPage().enableSymphonyAsChannel();
    }

    @Then("^Verify 'Telegram' and 'Portal' channels get disabled$")
    public void verifyTelegramAndPortalChannelsGetDisabled() throws Throwable {
      institutionsPage.disabledValidChannels();
    }

    @When("^I enable Portal as a channel for Market Maker$")
    public void iEnablePortalAsAChannelForMarketMaker() throws Throwable {
        helper.getInstitutionsPage().enablePortalChannel();
    }

    @Then("^Verify Market Maker get validation Message \"([^\"]*)\"$")
    public void verifyMarketMakerGetValidationMessage(String message) throws Throwable {
        Assert.assertTrue(helper.getInstitutionsPage().valiadteMMOTCMessage(message));
    }


}
