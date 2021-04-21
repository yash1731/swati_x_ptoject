package com.aixtrade.steps;

import com.aixtrade.pages.ForgotPasswordPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ResetPasswordSteps {

    private WorldHelper helper;
    private ForgotPasswordPage forgotPasswordPage;

    public ResetPasswordSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I click the forgot password link$")
    public void iClickTheForgotPasswordLink() {
        forgotPasswordPage = helper.getBasePage().goToForgotPasswordPage();
    }

    @And("^I enter and submit \"([^\"]*)\" on the reset password page$")
    public void iEnterAndSubmitOnTheResetPasswordPage(String userEmail) {
        userEmail = TestData.getValue(userEmail);
        forgotPasswordPage.submitPasswordReset(userEmail);
    }

    @Then("^I should be able to see a \"([^\"]*)\" that lets user know email has been sent for password request$")
    public void iShouldBeAbleToSeeAThatLetsUserKnowEmailHasBeenSentForPasswordRequest(String message) {
        message = TestData.getValue(message);
        assertThat(forgotPasswordPage.validateResetPasswordMessage(message), is(true));
    }
}
