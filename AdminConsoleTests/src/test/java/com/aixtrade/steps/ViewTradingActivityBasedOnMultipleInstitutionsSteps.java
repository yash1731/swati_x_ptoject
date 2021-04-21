package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ViewTradingActivityBasedOnMultipleInstitutionsSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivityBasedOnMultipleInstitutionsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the multiple institutions to view trading activities shown below:$")
    public void iSelectTheMultipleInstitutionsToViewTradingActivitiesShownBelow(DataTable dataTable) throws Throwable {
        List<List<String>> searchDetails = dataTable.raw();
        String selectInstitution = TestData.getValue("select institution");
        String institution1 = TestData.getValue(searchDetails.get(1).get(1));
        String institution2 = TestData.getValue(searchDetails.get(2).get(1));
        tradingActivityPage = helper.getTradingActivityPage().fillTradingActivitySearchByMultipleInstitutions(selectInstitution, institution1, institution2);
    }

    @Then("^I should able to see the list of events performed by the selected multiple institutions$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheSelectedMultipleInstitutions() throws Throwable {
       String institution1 = TestData.getValue("institution1 name");
       String institution2 = TestData.getValue("institution2 name");
        Assert.assertTrue(tradingActivityPage.validateInstitutions(institution1,institution2));
    }

}
