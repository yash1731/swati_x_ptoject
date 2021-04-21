package com.aixtrade.steps;

import com.aixtrade.pages.AlertsAndPopovers;
import com.aixtrade.pages.UsersPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AllowPortalChannelForUserOfAnInstitutionSteps {

    private WorldHelper helper;
    private UsersPage usersPage;
    private AlertsAndPopovers alertsAndPopovers;

    public AllowPortalChannelForUserOfAnInstitutionSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I edit user and mark user as a Trader to allow user for two channels$")
    public void iEditUserAndMarkUserAsATraderToAllowUserForTwoChannels() throws Throwable {
        String user = TestData.getValue("tester2 email");
       usersPage = helper.getUsersPage().markUserAsApersonnel(user).editUserAsTraderToUseOTCScreen();
    }

    @When("^I click on the valid combination of channel tooltip$")
    public void iClickOnTheValidCombinationOfChannelTooltip() throws Throwable {
       helper.getUsersPage().clickChannelsTooltip();
    }

    @Then("^Verify the combined channels header and text$")
    public void verifyTheCombinedChannelsHeaderAndText() throws Throwable {
      String header = TestData.getValue("channel header");
      String text = TestData.getValue("channel text");
        Assert.assertTrue(usersPage.validateChannelCombination(header,text));
    }

    @Then("^I click the close button of channels tooltip modal$")
    public void iClickTheCloseButtonOfChannelsTooltipModal() throws Throwable {
       usersPage.closeChannelComboModal();
    }

    @When("^I enable Symphony as a channel for user$")
    public void iEnableSymphonyAsAChannelForUser() throws Throwable {
      usersPage.notValidComboChannels();
    }

    @Then("^Verify 'Telegram' and 'Portal' channels get disabled$")
    public void verifyTelegramAndPortalChannelsGetDisabled() throws Throwable {
         usersPage.channelTelegramPortalNotEnabled();
    }

    @When("^I click on 'Update User' button$")
    public void iClickOnUpdateUserButton() throws Throwable {
       usersPage.clickUpdatingUser();
    }


    //Market Maker Validation for OTC Screen

    @When("^I edit user and mark user as a Market Maker to not allow Portal channel$")
    public void iEditUserAndMarkUserAsAMarketMakerToNotAllowPortalChannel() throws Throwable {
        String user = TestData.getValue("tester2 email");
        usersPage = helper.getUsersPage().markUserAsApersonnel(user).editUserAsMMToUseOTCScreen();

    }

    @Then("^Verify Market Maker get validation Message \"([^\"]*)\"$")
    public void verifyMarketMakerGetValidationMessage(String message) throws Throwable {
        Assert.assertTrue(usersPage.validateOTCChannelForMM(message));
    }

}
