package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ViewTradingActivitiesForSingleAndMultipleUsersSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivitiesForSingleAndMultipleUsersSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Trading activity page$")
    public void iAmOnTheTradingActivityPage() throws Throwable {
        String username = TestData.getValue("admin email");
        String password = TestData.getValue("admin password");
        tradingActivityPage = helper.getBasePage().loginWith(username, password).goToTradingActivityPage();
    }

    @When("^I select the date and time to view the trading events$")
    public void iSelectTheDateAndTimeToViewTheTradingEvents() throws Throwable {
        String utteranceEvents = TestData.getValue("utterance event");
        String allEvents = TestData.getValue("selectAll events");
        tradingActivityPage.selectDateTimeAndEvents().selectEvents(utteranceEvents,allEvents);
    }

    @When("^I select the institution to view trading activity shown below:$")
    public void iSelectTheInstitutionToViewTradingActivityShownBelow(DataTable dataTable) throws Throwable {
        List<List<String>> searchDetails = dataTable.raw();
        String selectInstitution = TestData.getValue("select institution");
        String institution1 = TestData.getValue(searchDetails.get(1).get(1));
        //String user1 = TestData.getValue(searchDetails.get(2).get(1));
        //tradingActivityPage = helper.getTradingActivityPage().fillTradingActivitySearchInfo(selectInstitution,institution1, user1);
        tradingActivityPage = helper.getTradingActivityPage().fillTradingActivitySearchInfo(selectInstitution,institution1);

    }

    @Then("^I should able to see the selected user for search$")
    public void iShouldAbleToSeeTheSelectedUserForSearch(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String institution = TestData.getValue(fieldOption.get(1).get(1));
//        String user = TestData.getValue(fieldOption.get(2).get(1));
        Assert.assertTrue(tradingActivityPage.validateSelectedInstitution(institution));
       // Assert.assertTrue(tradingActivityPage.validateSelectedUser(user));
    }

    @When("^I click on serach button$")
    public void iClickOnSerachButton() throws Throwable {
       tradingActivityPage.clickSearchButton();
    }

    @Then("^Verify add more institution error message \"([^\"]*)\"$")
    public void verifyAddMoreInstitutionErrorMessage(String message) throws Throwable {
       Assert.assertTrue(tradingActivityPage.verifyAddMoreInstitutionMessage(message));
    }


    @Then("^I should able to see the list of events performed by the specific user$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheSpecificUser() throws Throwable {
        String selectedUser = TestData.getValue("user1 name");
        //Assert.assertTrue(tradingActivityPage.validateSelectedUserinList());
       // Assert.assertTrue(tradingActivityPage.validatedSelectedUser(selectedUser));
    }

    @When("^I select the second institution to view the trading activity shown below:$")
    public void iSelectTheSecondInstitutionToViewTheTradingActivityShownBelow(DataTable dataTable) throws Throwable {
        List<List<String>> searchDetails = dataTable.raw();
        String selectedInstitution = TestData.getValue("selected institution");
        String institution2 = TestData.getValue(searchDetails.get(1).get(1));
        //String user2 = TestData.getValue(searchDetails.get(2).get(1));
        //tradingActivityPage.fillTradingActivitySearchInfo(selectedInstitution,institution2, user2);
        tradingActivityPage.fillTradingActivitySearchInfo(selectedInstitution,institution2);

    }

    @Then("^I should able to see the selected users for search$")
    public void iShouldAbleToSeeTheSelectedUsersForSearch(DataTable dataTable) throws Throwable {
        List<List<String>> fieldOption = dataTable.raw();
        String institution = TestData.getValue(fieldOption.get(1).get(1));
        String user = TestData.getValue(fieldOption.get(2).get(1));
        Assert.assertTrue(tradingActivityPage.validateSelectedInstitution(institution));
        Assert.assertTrue(tradingActivityPage.validateSelectedUser(user));
    }

    @Then("^I should able to see the list of events performed by the multiple user$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheMultipleUser() throws Throwable {
        String selectedUser = TestData.getValue("user1 name");
        String selectedUser2 = TestData.getValue("user2 name");
        Assert.assertTrue(tradingActivityPage.validateSelectedUserinList());
        Assert.assertTrue(tradingActivityPage.validatedSelectedUser(selectedUser));
        Assert.assertTrue(tradingActivityPage.validatedSelectedUser(selectedUser2));
    }
}
