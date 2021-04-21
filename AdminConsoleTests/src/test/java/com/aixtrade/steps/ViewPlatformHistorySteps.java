package com.aixtrade.steps;

import com.aixtrade.pages.PlatformControlPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ViewPlatformHistorySteps {

    private WorldHelper helper;
    private PlatformControlPage platformControl;

    public ViewPlatformHistorySteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I click on history tab in platform control$")
    public void iClickOnHistoryTabInPlatformControl() throws Throwable {
       platformControl = helper.getPlatformControlPage().clickHistoryTab();
    }

    @Then("^I validate the list of restrictions performed in platform control$")
    public void iValidateTheListOfRestrictionsPerformedInPlatformControl() throws Throwable {
        Assert.assertTrue(platformControl.viewListOfPlatformStates());
    }


}
