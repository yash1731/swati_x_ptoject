package com.aixtrade.steps;

import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.aixtrade.pages.BasePage;
import com.aixtrade.pages.HomePage;
import com.aixtrade.support.WorldHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps {

    private WorldHelper helper;
    private BasePage basePage;
    private HomePage landingPage;

    public LoginSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        basePage = helper.getBasePage();
    }

    @When("^I login with \"([^\"]*)\" & \"([^\"]*)\"$")
    public void iLoginWith(String username, String password) {
        username = TestData.getValue(username);
        password = TestData.getValue(password);
        landingPage = basePage.loginWith(username, password);
    }

    @Then("^I should be able to see the text \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheText(String loginMessage) {
        loginMessage = TestData.getValue(loginMessage);
        assertThat(landingPage.validateLogin(loginMessage), is(true));
    }
}
