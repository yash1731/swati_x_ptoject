package com.aixtrade.steps;

import com.aixtrade.pages.UsersPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ListUsersSteps {

    private WorldHelper helper;
    private UsersPage usersPage;

    public ListUsersSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the users page$")
    public void iAmOnTheUsersPage() {
        String username = TestData.getValue("tester2 email");
        String password = TestData.getValue("user password");
        usersPage = helper.getBasePage().loginWith(username, password)
                //.closeCookiePolicy()
        .goToUsersPage();
    }

    @Then("^I should be able to see a list of all the users$")
    public void iShouldBeAbleToSeeAListOfAllTheUsers() {
        Assert.assertNotNull(usersPage.viewListOfUsers());
        Assert.assertTrue(usersPage.viewListOfUsers());
    }

    @And("^I can be able to filter users entries$")
    public void iCanBeAbleToFilterUsersEntries() {
        usersPage.filterUsersEntries();
    }
}
