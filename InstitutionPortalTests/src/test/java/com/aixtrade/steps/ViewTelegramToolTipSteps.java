package com.aixtrade.steps;

import com.aixtrade.pages.UsersPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ViewTelegramToolTipSteps {

    private WorldHelper helper;
    private UsersPage usersPage;

    public ViewTelegramToolTipSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click on telegram tooltip$")
    public void iClickOnTelegramTooltip() throws Throwable {
       usersPage = helper.getUsersPage().markUserAsApersonnel("tester11").clickTelegramToolTip();
    }

    @Then("^Verify the text \"([^\"]*)\"$")
    public void verifyTheText(String message) throws Throwable {
        Assert.assertTrue(usersPage.verifyTelegramTooltip(message));
    }

    @Then("^I click on Close tooltip button$")
    public void iClickOnCloseTooltipButton() throws Throwable {
       usersPage.closeToolTip();
    }



}
