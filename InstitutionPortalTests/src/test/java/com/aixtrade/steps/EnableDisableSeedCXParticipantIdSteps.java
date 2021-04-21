package com.aixtrade.steps;

import com.aixtrade.pages.*;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EnableDisableSeedCXParticipantIdSteps {

    private WorldHelper helper;
    private ApplicationInfoPage applicationInfoPage;
    private AuthorisedSignersPage authorisedSignersPage;

    public EnableDisableSeedCXParticipantIdSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the Applications page$")
    public void iAmOnTheApplicationsPage() {
        String username = TestData.getValue("user email");
        String password = TestData.getValue("user password");
        applicationInfoPage = helper
                .getBasePage()
                .loginWith(username, password)
                .clickToApply()
                .continueApplication()
                .tickCheckbox()
                .saveAndProceedToAppInfo();
    }

    @When("^I disable the SeedCX Participant ID field$")
    public void iDisableTheSeedCXParticipantIDField() {
        applicationInfoPage.disableOrEnableSeedCXParticipantId();
    }

    @And("^I select to proceed to the next page$")
    public void iSelectToProceedToTheNextPage() {
        authorisedSignersPage = applicationInfoPage.goToAuthorisedSignersPage();
    }

    @Then("^I can successfully proceed to the \"([^\"]*)\" page$")
    public void iCanSuccessfullyProceedToThePage(String authSigners) {
        assertThat(authorisedSignersPage.validateAuthorisedSignersPage(authSigners), is(true));
    }

    @When("^I go back to the Applications page and I enable the SeedCX Participant ID field$")
    public void iGoBackToTheApplicationsPageAndIEnableTheSeedCXParticipantIDField() {
        applicationInfoPage = authorisedSignersPage
                .goBackToAppInfoPage()
                .disableOrEnableSeedCXParticipantId();
    }

    @Then("^I should see \"([^\"]*)\" displayed$")
    public void iShouldSeeDisplayed(String error) {
        error = TestData.getValue(error);
        assertThat(applicationInfoPage.validateSeedCXIDErrorMessage(error), is(true));
    }

    @When("^I then enter a \"([^\"]*)\"$")
    public void iThenEnterA(String seedCXId) {
        seedCXId = TestData.getValue(seedCXId);
        applicationInfoPage.enterSeedCXParticipantId(seedCXId);
    }
}
