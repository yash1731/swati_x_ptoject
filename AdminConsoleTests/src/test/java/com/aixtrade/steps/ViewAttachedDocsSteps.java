package com.aixtrade.steps;

import com.aixtrade.pages.ApplicationsPage;
import com.aixtrade.support.WorldHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ViewAttachedDocsSteps {

    private WorldHelper helper;
    private ApplicationsPage applicationsPage;

    public ViewAttachedDocsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("^I select the Document page$")
    public void iSelectTheDocumentPage() {
        applicationsPage= helper.getApplicationsPage().selectDocumentPage();
    }

    @Then("^I should be able to see client's attached documents$")
    public void iShouldBeAbleToSeeClientSAttachedDocuments() throws Throwable {
        assertThat(applicationsPage.validateRequiredDocumentLists(), is(true));
    }

    @And("^I can see 'View Document' button for all required documents$")
    public void iCanSeeViewDocumentButtonForAllRequiredDocuments() {
        assertThat(applicationsPage.validateViewDocumentButton(), is(true));
    }
}
