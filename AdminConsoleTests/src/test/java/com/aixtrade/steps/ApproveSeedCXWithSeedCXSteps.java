package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.support.WorldHelper;
import com.aixtrade.utilities.TestData;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ApproveSeedCXWithSeedCXSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;

    public ApproveSeedCXWithSeedCXSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Then("^I should be able to see the seedCX validation message$")
    public void iShouldBeAbleToSeeTheSeedCXValidationMessage() throws Throwable {
       String seedCXMessage = TestData.getValue("seedCXValidation message");
        Assert.assertTrue(helper.getApplicationsPage().validateSeedCXValidationMessage(seedCXMessage));
    }

}
