package com.aixtrade.steps;

import com.aixtrade.pages.UsersPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DuplicateCannelIdSteps {

    private WorldHelper helper;
    private UsersPage usersPage;

    public DuplicateCannelIdSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I add duplicate telegram and fix id to selected user$")
    public void iAddDuplicateTelegramAndFixIdToSelectedUser() throws Throwable {
      String user = TestData.getValue("duplication user");
      String telegram = TestData.getValue("telegram1 id");
      //String symphony = TestData.getValue("symphony1 id");
      //String fix = TestData.getValue("fix1 id");
      usersPage = helper.getUsersPage().markUserAsApersonnel(user).enterChannelsId(telegram);
    }

    @Then("^Verify the duplication validation message text$")
    public void verifyTheDuplicationValidationMessageText() throws Throwable {
        String message = TestData.getValue("duplication text");
        usersPage.validateDuplicationText(message);
    }

}
