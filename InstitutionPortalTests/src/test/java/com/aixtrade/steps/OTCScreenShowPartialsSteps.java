package com.aixtrade.steps;

import com.aixtrade.pages.OTCScreenPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OTCScreenShowPartialsSteps {

    private WorldHelper helper;
    private OTCScreenPage otcScreenPage;

    public OTCScreenShowPartialsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^Verify 'Show Partial' button is disabled$")
    public void verifyShowPartialButtonIsDisabled() throws Throwable {
        otcScreenPage = helper.getOTCScreenPage().verifyPartialsButton();
    }

    @When("^I enable 'Show Partials' button$")
    public void iEnableShowPartialsButton() throws Throwable {
        otcScreenPage.enableShowPartials();
    }

    @Then("^Verify 'Show Partials' button is disabled$")
    public void verifyShowPartialsButtonIsDisabled() throws Throwable {
       otcScreenPage.verifyPartialsButton();
    }

    @Then("^I can disable 'Show Partials' button$")
    public void iCanDisableShowPartialsButton() throws Throwable {
        otcScreenPage.enableShowPartials();
    }
}
