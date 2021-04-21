package com.aixtrade.steps;

import com.aixtrade.pages.BasePage;
import com.aixtrade.pages.HomePage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogoutSteps {

    private WorldHelper helper;
    private BasePage basePage;
    private HomePage landingPage;

    public LogoutSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        landingPage = helper.getBasePage().loginWith(username, password)
                //.closeCookiePolicy()
        ;
    }

    @When("^I click the sign out button$")
    public void iClickTheSignOutButton() {
        basePage = landingPage.logOut();
    }

    @Then("^I should be able to successfully sign out and navigated to the login page$")
    public void iShouldBeAbleToSuccessfullySignOutAndNavigatedToTheLoginPage() {
        assertThat(basePage.validateLogout(), is(true));
    }
}
