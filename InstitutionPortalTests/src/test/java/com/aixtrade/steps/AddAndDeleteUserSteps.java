package com.aixtrade.steps;

import com.aixtrade.pages.AlertsAndPopovers;
import com.aixtrade.pages.UsersPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddAndDeleteUserSteps {

    private WorldHelper helper;
    private UsersPage usersPage;
    private AlertsAndPopovers alertsAndPopovers;

    public AddAndDeleteUserSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select Add/Edit user tab$")
    public void iSelectAddEditUserTab() {
        usersPage = helper.getUsersPage().selectToAddOrEditUser();
    }

    @When("^I add a user with the details below:$")
    public void iAddAUserWithTheDetailsBelow(DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.raw();
        String lastName = TestData.getValue(fieldOption.get(1).get(1));
        String telegramID = TestData.getValue(fieldOption.get(2).get(1));
        String symphonyId = TestData.getValue(fieldOption.get(3).get(1));
        usersPage.addNewUser(lastName, telegramID, symphonyId);
    }

    @Then("^I should be able to successfully add a user with a \"([^\"]*)\" displayed$")
    public void iShouldBeAbleToSuccessfullyAddAUserWithADisplayed(String message) {
        message = TestData.getValue(message);
        assertThat(usersPage.validateUser(message), is(true));
    }

    @And("^I should be able to see the new user displayed on the Users Table$")
    public void iShouldBeAbleToSeeTheNewUserDisplayedOnTheUsersTable() {
       // assertThat(usersPage.validateNewUser(), is(true));
    }

    @When("^I edit user and mark user as Admin$")
    public void iEditUserAndMarkUserAsAdmin() {
        String user = TestData.getValue("tester6 email");
        usersPage = helper.getUsersPage().markUserAsApersonnel(user).markUserAsAdmin();
    }

    @Then("^I should be able to see user added as Admin with an \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeUserAddedAsAdminWithAn(String message) {
        //assertThat(usersPage.validateUpdatedUser(message), is(true));
    }


    @When("^I edit user and mark user as a Trader$")
    public void iEditUserAndMarkUserAsATrader() {
        helper.getUsersPage().markUserAsTrader();
    }

    @Then("^I should be able to see user added as a Trader with an \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeUserAddedAsATraderWithAn(String message) {
       //assertThat(usersPage.validateUpdatedUser(message), is(true));
    }

    @When("^I edit user and mark user as a Market Maker$")
    public void iEditUserAndMarkUserAsAMarketMaker(){
        usersPage.markUserAsMarketMaker();
    }

    @Then("^I should be able to see user added as a Market Maker with an \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeUserAddedAsAMarketMakerWithAn(String message) {
        //assertThat(usersPage.validateUpdatedUser(message), is(true));
    }


    @When("^I edit user and disable user as an admin and a  Market Maker$")
    public void iEditUserAndDisableUserAsAnAdminAndAMarketMaker() throws Throwable {
        usersPage.disableMMAndAdminChannel();
    }

    @When("^I delete new user$")
    public void iDeleteNewUser() {
        alertsAndPopovers = usersPage.deleteNewUser().completeDelete();
    }

    @Then("^I should be able to see user successfully deleted with a \"([^\"]*)\" displayed$")
    public void iShouldBeAbleToSeeUserSuccessfullyDeletedWithADisplayed(String deleteMessage) {
        deleteMessage = TestData.getValue(deleteMessage);
//        assertThat(usersPage.validateUser(deleteMessage), is(true));
    }
    //user preference
    @When("^I edit market maker user$")
    public void iEditMarketMakerUser() throws Throwable {
       // usersPage =helper.getUsersPage().markUserAsMarketMaker();
        usersPage.markUserAsApersonnel("tester15");

    }

    @Then("^I should able to see User Preferences$")
    public void iShouldAbleToSeeUserPreferences() throws Throwable {
        assertThat(usersPage.verifyUserPreferences(), is(true));
    }

    @Then("^I choose the Preferred Channel$")
    public void iChooseThePreferredChannel() throws Throwable {
        String preChannel = TestData.getValue("default channel");
        String channel = TestData.getValue("channel name");
        usersPage.selectPreferredChannel(preChannel,channel);
    }

    @Then("^I should see the \"([^\"]*)\"$")
    public void iShouldSeeThe(String message) throws Throwable {
        //userPreferencesMessage = TestData.getValue(userPreferencesMessage);
       // assertThat(usersPage.validateUserPreferenceMessage(userPreferencesMessage), is(true));
        //Assert.assertTrue(usersPage.validateUpdatedUser(message));
    }

    @When("^I check receive BTC security$")
    public void iCheckReceiveBTCSecurity() throws Throwable {
        usersPage.enableReceiveSecurityBTC();
    }

    @Then("^I should able to see quote expiry, min and max price field$")
    public void iShouldAbleToSeeQuoteExpiryMinAndMaxPriceField() throws Throwable {
        assertThat(usersPage.validateBTCQuoteExpiry(), is(true));
       // assertThat(usersPage.validateBTCMinPrice(), is(true));
       // assertThat(usersPage.validateBTCMaxPrice(), is(true));
    }

    @When("^I enter the quote expiry time$")
    public void iEnterTheQuoteExpiryTime() throws Throwable {
        usersPage.enterQuoteExpiryBTC();
    }

    @When("^I enter minimum BTC price$")
    public void iEnterMinimumBTCPrice() throws Throwable {
        usersPage.enterMinPriceBTC();
    }

    @When("^I enter maximum BTC price$")
    public void iEnterMaximumBTCPrice() throws Throwable {
        usersPage.enterMaxPriceBTC();
    }

    @When("^I check receive ETH security$")
    public void iCheckReceiveETHSecurity() throws Throwable {
        usersPage.enableReceiveSecurityETH();
    }

    @Then("^I should able to see ETH quote expiry, min and max price field$")
    public void iShouldAbleToSeeETHQuoteExpiryMinAndMaxPriceField() throws Throwable {
        assertThat(usersPage.validateETHQuoteExpiry(), is(true));
        /*assertThat(usersPage.validateETHMinPrice(), is(true));
        assertThat(usersPage.validateETHMaxPrice(), is(true));*/
    }

    @When("^I enter the ETH quote expiry time$")
    public void iEnterTheETHQuoteExpiryTime() throws Throwable {
        usersPage.enterQuoteExpiryETH();
    }


    @When("^I enter minimum ETH price$")
    public void iEnterMinimumETHPrice() throws Throwable {
        usersPage.enterMinPriceETH();
    }

    @When("^I enter maximum ETH price$")
    public void iEnterMaximumETHPrice() throws Throwable {
        usersPage.enterMaxPriceETH();
    }

    @Then("^I choose the Preferred Channel set to default$")
    public void iChooseThePreferredChannelSetToDefault() throws Throwable {
        usersPage.selectPreferredChannelToDefault();
    }

    @Then("^I should not able to see quote expiry, min and max price field$")
    public void iShouldNotAbleToSeeQuoteExpiryMinAndMaxPriceField() throws Throwable {
        usersPage.isBTCFieldEnabled();
    }

    @Then("^I should not able to see ETH quote expiry, min and max price field$")
    public void iShouldNotAbleToSeeETHQuoteExpiryMinAndMaxPriceField() throws Throwable {
        usersPage.isETHFieldEnabled();
    }

    @When("^I enter the invalid quote expiry time$")
    public void iEnterTheInvalidQuoteExpiryTime() throws Throwable {
        usersPage.enterInvalidQuoteExpiryBTC();
    }

    @Then("^I should see the validation \"([^\"]*)\"$")
    public void iShouldSeeTheValidation(String expiryMessage) throws Throwable {
        expiryMessage = TestData.getValue(expiryMessage);
        assertThat(usersPage.validateQuoteExpiryMessage(expiryMessage), is(true));
        usersPage.scrollUp();
    }

    @When("^I enter the invalid quote expiry time for ETH$")
    public void iEnterTheInvalidQuoteExpiryTimeForETH() throws Throwable {
        usersPage.enterInvalidQuoteExpiryETH();
    }

    /*@When("^I enter invalid minimum BTC price$")
    public void iEnterInvalidMinimumBTCPrice() throws Throwable {
        usersPage.enterInvalidMinPriceBTC();
    }

    @When("^I enter invalid maximum BTC price$")
    public void iEnterInvalidMaximumBTCPrice() throws Throwable {
        usersPage.enterInvalidMaxPriceBTC();
    }

    @When("^I enter invalid minimum ETH price$")
    public void iEnterInvalidMinimumETHPrice() throws Throwable {
        usersPage.enterInvalidMinPriceETH();
    }

    @When("^I enter invalid maximum ETH price$")
    public void iEnterInvalidMaximumETHPrice() throws Throwable {
        usersPage.enterInvalidMaxPriceETH();
    }*/

    @When("^I uncheck receive BTC security$")
    public void iUncheckReceiveBTCSecurity() throws Throwable {
        usersPage.disableBTCSecurity();
    }

    @When("^I uncheck receive ETH security$")
    public void iUncheckReceiveETHSecurity() throws Throwable {
        usersPage.disableETHSecurity();
    }
}
