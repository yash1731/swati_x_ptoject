package com.aixtrade.steps;

import com.aixtrade.pages.InstitutionsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EnableBalanceChecksSteps {

    private WorldHelper helper;
    private InstitutionsPage institutionsPage;

    public EnableBalanceChecksSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I disable the balance check$")
    public void iDisableTheBalanceCheck() throws Throwable {
      institutionsPage = helper.getInstitutionsPage().disableBalanceCheck();
    }

    @When("^I enable the balance Check$")
    public void iEnableTheBalanceCheck() throws Throwable {
        institutionsPage = helper.getInstitutionsPage().disableBalanceCheck();
    }

    @Then("^Balance check signal is enabled in the institutions list$")
    public void balanceCheckSignalIsEnabledInTheInstitutionsList() throws Throwable {
        Assert.assertTrue(institutionsPage.verifyBalanceCheckEnabled());
    }


}
