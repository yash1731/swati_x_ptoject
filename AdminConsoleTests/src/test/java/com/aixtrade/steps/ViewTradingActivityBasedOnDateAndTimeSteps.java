package com.aixtrade.steps;

import com.aixtrade.pages.TradingActivityPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTradingActivityBasedOnDateAndTimeSteps {

    private WorldHelper helper;
    private TradingActivityPage tradingActivityPage;

    public ViewTradingActivityBasedOnDateAndTimeSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on calender to select from date$")
    public void iClickOnCalenderToSelectFromDate() throws Throwable {
        tradingActivityPage = helper.getTradingActivityPage().fromDate();
    }


    @Then("^I should able to see the current date$")
    public void iShouldAbleToSeeTheCurrentDate() throws Throwable {
        Assert.assertTrue(tradingActivityPage.validatedCurrentFromDate());
    }

    @Then("^I should able to see the time defaulted for last hour$")
    public void iShouldAbleToSeeTheTimeDefaultedForLastHour() throws Throwable {
        Assert.assertTrue(tradingActivityPage.validatedDefaultedTime());
    }

    @Then("^I click on previous month calender$")
    public void iClickOnPreviousMonthCalender() throws Throwable {
        tradingActivityPage.clickPreviousMonth();
    }

    @Then("^I select the first day of the month$")
    public void iSelectTheFirstDayOfTheMonth() throws Throwable {
       tradingActivityPage.selectFromDate();
    }

    @Then("^I select the time in hour, minutes and seconds$")
    public void iSelectTheTimeInHourMinutesAndSeconds() throws Throwable {
       tradingActivityPage.selectFromTime();
    }

    @When("^I click on calender to select to date$")
    public void iClickOnCalenderToSelectToDate() throws Throwable {
       tradingActivityPage.toDate();
       Assert.assertTrue(tradingActivityPage.validatedCurrentFromDate());
    }

    @Then("^I should able to see the current time$")
    public void iShouldAbleToSeeTheCurrentTime() throws Throwable {
        Assert.assertTrue(tradingActivityPage.validatedCurrentTime());
    }


    @Then("^I select the last day of the month$")
    public void iSelectTheLastDayOfTheMonth() throws Throwable {
       tradingActivityPage.selectTillDate();
    }

    @Then("^I select the time in hour, minutes and seconds for till date$")
    public void iSelectTheTimeInHourMinutesAndSecondsForTillDate() throws Throwable {
        tradingActivityPage.selectTillTime();
    }

    @Then("^I should able to see the list of events performed by the institutions$")
    public void iShouldAbleToSeeTheListOfEventsPerformedByTheInstitutions() throws Throwable {
       tradingActivityPage.validateSelectedUserinList();
    }

}
